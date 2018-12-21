package com.example.acer.yourpretty;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Date extends AppCompatActivity {
    //membuat variabel textview, string, button, datepicker
    TextView txtname, txtdate;

    private String nama;
    private String KEY_NAME = "NAMA";
    private String KEY_DATE = "TANGGAL";


    Button butselectdate, but2, but3;

    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private Button btDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        txtname = (TextView) findViewById(R.id.name);
        txtdate = (TextView) findViewById(R.id.tgl);

        Intent i = getIntent();
        Bundle extras = getIntent().getExtras();
        nama = i.getStringExtra("nama");
        txtname.setText(nama);

        //instansiasi button untuk berpindah halaman dan mengirim data
        but2 = (Button) findViewById(R.id.but2);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //instansiasi objek string untuk di parsing
                String nama = txtname.getText().toString();
                String tanggal = txtdate.getText().toString();
                Intent i = new Intent(Date.this, BookingDetails.class);
                //mengirim parsing
                i.putExtra("nama",nama);
                i.putExtra("tanggal",tanggal);
                startActivity(i);
            }
        });

        //instansiasi button untuk berpindah halaman dan mengirim data
        but3 = (Button) findViewById(R.id.but3);
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String nama = txtname.getText().toString(); //instansiasi objek string untuk di parsing
                Intent i = new Intent(Date.this, Finish.class);
                i.putExtra("nama",nama); //mengirim parsing
                startActivity(i);
            }
        });

        //instansiasi button untuk berpindah halaman dan mengirim data
        butselectdate = (Button) findViewById(R.id.buttonselectdate);
        butselectdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //instansiasi objek string untuk di parsing
                String nama = txtname.getText().toString();
                String tanggal = txtdate.getText().toString();
                Intent i = new Intent(Date.this, BookingDetails.class);
                //mengirim parsing
                i.putExtra("nama",nama);
                i.putExtra("tanggal",tanggal);
                startActivity(i);
            }
        });
        //datepicker
        /**
         * Kita menggunakan format tanggal dd-MM-yyyy
         * jadi nanti tanggal nya akan diformat menjadi
         * misalnya 01-12-2017
         */
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        tvDateResult = (TextView) findViewById(R.id.tgl);
        btDatePicker = (Button) findViewById(R.id.bt_datepicker);
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });
    }

    private void showDateDialog() {

        /**
         * Calendar untuk mendapatkan tanggal sekarang
         */
        Calendar newCalendar = Calendar.getInstance();

        /**
         * Initiate DatePicker dialog
         */
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                /**
                 * Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                 */

                /**
                 * Set Calendar untuk menampung tanggal yang dipilih
                 */
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                /**
                 * Update TextView dengan tanggal yang kita pilih
                 */
                tvDateResult.setText("The Date : " + dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        /**
         * Tampilkan DatePicker dialog
         */
        datePickerDialog.show();
    }
}
