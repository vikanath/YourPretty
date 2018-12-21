package com.example.acer.yourpretty;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailKirana extends AppCompatActivity {
    //membuat variabel textview, button, String
    TextView txtname;
    Button butbooknow, butmaps;
    private String KEY_NAME = "NAMA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kirana);

        //instansiasi textview
        txtname = (TextView) findViewById(R.id.penjelasan4);

        //instansiasi objek button dan parsing data
        butbooknow =(Button)findViewById(R.id.buttonbooking4);
        butbooknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String nama = txtname.getText().toString();
                Intent i = new Intent(DetailKirana.this, Date.class);
                i.putExtra("nama",nama);
                startActivity(i);
            }
        });

        //instansiasi button untuk membuka aplikasi gmaps
        butmaps =(Button)findViewById(R.id.mapskirana);
        butmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);

                i.setData(Uri.parse("https://www.google.com/maps/place/Kepanjen,+Malang,+Jawa+Timur/data=!4m2!3m1!1s0x2e789fabb4daecb7:0x437571a2a7a2342b?ved=2ahUKEwjwlbG_1qrfAhWHpY8KHQ_DAnYQ8gEwAHoECAAQAQ"));
                startActivity(i);
            }
        });
    }
}
