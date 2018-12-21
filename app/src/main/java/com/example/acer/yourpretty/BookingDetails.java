package com.example.acer.yourpretty;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookingDetails extends AppCompatActivity {
    TextView txtname, txtdate, txttime; //membuat variabel textview
    EditText txtnotes; //membuat variabel edittext
    private String nama, tanggal; //membuat variabel String untuk mengirim data nama dan tanggal
    private String KEY_NAME = "NAMA"; //membuat variabel String untuk menyimpan data nama
    private String KEY_DATE = "DATE"; //membuat variabel String untuk menyimpan data tanggal
    private String KEY_TIME = "TIME"; //membuat variabel String untuk menyimpan data WAKTU
    private TextView tvTimeResult; //membuat variabel untuk result dari timepicker
    private Button btTimePicker; //membuat variabel button untuk membuat result timepicker
    private TimePickerDialog timePickerDialog; //membuat variabel agar hasil dari timepicker bisa menjadi String dialog

    Button butbok, but1, but33; //membuat variabel Button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        //instansi textview dan edit text
        txtname = (TextView) findViewById(R.id.textNamenya);
        txtdate = (TextView) findViewById(R.id.textDatenya);
        txttime = (TextView) findViewById(R.id.textTime);
        txtnotes = (EditText) findViewById(R.id.editTextNotes);

        //instansiasi intent untuk menerima data yang di parsing dari activity lalin
        Intent i = getIntent();
        Bundle extras = getIntent().getExtras();
        nama = i.getStringExtra("nama");
        tanggal = i.getStringExtra("tanggal");
        txtname.setText(nama);
        txtdate.setText(tanggal);


        //instansiasi button dan text untuk timepicker
        tvTimeResult = (TextView) findViewById(R.id.textTime);
        btTimePicker = (Button) findViewById(R.id.bt_timePicker2);
        btTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog();
            }
        });

        //instansiasi button untuk berpindah halaman dan mengirim data
        but1 = (Button) findViewById(R.id.but1);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String nama = txtname.getText().toString(); //instansiasi objek string untuk di parsing
                Intent i = new Intent(BookingDetails.this, Date.class);
                i.putExtra("nama",nama); //mengirim parsing
                startActivity(i);
            }
        });

        //instansiasi button untuk berpindah halaman dan mengirim data
        but33 = (Button) findViewById(R.id.but33);
        but33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //instansiasi objek string untuk di parsing
                String nama = txtname.getText().toString();
                String tanggal = txtdate.getText().toString();
                String jam = txttime.getText().toString();
                String notes = txtnotes.getText().toString();
                Intent i = new Intent(BookingDetails.this, Finish.class);
                //mengirim parsing
                i.putExtra("nama",nama);
                i.putExtra("tanggal",tanggal);
                i.putExtra("jam", jam);
                i.putExtra("notes", notes);
                startActivity(i);
            }
        });

        //instansiasi button untuk berpindah halaman dan mengirim data
        butbok=(Button)findViewById(R.id.buttonbookings);
        butbok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //instansiasi objek string untuk di parsing
                String nama = txtname.getText().toString();
                String tanggal = txtdate.getText().toString();
                String jam = txttime.getText().toString();
                String notes = txtnotes.getText().toString();
                Intent i = new Intent(BookingDetails.this, Finish.class);
                //mengirim parsing
                i.putExtra("nama",nama);
                i.putExtra("tanggal",tanggal);
                i.putExtra("jam", jam);
                i.putExtra("notes", notes);
                startActivity(i);
            }
        });
    }
    //membuat method untuk timepicker
    private void showTimeDialog() {

        /**
         * Calendar untuk mendapatkan waktu saat ini
         */
        Calendar calendar = Calendar.getInstance();

        /**
         * Initialize TimePicker Dialog
         */
        timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                /**
                 * Method ini dipanggil saat kita selesai memilih waktu di DatePicker
                 */
                tvTimeResult.setText("Time : " +hourOfDay+":"+minute);
            }
        },
                /**
                 * Tampilkan jam saat ini ketika TimePicker pertama kali dibuka
                 */
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),

                /**
                 * Cek apakah format waktu menggunakan 24-hour format
                 */
                DateFormat.is24HourFormat(this));

        timePickerDialog.show();
    }
}
