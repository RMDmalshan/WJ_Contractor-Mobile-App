package com.example.wj_contractor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SupervisorsRegisterActivity extends AppCompatActivity {

    private TextView SNameTV;
    private TextView SAgeTv;
    private TextView SNumberTV;
    private TextView SnicTV;
    private TextView SusernameTV;
    private TextView SpasswordTV;
    private TextView SEmailTV;


    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervisors_register);


        SNameTV = findViewById(R.id.supervisorNameTV);
        SAgeTv = findViewById(R.id.supervisorAgeTV);
        SNumberTV = findViewById(R.id.supervisorNumberTV);
        SnicTV = findViewById(R.id.supervisorNICTV);
        SusernameTV = findViewById(R.id.supervisorUsernameTV);
        SpasswordTV = findViewById(R.id.supervisorPasswordTV);
        SEmailTV = findViewById(R.id.supervisorEmailTV);

        dataHandler.openDB();
    }


    public void onCreateSupervisor(View view)  {


        String name = SNameTV.getText().toString();
        int age = Integer.parseInt(SAgeTv.getText().toString());
        int number = Integer.parseInt(SNumberTV.getText().toString());
        String nic = SnicTV.getText().toString();
        String username = SusernameTV.getText().toString();
        String password = SpasswordTV.getText().toString();
        String email = SEmailTV.getText().toString();


        if (name.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Supervisor name Field can not be empty", Toast.LENGTH_LONG).show();

        }else if (SAgeTv.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Supervisor age Field can not be empty", Toast.LENGTH_LONG).show();
        }else if (SNumberTV.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Supervisor number Field can not be empty", Toast.LENGTH_LONG).show();
        }else if (nic.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Supervisor nic Field can not be empty", Toast.LENGTH_LONG).show();
        }else if (username.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Supervisor username Field can not be empty", Toast.LENGTH_LONG).show();
        }else if (password.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Supervisor password Field can not be empty", Toast.LENGTH_LONG).show();
        }else if (email.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Supervisor email Field can not be empty", Toast.LENGTH_LONG).show();
        }

        else {

            Supervisors supervisors = new Supervisors(name, age,number,nic,username, password,email);

            dataHandler.createSupervisors(new Supervisors(name,age,number,nic,username,password,email));

            Toast.makeText(getApplicationContext(), "Supervisor Register Successfully", Toast.LENGTH_LONG).show();


            SNameTV.setText("");
            SAgeTv.setText("");
            SNumberTV.setText("");
            SnicTV.setText("");
            SusernameTV.setText("");
            SpasswordTV.setText("");
            SEmailTV.setText("");

            SNameTV.requestFocus();


        }


    }
}