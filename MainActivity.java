package com.example.wj_contractor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


private final DataHandler dataHandler = new DataHandler(this);


    @Override

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;

            case R.id.add_sup:
                Intent intent = new Intent(this,SupervisorsRegisterActivity.class);
               startActivity(intent);
                break;

            case R.id.add_new_site:
                Intent intent2 = new Intent(this,AddNewSiteActivity.class);
                startActivity(intent2);
                break;

            case R.id.reg_admin:
                Intent intent1 = new Intent(this,AdminRegisterActivity.class);
                startActivity(intent1);
                break;

            case R.id.add_mason:
                Intent intent3 = new Intent(this, AddMasonryWorkersActivity.class);
                startActivity(intent3);
                break;

            case R.id.up_dele_sup:
                Intent intent4 = new Intent(this, UpdateDeleteViewSupervisorActivity.class);
                startActivity(intent4);
                break;

            case R.id.add_de_up_mason:
                Intent intent5 = new Intent(this, UpdateDeleteViewMasonryWorkersActivity.class);
                startActivity(intent5);
                break;




        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;


    }

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dataHandler.openDB();


        drawerLayout = findViewById(R.id.nav_view);


        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();



    }
}