package com.gpuntd.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.gpuntd.app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navViewSide;
    DrawerLayout drawerLayout;
    NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar = findViewById(R.id.toolbarMain);
        drawerLayout = findViewById(R.id.drawer_layout);
        navViewSide = findViewById(R.id.sideNav_view);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_1);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_offers, R.id.navigation_passbook, R.id.navigation_ids)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        setupNavigationDrawer();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_withdrawDetails:
                startActivity(new Intent(MainActivity.this, WithdrawDetailsActivity.class));
                // navController.navigate(R.id.navigation_ids);
                Toast.makeText(this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_notification:
                startActivity(new Intent(MainActivity.this, NotificationsActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }


    private void setupNavigationDrawer() {
        navViewSide.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("WrongConstant")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        drawerLayout.closeDrawer(Gravity.START, false);
                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        break;
                    case R.id.drawer_withdrawalDetails:
                        drawerLayout.closeDrawer(Gravity.START, false);
                        startActivity(new Intent(MainActivity.this, WithdrawDetailsActivity.class));
                        break;
                    case R.id.drawer_create_id:
                        drawerLayout.closeDrawer(Gravity.START, false);
                        navController.navigate(R.id.navigation_ids);
                        break;
                    case R.id.drawer_refer:
                        drawerLayout.closeDrawer(Gravity.START, false);
                        startActivity(new Intent(MainActivity.this, ReferAndEarnActivity.class));
                        break;
                    case R.id.drawer_terms:
                        drawerLayout.closeDrawer(Gravity.START, false);
                        startActivity(new Intent(MainActivity.this, TermsActivity.class));
                        break;
                    case R.id.drawer_help:
                        drawerLayout.closeDrawer(Gravity.START, false);
                        startActivity(new Intent(MainActivity.this, HelpActivity.class));
                        break;

                    case R.id.drawer_logout:
                        drawerLayout.closeDrawer(Gravity.START, false);
                        setupLogoutDialog();
                        break;

                }
                return false;
            }
        });


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    public void setupLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.logout_dialog, findViewById(R.id.logoutView));
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        view.findViewById(R.id.btnLogoutDialog).setOnClickListener(view1 -> {
            Toast.makeText(MainActivity.this, "Logging out!", Toast.LENGTH_SHORT).show();
        });
        view.findViewById(R.id.btnCancelDialog).setOnClickListener(view1 -> {
            alertDialog.dismiss();
        });
        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    public void goToPassbook(){
        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
        navController.navigate(R.id.navigation_passbook);

    }


}