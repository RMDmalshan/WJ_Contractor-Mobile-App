package com.example.wj_contractor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameTV;
    private EditText passwordTV;


    DataHandler dataHandler = new DataHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameTV = findViewById(R.id.loginUsername);
        passwordTV = findViewById(R.id.loginPassword);


        dataHandler.openDB();


    }

    public void onLoginClick(View view) {


        String username = usernameTV.getText().toString();
        String password = passwordTV.getText().toString();



        Boolean checkAdminLogin = dataHandler.checkAdminLogin(username, password);
        if (checkAdminLogin == true) {
            Toast.makeText(getApplicationContext(), "Logging Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        } else {
            //Toast.makeText(getApplicationContext(), "Logging Failed.", Toast.LENGTH_SHORT).show();


            Boolean checkSupervisorsLogin = dataHandler.checkSupervisorsLogin(username, password);
            if (checkSupervisorsLogin == true) {
                Toast.makeText(getApplicationContext(), "Logging Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,SupervisorMenuActivity.class);
                startActivity(intent);

            }
            else {
                Toast.makeText(getApplicationContext(), "Logging Failed.", Toast.LENGTH_SHORT).show();
            }
        }

        }
    }

