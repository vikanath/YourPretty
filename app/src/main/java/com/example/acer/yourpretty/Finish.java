package com.example.acer.yourpretty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Finish extends AppCompatActivity {
    //membuat variabel textview, String, button
    TextView txtname, txtdate, txttime, txtnotes;
    private String nama, tanggal, jam, notes;
    private String KEY_NAME = "NAMA";
    private String KEY_DATE = "DATE";
    private String KEY_TIME = "TANGGAL";

    Button buttonbok, but11, but22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        //instansiasi objek textview
        txtname = (TextView) findViewById(R.id.txtnya1);
        txtdate = (TextView) findViewById(R.id.txtnya2);
        txttime = (TextView) findViewById(R.id.txtnya2b);
        txtnotes =(TextView) findViewById(R.id.txtnya5);

        //membuat instansiasi objek intent untuk menerima data parsing data activity lain
        Intent i = getIntent();
        Bundle extras = getIntent().getExtras();
        nama = i.getStringExtra("nama");
        tanggal = i.getStringExtra("tanggal");
        jam = i.getStringExtra("jam");
        notes = i.getStringExtra("notes");
        txtname.setText(nama);
        txtdate.setText(tanggal);
        txttime.setText(jam);
        txtnotes.setText(notes);

        //membuat instansiasi objek button
        but11 = (Button) findViewById(R.id.but11);
        but11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String nama = txtname.getText().toString(); //membuat objek string untuk mengirim data string pada text view nama
                Intent i = new Intent(Finish.this, Date.class);
                i.putExtra("nama",nama); //mengirim parsing
                startActivity(i);
            }
        });

        //membuat instansiasi objek button
        but22 = (Button) findViewById(R.id.but22);
        but22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //membuat objek string untuk mengirim data string pada text view nama
                String nama = txtname.getText().toString();
                String tanggal = txtdate.getText().toString();
                String jam = txttime.getText().toString();
                String notes = txtnotes.getText().toString();
                Intent i = new Intent(Finish.this, BookingDetails.class);
                i.putExtra("nama",nama);
                i.putExtra("tanggal",tanggal);
                i.putExtra("jam", jam);
                i.putExtra("notes", notes);
                startActivity(i);
            }
        });

        buttonbok = (Button) findViewById(R.id.bt_bookapp);
        buttonbok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(Finish.this, Ending.class);
                startActivity(i);

            }
        });
    }
}
