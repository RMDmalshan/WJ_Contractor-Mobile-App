package com.example.wj_contractor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SupervisorMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisor_menu);
    }

    public void addMason(View view){

        Intent intent = new Intent(this,AddMasonryWorkersActivity.class);
        startActivity(intent);
    }

    public void updateDeleteMason(View view){

        Intent intent = new Intent(this, UpdateDeleteViewMasonryWorkersActivity.class);
        startActivity(intent);

    }
    public void onLogOut(View view){

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void onCalculateSalary(View view){
        Intent intent = new Intent(this, CalculateSalaryActivity.class);
        startActivity(intent);
    }

    public void markAttendance(View view){
        Intent intent = new Intent(this, CalculateSalaryActivity.class);
        startActivity(intent);

    }



}