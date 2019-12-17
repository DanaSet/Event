package com.example.eventtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.eventtest.helper.DataHelper;


import java.util.Calendar;

public class tambahKegiatanActivity extends AppCompatActivity {

    Cursor cursor;
    DataHelper dbHelper;
    Button btnAdd, btnDone, btnBack;
    EditText addNomor, addEvent,addTanggal, addKeterangan, addWaktuMulai, addWaktuAkhir;
    DatePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kegiatan);

        dbHelper = new DataHelper(this);
        addNomor = findViewById(R.id.editNomor);
        addEvent = findViewById(R.id.editEvent);
        addTanggal = findViewById(R.id.editTanggal);
        addKeterangan = findViewById(R.id.editKeterangan);
        addWaktuMulai = findViewById(R.id.editWaktuMulai);
        addWaktuAkhir = findViewById(R.id.editWaktuAkhir);

        addWaktuMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mCurrentTime = Calendar.getInstance();
                int hours = mCurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mCurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(tambahKegiatanActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        addWaktuMulai.setText(String.format("%02d:%02d", selectedHour, selectedMinute));
                    }
                },hours,minute,true
                );
                mTimePicker.setTitle("Pilih Waktu Mulai");
                mTimePicker.show();
            }
        });

        addWaktuAkhir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar mCurrentTime = Calendar.getInstance();
                int hours = mCurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mCurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(tambahKegiatanActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        addWaktuAkhir.setText(String.format("%02d:%02d", selectedHour, selectedMinute));
                    }
                },hours,minute,true
                );
                mTimePicker.setTitle("Pilih Waktu Berakhir");
                mTimePicker.show();
            }
        });


        addTanggal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Calendar mCurrentDate = Calendar.getInstance();
                int day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
                int month = mCurrentDate.get(Calendar.MONTH);
                int year = mCurrentDate.get(Calendar.YEAR);

                DatePickerDialog mDatePicker;
                mDatePicker = new DatePickerDialog(tambahKegiatanActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int selectedDay, int selectedMonth, int selectedYear) {
                        addTanggal.setText(String.format("%02d-%02d-%d", selectedDay, selectedMonth, selectedYear));
                    }
                },day,month,year
                );
                mDatePicker.setTitle("Pilih Tanggal");
                mDatePicker.show();
            }
        });

//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDatabase db = dbHelper.getWritableDatabase();
//                db.execSQL("INSERT INTO kegiatan (nomor, event, tanggal, keterangan, waktu_mulai, waktu_akhir) VALUES ('" + addNomor.getText().toString() + "', '" + addEvent.getText().toString() + "', '" + addKeterangan.getText().toString() + "', '" + addWaktuMulai.getText().toString() + "', '" + addWaktuAkhir.getText().toString() + "')");
//                Toast.makeText(getApplicationContext(), "Berhasil Menambah Kegiatan", Toast.LENGTH_LONG).show();
//                MainActivity.ma.RefreshList();
//                finish();
//            }
//        });
//
//        btnDone.setEnabled(false);
//
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
    }
}
