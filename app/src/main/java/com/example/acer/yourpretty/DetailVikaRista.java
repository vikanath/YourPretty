package com.example.acer.yourpretty;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailVikaRista extends AppCompatActivity {
    TextView txtname; //variabel untuk membaca textview nama
    Button butbooknow, butmaps; //membuat variabel untuk button booking, dan button maps
    private String KEY_NAME = "NAMA"; //membuat variabel untuk mengirim text nama
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_vika_rista);

        txtname = (TextView) findViewById(R.id.penjelasan5); //instansiasi objek

        butbooknow =(Button)findViewById(R.id.buttonbooking5); //instansiasi button booking
        butbooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String nama = txtname.getText().toString(); //membuat objek string untuk mengirim data string pada text view nama
                Intent i = new Intent(DetailVikaRista.this, Date.class);
                i.putExtra("nama",nama); //mengirim string nama
                startActivity(i);
            }
        });

        //instansiasi button untuk membuka aplikasi gmaps
        butmaps =(Button)findViewById(R.id.mapsvika); //instansiasi button maps
        butmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);

                i.setData(Uri.parse("https://www.google.com/maps/place/Jl.+Danau+Maninjau+Raya,+Sawojajar,+Kedungkandang,+Kota+Malang,+Jawa+Timur+65139/data=!4m2!3m1!1s0x2dd6285c8f0cdf47:0x80e4614aa52d736?ved=2ahUKEwjBtNiN1qrfAhWGr48KHdrPAPgQ8gEwAHoECAAQAQ"));
                startActivity(i);
            }
        });
    }
}
