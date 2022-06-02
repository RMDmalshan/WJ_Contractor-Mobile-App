package com.example.wj_contractor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateDeleteViewMasonryWorkersActivity extends AppCompatActivity {


    private TextView MNameTV;
    private TextView MAgeTv;
    private TextView MNumberTV;
    private TextView MnicTV;
    private TextView MEmailTV;
    private TextView MAddressTV;
    private TextView MIDTV;

    public Button view;

    DBConnector db;
    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_masonry_workers);

        MNameTV = findViewById(R.id.uMasonNameTV);
        MAgeTv = findViewById(R.id.uMasonAgeTV);
        MNumberTV = findViewById(R.id.uMasonNumberTV);
        MnicTV = findViewById(R.id.uMasonNICTV);
        MEmailTV = findViewById(R.id.uMasonEmailTV);
        MAddressTV = findViewById(R.id.uMasonAddressTV);
        MIDTV = findViewById(R.id.uMasonUserIDTV);

        dataHandler.openDB();

        view = findViewById(R.id.viewWorkBTN);
        db = new DBConnector(this);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getmasondata();
                if (res.getCount() == 0){
                    Toast.makeText(UpdateDeleteViewMasonryWorkersActivity.this, "invalid Entry", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("name : "+res.getString(0)+"\n");
                    buffer.append("age : "+res.getString(1)+"\n");
                    buffer.append("number : "+res.getString(2)+"\n");
                    buffer.append("nic : "+res.getString(3)+"\n");
                    buffer.append("email : "+res.getString(4)+"\n");
                    buffer.append("address : "+res.getString(5)+"\n");
                    buffer.append("userid : "+res.getString(6)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(UpdateDeleteViewMasonryWorkersActivity.this);
                builder.setCancelable(true);
                builder.setTitle("ALL workers Details");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });

    }

    public void onUpdateMasonryWorkers(View view){


        String name = MNameTV.getText().toString();
        int age = Integer.parseInt(MAgeTv.getText().toString());
        int number = Integer.parseInt(MNumberTV.getText().toString());
        String nic = MnicTV.getText().toString();
        String email = MEmailTV.getText().toString();
        String address = MAddressTV.getText().toString();
        String id = MIDTV.getText().toString();


        MasonryWorkers masonryWorkers = new MasonryWorkers(name, age,number,nic,email, address,id);

        dataHandler.updateMasonryWorkers(new MasonryWorkers(name, age,number,nic,email, address,id));

        Toast.makeText(getApplicationContext(), "MasonryWorkers update Successfully", Toast.LENGTH_LONG).show();


    }

    public void deleteMasonryWorkers(View view){


        Integer deleteMan = dataHandler.deleteMason(MIDTV.getText().toString());
        if (deleteMan > 0){
            Toast.makeText(getApplicationContext(), "Masonry worker delete Successfully", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "Masonry worker delete  not Successfully", Toast.LENGTH_LONG).show();
        }
    }
}