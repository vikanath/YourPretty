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

import java.util.ArrayList;

public class makeup extends AppCompatActivity {

    Intent intent; //membuat variabel intent
    ListView mListView; //membuat variabel listview
    //membuat variabel integer untuk membaca image pada listview
    int[] images = {R.drawable.natural, R.drawable.smokey, R.drawable.wedding};
    //membuat variabel String untuk membaca text pada listview
    String[] Names = {"Natural", "Smokey", "Wedding"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);

        //membuat arrayadapter pada listview untuk menetukan letak posisi data sesuai layout berdasarkan array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(makeup.this,android.R.layout.simple_list_item_1, Names);

        //instansiasi objek listview
        mListView = (ListView) findViewById(R.id.list);

        //instasi custom adapter untuk mengedit isi dari adapter
        CustomAdapter customAdapter = new CustomAdapter();
        // set data
        mListView.setAdapter(customAdapter); //memasukkan objek adapater pada objek listview
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
        } //untuk meload image pada listview berdasarkan posisi

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

            //instansiasi objek berdasarkan id layout
            ImageView im = view.findViewById(R.id.icon);
            TextView mTextView = view.findViewById(R.id.Itemname);
            im.setImageResource(images[position]);
            mTextView.setText(Names[position]);

            //menentukan intent berpindah sesuai array
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override

                public void onItemClick(AdapterView<?> parent, View view, int p, long id) {
                    if (p == 0) {
                        intent = new Intent(makeup.this, Naturalook.class);
                        startActivity(intent);
                    } else if (p == 1) {
                        intent = new Intent(makeup.this, Smokeylook.class);
                        startActivity(intent);
                    } else if (p == 2) {
                        intent = new Intent(makeup.this, Weddinglook.class);
                        startActivity(intent);
                    } else {
                        Toast t = Toast.makeText(makeup.this, Names[p], Toast.LENGTH_SHORT);
                        t.setGravity(Gravity.CENTER|Gravity.CENTER, 0, 0);
                        t.show();
                    }
                }
            });

            return view;
        }
    }
}
