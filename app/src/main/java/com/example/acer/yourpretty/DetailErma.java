package com.example.acer.yourpretty;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailErma extends AppCompatActivity {
    //membuat variabel textview, button, String
    TextView txtname;
    Button butbooknow, butmaps;
    private String KEY_NAME = "NAMA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_erma);

        //instansiasi textview
        txtname = (TextView) findViewById(R.id.penjelasan2);

        //instansiasi button
        butbooknow =(Button)findViewById(R.id.buttonbooking2);
        butbooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String nama = txtname.getText().toString();
                Intent i = new Intent(DetailErma.this, Date.class);
                i.putExtra("nama",nama);
                startActivity(i);
            }
        });

        //instansiasi button untuk membuka aplikasi gmaps
        butmaps =(Button)findViewById(R.id.mapserma);
        butmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);

                i.setData(Uri.parse("https://www.google.com/maps/place/Kabupaten+Gresik,+Jawa+Timur/data=!4m2!3m1!1s0x2e77fbfe0d49ca51:0x3027a76e352bed0?ved=2ahUKEwinnair1qrfAhWLrY8KHTswDZgQ8gEwAHoECAMQAQ"));
                startActivity(i);
            }
        });
    }
}
