package com.example.wj_contractor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AddNewSiteActivity extends AppCompatActivity {


    int year, month, day;

    private TextView sDateTV;
    private TextView eDateTV;
    private TextView name;
    private TextView SName;
    private TextView location;
    private TextView id;


    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_site);

        sDateTV = findViewById(R.id.startDateDisplayTV);
        eDateTV= findViewById(R.id.endDateDisplayTV);

        name = findViewById(R.id.siteNameTV);
        SName = findViewById(R.id.siteSupervisorTV);
        location = findViewById(R.id.siteLocationTV);
        id = findViewById(R.id.siteIdTV);


        dataHandler.openDB();


    }

    public void onStartDateSelection(View view) {

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                sDateTV.setText(i2 + "-" + (i1+1) + "-" + i);
            }
        }, year,month,day);

        datePickerDialog.show();


    }

    public void onEndDateSelection(View view) {

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                eDateTV.setText(i2 + "-" + (i1+1) + "-" + i);
            }
        }, year,month,day);

        datePickerDialog.show();
    }


    public void addNewSite(View view){

        String NAME = name.getText().toString();
        String supName = SName.getText().toString();
        String loc = location.getText().toString();
        String StartDate = sDateTV.getText().toString();
        String EndDate = eDateTV.getText().toString();
        String siteID = id.getText().toString();




        if (NAME.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "New Site name can not be empty ", Toast.LENGTH_LONG).show();

        }else if (supName.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "New Site supervisor name can not be empty ", Toast.LENGTH_LONG).show();

        }else if (loc.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "New Site location can not be empty ", Toast.LENGTH_LONG).show();

        }else if (StartDate.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "New Site start date can not be empty ", Toast.LENGTH_LONG).show();

        }else if (EndDate.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "New Site end date can not be empty ", Toast.LENGTH_LONG).show();

        }else if (siteID.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "New Site site id can not be empty ", Toast.LENGTH_LONG).show();

        }

        else {

            AddNewSite addNewSite = new AddNewSite(NAME, supName,loc,StartDate,EndDate, siteID);


            dataHandler.addNewSite(new AddNewSite(NAME,supName,loc,StartDate,EndDate,siteID));

            Toast.makeText(getApplicationContext(), "New Site Added Successfully", Toast.LENGTH_LONG).show();


            name.setText("");
            SName.setText("");
            location.setText("");
            sDateTV.setText("");
            eDateTV.setText("");
            id.setText("");

            name.requestFocus();
        }
    }
}