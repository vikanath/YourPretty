package com.example.acer.yourpretty;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class update_biodata extends AppCompatActivity {
    //membuat variabel cursor, datahelper, button, edittext
    Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2;
    EditText text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_biodata);

        //instansiasi objek edittext, button
        dbHelper = new DataHelper(this); //instansiasi datahelper pada class ini(this)
        text1 = (EditText) findViewById(R.id.editText11);
        text2 = (EditText) findViewById(R.id.editText22);
        text3 = (EditText) findViewById(R.id.editText33);
        text4 = (EditText) findViewById(R.id.editText44);
        text5 = (EditText) findViewById(R.id.editText55);

        SQLiteDatabase db = dbHelper.getReadableDatabase(); //instansiasi sqlite
        cursor = db.rawQuery("SELECT * FROM akundiri WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        ton1 = (Button) findViewById(R.id.button11);
        ton2 = (Button) findViewById(R.id.button22);
        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update akundiri set nama='"+
                        text2.getText().toString() +"', username='" +
                        text3.getText().toString()+"', email='"+
                        text4.getText().toString() +"', password='" +
                        text5.getText().toString() + "' where no='" +
                        text1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil",
                        Toast.LENGTH_LONG).show();
                createakun.ma.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// TODO Auto-generated method stub
                finish();
            }
        });
    }
}
