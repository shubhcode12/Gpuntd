package com.gpuntd.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.gpuntd.app.databinding.ActivityNotificationsBinding;


public class NotificationsActivity extends AppCompatActivity {

    ActivityNotificationsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_notifications);
        setSupportActionBar(binding.toolbarNoti);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        binding.toolbarNoti.setNavigationOnClickListener(view -> {
            super.onBackPressed();
        });
    }
}