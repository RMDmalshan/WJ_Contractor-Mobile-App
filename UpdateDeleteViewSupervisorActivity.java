package com.example.wj_contractor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateDeleteViewSupervisorActivity extends AppCompatActivity {

    private TextView SNameTV;
    private TextView SAgeTv;
    private TextView SNumberTV;
    private TextView SnicTV;
    private TextView SusernameTV;
    private TextView SpasswordTV;
    private TextView SEmailTV;

    public Button view;
    DBConnector db;
    DataHandler dataHandler = new DataHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delect_supervisor);

        SNameTV = findViewById(R.id.duNameTV);
        SAgeTv = findViewById(R.id.duAgeTV);
        SNumberTV = findViewById(R.id.duNumberTV);
        SnicTV = findViewById(R.id.duNICTV);
        SusernameTV = findViewById(R.id.duUserNameTV);
        SpasswordTV = findViewById(R.id.duPasswordTV);
        SEmailTV = findViewById(R.id.duEmailTV);

        dataHandler.openDB();

        view = findViewById(R.id.viewSupBTN);
        db = new DBConnector(this);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getsupervisordata();
                if (res.getCount() == 0){
                    Toast.makeText(UpdateDeleteViewSupervisorActivity.this, "invalid Entry", Toast.LENGTH_SHORT).show();
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

                AlertDialog.Builder builder = new AlertDialog.Builder(UpdateDeleteViewSupervisorActivity.this);
                builder.setCancelable(true);
                builder.setTitle("ALL workers Details");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });



    }

    public void onUpdateSupervisor(View view){


        String name = SNameTV.getText().toString();
        int age = Integer.parseInt(SAgeTv.getText().toString());
        int number = Integer.parseInt(SNumberTV.getText().toString());
        String nic = SnicTV.getText().toString();
        String username = SusernameTV.getText().toString();
        String password = SpasswordTV.getText().toString();
        String email = SEmailTV.getText().toString();


        Supervisors supervisors = new Supervisors(name, age,number,nic,username, password,email);

        dataHandler.updateSupervisor(new Supervisors(name,age,number,nic,username,password,email));


        Toast.makeText(getApplicationContext(), "Supervisor update Successfully", Toast.LENGTH_LONG).show();


    }

    public void onDeleteSupervisor(View view){



        Integer deletesup = dataHandler.deleteSupervisor(SusernameTV.getText().toString());
        if (deletesup > 0){
            Toast.makeText(getApplicationContext(), "Supervisor delete Successfully", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(), "Supervisor delete  not Successfully", Toast.LENGTH_LONG).show();
        }


    }


}