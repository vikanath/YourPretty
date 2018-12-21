package com.example.acer.yourpretty;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailFifin extends AppCompatActivity {
    //membuat variabel textview, button, String
    TextView txtname;
    Button butbooknow, butmaps;
    private String KEY_NAME = "NAMA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fifin);

        //instansiasi textview
        txtname = (TextView) findViewById(R.id.penjelasan3);

        //instansiasi objek button dan parsing data
        butbooknow =(Button)findViewById(R.id.buttonbooking3);
        butbooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String nama = txtname.getText().toString();
                Intent i = new Intent(DetailFifin.this, Date.class);
                i.putExtra("nama",nama);
                startActivity(i);
            }
        });

        //instansiasi button untuk membuka aplikasi gmaps
        butmaps =(Button)findViewById(R.id.mapsfifin);
        butmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);

                i.setData(Uri.parse("https://www.google.com/maps/place/Jl.+Raya+Surabaya+-+Malang,+Jawa+Timur/@-7.6270424,112.6854761,17z/data=!3m1!4b1!4m5!3m4!1s0x2dd7d136d1c254e5:0xee8ce237973a1bc5!8m2!3d-7.6270424!4d112.6876648?hl=id"));
                startActivity(i);
            }
        });
    }
}
