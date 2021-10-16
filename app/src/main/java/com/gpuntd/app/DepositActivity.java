package com.gpuntd.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.gpuntd.app.databinding.ActivityDepositBinding;

public class DepositActivity extends AppCompatActivity {

    ActivityDepositBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_deposit);

        setSupportActionBar(binding.toolbarDeposit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        binding.toolbarDeposit.setNavigationOnClickListener(view -> {
            super.onBackPressed();
        });

    }
}