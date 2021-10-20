package com.gpuntd.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.gpuntd.app.databinding.ActivityTransactionDetailsBinding;

public class TransactionDetailsActivity extends AppCompatActivity {

    ActivityTransactionDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_transaction_details);


    }
}