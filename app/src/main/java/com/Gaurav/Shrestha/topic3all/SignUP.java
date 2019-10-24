package com.Gaurav.Shrestha.topic3all;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class SignUP extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    Spinner spstate, splocation;
    AutoCompleteTextView auCountryname;
    TextView tvdate, tvtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        spstate = findViewById(R.id.spState);
        splocation = findViewById(R.id.spLocation);
        auCountryname = findViewById(R.id.autocom);
        tvdate = findViewById(R.id.datep);
        tvtime = findViewById(R.id.timep);
        String State[] = {"please select one", "1", "2", "3"};
        final String l1[] = {"please select one", "Kathmandu", "Lalitpur", "Bhaktapur"};
        final String l2[] = {"please select one", "Bhojpur", "Dhankuta", "Illam"};
        final String l3[] = {"please select one", "Rajbiraj", "Siraha", "Gaur"};
        final String countries[] = {"Affhanistan","Beligium","Canada","Denmark","Egypt","France","Germany","Iceland","Japan"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, State);
        spstate.setAdapter(arrayAdapter);
        spstate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (spstate.getSelectedItem().toString()) {
                    case "1":
                        ArrayAdapter<String> a1 = new ArrayAdapter<>(SignUP.this, android.R.layout.simple_list_item_1, l1);
                        splocation.setAdapter(a1);
                        break;
                    case "2":
                        ArrayAdapter<String> a2 = new ArrayAdapter<>(SignUP.this, android.R.layout.simple_list_item_1, l2);
                        splocation.setAdapter(a2);
                        break;
                    case "3":
                        ArrayAdapter<String> a3 = new ArrayAdapter<>(SignUP.this, android.R.layout.simple_list_item_1, l3);
                        splocation.setAdapter(a3);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<String> coun= new ArrayAdapter<>(SignUP.this,R.layout.support_simple_spinner_dropdown_item,countries);
        auCountryname.setAdapter(coun);
        auCountryname.setThreshold(1);
   tvdate.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
Datepi();
       }
   });
   tvtime.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
Timepi();
       }
   });
    }
    private void Datepi(){
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(calendar.YEAR);
        int month = calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(SignUP.this, SignUP.this, year, month, day);
        datePickerDialog.show();

    }
    private void Timepi(){
        final Calendar calendar = Calendar.getInstance();
        int hours = calendar.get(calendar.HOUR);
        int minutes = calendar.get(calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                String ampm;
                if (selectedHour>=12){
                    selectedHour=selectedHour-12;
                    ampm="pm";
                }else{
                    ampm="am";
                }
                tvtime.setText(" your arrive time is : "+ selectedHour + ":" + selectedMinute+" : "+ampm);
            }
        }, hours, minutes, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();

    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "You DOB is :" + month + " - " + dayOfMonth + " - " + year;
        tvdate.setText(date);

    }
}
