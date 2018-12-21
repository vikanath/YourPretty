package com.example.acer.yourpretty;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginnya extends AppCompatActivity {
    DataHelper dbHelper; //membuat variabel dbHelper dari class DataHelper
    private Button loginBut; //membuat atribut untuk button login dan button logout
    private EditText user, pass; //membuat atribut untuk edit text user dan password
    SessionManagement sessionManagement; //membuat variabel session dari class sessionManagement

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginnya);

        user = (EditText) findViewById(R.id.userLogin); //instansiasi objek yang memanggil id edit text username
        pass = (EditText) findViewById(R.id.PasswordLogin); //instansiasi objek yang memanggil id edit text password

        dbHelper = new DataHelper(this); //instansiasi objek datahelper

        sessionManagement = new SessionManagement(loginnya.this);

        if (sessionManagement.isLoggedIn()) {
            Intent i = new Intent(getApplicationContext(), home.class);
            startActivity(i);
        }
        loginBut = (Button) findViewById(R.id.buttonLogin); //instansiasi objek yang memanggil id button login

        loginBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();

                b.putString("username", user.getText().toString()); //memanggil kolom nama pada sql
                b.putString("password", pass.getText().toString()); //memanggil kolom password pada sql
                if (CekLogin()) {
                    if (cekValidasi()) {
                        Toast.makeText(getApplicationContext(), "True", Toast.LENGTH_SHORT).show(); //membuat toast notifikasi login benar
                        Intent i = new Intent(getApplicationContext(), home.class); //membut intent button login berpindah ke halaman Halo Activity
                        sessionManagement.createLoginSession(user.getText().toString(), pass.getText().toString()); //memanggil session untuk membaca username dan password
                        i.putExtras(b);
                        startActivity(i);
                        finish();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "You are not registed", Toast.LENGTH_SHORT).show(); //membuat noti
                }
            }
        });
    }

    public boolean CekLogin() {
        SessionManagement sessionManagement = new SessionManagement(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from akundiri WHERE username='" + user.getText().toString() + "' and password='" + pass.getText().toString()+"'", null);
        sessionManagement.createLoginSession(user.getText().toString(), pass.getText().toString());

        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public boolean cekValidasi() {
        if (user.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Fill the Username", Toast.LENGTH_SHORT).show();
            return false;
        } else if (pass.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Fill the Password", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//    }
//
////    Ketika sebuah activity dibuat, pada method ini dilakukan inisialisasi seperti create view, list data,
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Toast.makeText(this,"App onStart", Toast.LENGTH_SHORT).show();
//    }
//
////    Ketika sebuah activity dipanggil sebelum diperlihatkan ke user.
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Toast.makeText(this,"App onRestart", Toast.LENGTH_SHORT).show();
//    }
//
////    Ketika sebuah activity dihentikan, dan merupakan prioritas untuk memanggil activity itu kembali.
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Toast.makeText(this,"App onResume", Toast.LENGTH_SHORT).show();
//    }
//
////    Ketika sebuah activity start/mulai melakukan interaksi dengan user, pada saat ini activity berada pada
////    posisi teratas dari activity stack yang mana user akan melakukan input.
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Toast.makeText(this,"App onPause", Toast.LENGTH_SHORT).show();
//    }
//
////    Ketika sebuah activity lainnya dipanggil/dimulai, method ini
////    digunakan ketika data tidak harus disimpan ke dalam sistem secara permanen.
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(this,"App onStop", Toast.LENGTH_SHORT).show();
//    }
//
////    Ketika sebuah acivity tidak lagi dibutuhkan/tidak terlihat lagi oleh user.
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(this,"App onDestroy", Toast.LENGTH_SHORT).show();
//    }
