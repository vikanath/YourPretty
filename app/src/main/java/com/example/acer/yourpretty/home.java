package com.example.acer.yourpretty;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.HashMap;

public class home extends AppCompatActivity {
    //membuat variabel session, button
    SessionManagement sessionManagement;
    Button buttonLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonLogout = (Button) findViewById(R.id.buttonlogout);

        // Session class instance
        sessionManagement = new SessionManagement(getApplicationContext());

        // Button logout

        Toast.makeText(getApplicationContext(), "User Login Status: " + sessionManagement.isLoggedIn(), Toast.LENGTH_LONG).show();

        /**
         * Call this function whenever you want to check user login
         * This will redirect user to LoginActivity is he is not
         * logged in
         * */
        sessionManagement.checkIsLogin();
//        buttonLogout.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                // Clear the session data
//                // This will clear all session data and
//                // redirect user to LoginActivity
//                sessionManagement.logoutUser();
//            }
//        });
        buttonLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Clear the session data
                // This will clear all session data and
                // redirect user to LoginActivity
                sessionManagement.logoutUser();
            }
        });

        Button btnlogin=(Button)findViewById(R.id.button1);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(home.this, makeup.class);
                startActivity(i);
            }
        });

        Button btncr=(Button)findViewById(R.id.button2);
        btncr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(home.this, booking.class);
                startActivity(i);
            }
        });

        Button btnmaps=(Button)findViewById(R.id.mapsku);
        btnmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(home.this, MapsActivity.class);
                startActivity(i);
            }
        });
    }
}
