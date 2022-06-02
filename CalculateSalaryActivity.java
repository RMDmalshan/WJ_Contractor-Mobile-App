package com.example.wj_contractor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateSalaryActivity extends AppCompatActivity {

    private TextView nameTV;
    private TextView emailTV;
    private TextView workingTV;
    private TextView salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_salary);

        nameTV = findViewById(R.id.salaryNameTV);
        emailTV = findViewById(R.id.salaryEmailTV);
        workingTV = findViewById(R.id.salaryDaysTV);
        salary = findViewById(R.id.salaryTV);

    }

    public void onCalculateSalary(View view){


        int Total;
        int payment = 3000;

        String name = nameTV.getText().toString();
        int DAYS = Integer.parseInt(workingTV.getText().toString());

            Total = DAYS * payment;
            salary.setText(String.valueOf(Total));


    }
}