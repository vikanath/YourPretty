package com.example.acer.yourpretty;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailArindika extends AppCompatActivity {
    //membuat variabel textview, button, String
    TextView txtname;
    Button butbooknow, butmaps;
    private String KEY_NAME = "NAMA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_arindika);

        //instansiasi textview
        txtname = (TextView) findViewById(R.id.penjelasan);

        //instansiasi objek button dan parsing data
        butbooknow =(Button)findViewById(R.id.buttonbooking);
        butbooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String nama = txtname.getText().toString(); //instansiasi objek string untuk di parsing
                Intent i = new Intent(DetailArindika.this, Date.class);
                i.putExtra("nama",nama); //mengirim parsing
                startActivity(i);
            }
        });

        //instansiasi button untuk membuka aplikasi gmaps
        butmaps =(Button)findViewById(R.id.mapsarin);
        butmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);

                i.setData(Uri.parse("https://www.google.com/maps/place/Jl.+Danau+Gita,+Kedungkandang,+Kota+Malang,+Jawa+Timur+65139/@-7.9751639,112.6629556,17z/data=!3m1!4b1!4m5!3m4!1s0x2dd6285f2b9ef657:0x3682c5e5180fbe18!8m2!3d-7.9751639!4d112.6651443"));
                startActivity(i);
            }
        });
    }
}
