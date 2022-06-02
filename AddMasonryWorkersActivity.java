package com.example.wj_contractor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AddMasonryWorkersActivity extends AppCompatActivity {

    private TextView nameTV;
    private TextView ageTV;
    private TextView numberTV;
    private TextView nicTV;
    private TextView emailTV;
    private TextView addressTV;
    private TextView idTV;

    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_masonry_workes);

        nameTV = findViewById(R.id.masonNameTV);
        ageTV = findViewById(R.id.masonAgeTV);
        numberTV = findViewById(R.id.masonNumberTV);
        nicTV = findViewById(R.id.masonyNicTV);
        emailTV = findViewById(R.id.masonEmailTV);
        addressTV = findViewById(R.id.masonAddressTV);
        idTV = findViewById(R.id.masonIDTV);

        dataHandler.openDB();

    }

    public void addMasonryWorkers(View view){

        String name = nameTV.getText().toString();
        int age = Integer.parseInt(ageTV.getText().toString());
        int number = Integer.parseInt(numberTV.getText().toString());
        String nic = nicTV.getText().toString();
        String email = emailTV.getText().toString();
        String address = addressTV.getText().toString();
        String id = idTV.getText().toString();

        if (name.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Masonry Worker name can not be empty ", Toast.LENGTH_LONG).show();

        }else if (ageTV.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Masonry Worker age can not be empty ", Toast.LENGTH_LONG).show();

        }else if (numberTV.getText().toString().trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Masonry Worker number can not be empty ", Toast.LENGTH_LONG).show();

        }else if (nic.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Masonry Worker nic can not be empty ", Toast.LENGTH_LONG).show();

        }else if (email.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Masonry Worker email can not be empty ", Toast.LENGTH_LONG).show();

        }else if (address.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Masonry Worker address can not be empty ", Toast.LENGTH_LONG).show();

        }else if (id.trim().isEmpty()){
            Toast.makeText(getApplicationContext(), "Masonry Worker id can not be empty ", Toast.LENGTH_LONG).show();

        }

        else {

            MasonryWorkers masonryWorkers = new MasonryWorkers(name, age, number, nic, email, address, id);


            dataHandler.addMasonryWorkers(new MasonryWorkers(name, age, number, nic, email, address, id));

            Toast.makeText(getApplicationContext(), "Masonry Worker added Successfully", Toast.LENGTH_LONG).show();

            nameTV.setText("");
            ageTV.setText("");
            numberTV.setText("");
            nicTV.setText("");
            emailTV.setText("");
            addressTV.setText("");
            idTV.setText("");

            nameTV.requestFocus();

        }
    }
}