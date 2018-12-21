package com.example.acer.yourpretty;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Ending extends AppCompatActivity {
    //membuat variabel untuk load waktu
    private int waktu_loading=4000;

    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke login activity
                Intent i=new Intent(Ending.this, login.class);
                startActivity(i);
//                finish();

            }
        },waktu_loading);
    }
}
