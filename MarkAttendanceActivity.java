package com.example.wj_contractor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MarkAttendanceActivity extends AppCompatActivity {

    int year, month, day;

    private TextView DateTV;
    private TextView nameTV;
    private  TextView idTV;

    DataHandler dataHandler = new DataHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_attendent);

        DateTV = findViewById(R.id.dateDisplayTV);
        nameTV = findViewById(R.id.aWorkerNameTV);
        idTV = findViewById(R.id.aWorkerIDTV);


        dataHandler.openDB();
    }


    public void onDateSelection(View view) {

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                DateTV.setText(i2 + "-" + (i1+1) + "-" + i);
            }
        }, year,month,day);

        datePickerDialog.show();


    }

    public void markAttendance(View view){

        String name = nameTV.getText().toString();
        String id = idTV.getText().toString();
        String date = DateTV.getText().toString();



        MarkAttendance markAttendance = new MarkAttendance(name, id, date);

        dataHandler.markAttendance(new MarkAttendance(name,id,date));

        Toast.makeText(getApplicationContext(), " Worker attendance added Successfully", Toast.LENGTH_LONG).show();






    }
}