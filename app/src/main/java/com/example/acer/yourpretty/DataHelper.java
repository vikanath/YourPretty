package com.example.acer.yourpretty;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ACER on 12/10/2018.
 */
    //class untuk membuat database
    public class DataHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "akun.db";
        private static final int DATABASE_VERSION = 1;
        public DataHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
// TODO Auto-generated constructor stub
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub
            String sql = "create table akundiri(no integer primary key, nama text null, username text null, email text null, password text null);";
            Log.d("Data", "onCreate: " + sql);
            db.execSQL(sql);
            sql = "INSERT INTO akundiri (no, nama, username, email, password) VALUES ('1', 'Nama anda', 'username anda', 'email anda', 'password anda');";
            db.execSQL(sql);
        }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
// TODO Auto-generated method stub
    }
}
