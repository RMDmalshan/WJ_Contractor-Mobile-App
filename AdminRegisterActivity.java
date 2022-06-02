package com.example.wj_contractor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdminRegisterActivity extends AppCompatActivity {

    private TextView NameTV;
    private TextView AgeTv;
    private TextView NumberTV;
    private TextView nicTV;
    private TextView usernameTV;
    private TextView passwordTV;
    private TextView EmailTV;


     DataHandler dataHandler = new DataHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

        NameTV = findViewById(R.id.adminNameTV);
        AgeTv = findViewById(R.id.adminAgeTV);
        NumberTV = findViewById(R.id.adminNumberTV);
        nicTV = findViewById(R.id.adminNICTV);
        usernameTV = findViewById(R.id.adminUsernameTV);
        passwordTV = findViewById(R.id.adminPasswordTV);
        EmailTV = findViewById(R.id.adminEmailTV);


        dataHandler.openDB();
    }


    public void onCreateAdmin(View view)  {


        String name = NameTV.getText().toString();
        int age = Integer.parseInt(AgeTv.getText().toString());
        int number = Integer.parseInt(NumberTV.getText().toString());
        String nic = nicTV.getText().toString();
        String username = usernameTV.getText().toString();
        String password = passwordTV.getText().toString();
        String email = EmailTV.getText().toString();


        if (name.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin name Field can not be empty", Toast.LENGTH_LONG).show();

        }else if (AgeTv.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin age Field can not be empty", Toast.LENGTH_LONG).show();
        }else if (NumberTV.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin number Field can not be empty", Toast.LENGTH_LONG).show();
        }else if (nic.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin nic Field can not be empty", Toast.LENGTH_LONG).show();
        }else if (username.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin username Field can not be empty", Toast.LENGTH_LONG).show();
        }else if (password.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin password Field can not be empty", Toast.LENGTH_LONG).show();
        }else if (email.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Admin email Field can not be empty", Toast.LENGTH_LONG).show();
        }

        else {

            Admin admin = new Admin(name, age, number, nic, username, password, email);

            dataHandler.createAdmin(new Admin(name, age, number, nic, username, password, email));

            Toast.makeText(getApplicationContext(), "Admin Register Successfully", Toast.LENGTH_LONG).show();


            NameTV.setText("");
            AgeTv.setText("");
            NumberTV.setText("");
            nicTV.setText("");
            usernameTV.setText("");
            passwordTV.setText("");
            EmailTV.setText("");

            NameTV.requestFocus();


        }


    }
}























