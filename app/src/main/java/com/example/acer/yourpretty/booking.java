package com.example.acer.yourpretty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class booking extends AppCompatActivity {
    Intent intent; //membuat variabel intent
    ListView mListView2; //membuat variabel listview
    //membuat variabel integer untuk membaca image pada listview
    int[] images2 = {R.drawable.arindika, R.drawable.vikarista, R.drawable.erma, R.drawable.bykirana, R.drawable.beautyfifin};
    //membuat variabel String untuk membaca text pada listview
    String[] Names2 = {"ArindikaMakeup",
            "VikaristaMakeup",
            "ErmaMakeup",
            "MakeupByKirana",
            "Beautyfifin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        //membuat arrayadapter pada listview untuk menetukan letak posisi data sesuai layout berdasarkan array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(booking.this,android.R.layout.simple_list_item_1, Names2);

        //instansiasi objek listview
        mListView2 = (ListView) findViewById(R.id.listbooking);

        //instasi custom adapter untuk mengedit isi dari adapter
        CustomAdapter customAdapter = new CustomAdapter();
        mListView2.setAdapter(customAdapter); //memasukkan objek adapater pada objek listview
    }

    class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return images2.length; } //untuk meload image pada listview berdasarkan posisi

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.mylist, null); //membuat view layout berdasarkan mylist.xml

            ImageView im = view.findViewById(R.id.icon); //instansiasi image view
            TextView mTextView = view.findViewById(R.id.Itemname); //instansiasi text view
            im.setImageResource(images2[position]); //menentukan image view sesuai posisi
            mTextView.setText(Names2[position]); //menentukan image view sesuai posisi

            //menentukan intent berpindah sesuai array
            mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override

                public void onItemClick(AdapterView<?> parent, View view, int p, long id) {
                    if (p == 0) {
                        intent = new Intent(booking.this, DetailArindika.class);
                        startActivity(intent);
                    } else if (p == 1) {
                        intent = new Intent(booking.this, DetailVikaRista.class);
                        startActivity(intent);
                    } else if (p == 2) {
                        intent = new Intent(booking.this, DetailErma.class);
                        startActivity(intent);
                    } else if (p == 3) {
                        intent = new Intent(booking.this, DetailKirana.class);
                        startActivity(intent);
                    } else if (p == 4) {
                        intent = new Intent(booking.this, DetailFifin.class);
                        startActivity(intent);
                    } else {
                        Toast t = Toast.makeText(booking  .this, Names2[p], Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
                        t.show();
                    }
                }
            });

            return view;
        }
    }
}
