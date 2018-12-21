package com.example.acer.yourpretty;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by ACER on 12/15/2018.
 */

public class SessionManagement {
        //Share preference
        private SharedPreferences mSharedPreference;
        //Editor for Shared preference
        private SharedPreferences.Editor mEditor;
        //context
        public Context mContext;
        //Shared pref mode
        int PRIVATE_MODE;
        //Shared pref name
        private static final String PREF_NAME = "SharedPrefLatihan";
        //Shared Preferences Keys
        private static final String IS_LOGIN = "IsLoggedIn";
        public static final String KEY_USERNAME = "username";
        public static final String KEY_PASSWOrD = "username";

        public SessionManagement(Context mContext) {
            this.mContext = mContext;
            mSharedPreference = this.mContext.getSharedPreferences(PREF_NAME,
                    PRIVATE_MODE);
            mEditor = mSharedPreference.edit();
        }

        public void createLoginSession(String username, String password) {
            // Storing login value as TRUE
            mEditor.putBoolean(IS_LOGIN, true);
            // Storing email
            mEditor.putString(KEY_USERNAME, password);
            // Storing password
            mEditor.putString(KEY_PASSWOrD, username);
            mEditor.commit();
        }

        public HashMap<String, String> getUserInformation() {
            HashMap<String, String> user = new HashMap<String, String>();
            // user email
            user.put(KEY_USERNAME, mSharedPreference.getString(KEY_USERNAME, null));
            // user password
            user.put(KEY_PASSWOrD, mSharedPreference.getString(KEY_PASSWOrD,
                    null));
            // return user
            return user;
        }

        public boolean isLoggedIn() {
            return mSharedPreference.getBoolean(IS_LOGIN, false);
        }

        public void checkIsLogin() {
            // Check login status
            if (!isLoggedIn()) {
                // user is not logged in redirect to MainActivity
                Intent i = new Intent(mContext, home.class);
                // Closing all the Activities
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                // Add new Flag to start new Activity
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(i);
            }
        }

        public boolean logoutUser() {
            // Clear all data
            mEditor.clear();
            mEditor.commit();

            //After logout redirect user to login activity
            Intent i = new Intent(mContext, loginnya.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(i);
            return false;
        }
}
