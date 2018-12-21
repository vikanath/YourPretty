package com.example.acer.yourpretty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //instansiasi button login
        Button btnlogin=(Button)findViewById(R.id.bt_login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(login.this, loginnya.class);
                startActivity(i);
            }
        });

        //instansiasi button create akun
        Button btncr=(Button)findViewById(R.id.bt_createakun);
        btncr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(login.this, createakun.class);
                startActivity(i);
            }
        });
    }
}