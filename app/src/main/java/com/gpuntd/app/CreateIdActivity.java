package com.gpuntd.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gpuntd.app.databinding.ActivityCreateIdBinding;

import java.util.Objects;

public class CreateIdActivity extends AppCompatActivity {
    ActivityCreateIdBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_id);

        String idImageUrl = getIntent().getStringExtra("idimageurl");
        String idName = getIntent().getStringExtra("idname");
        String idWebsite = getIntent().getStringExtra("idwebsite");
        String minRefill = getIntent().getStringExtra("minRefill");
        String minWithdrawal = getIntent().getStringExtra("minWithdrawal");
        String minMaintainBal = getIntent().getStringExtra("minMaintainBal");
        String maxWithdrawal = getIntent().getStringExtra("maxWithdrawal");

        if (idImageUrl!=null){
            Glide.with(getApplicationContext())
                    .load(idImageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.ivIdProfile);
        }

        binding.tvIdName.setText(idName);
        binding.tvIdWebsite.setText(idWebsite);
        binding.depositCoinsEt.setText(minRefill);
        binding.tvMinRefillLink.setText(minRefill);
        binding.tvMinWithdrawal.setText(minWithdrawal);
        binding.tvMinMaintainingBal.setText(minMaintainBal);
        binding.tvMaxWithdrawal.setText(maxWithdrawal);
        binding.btnCreateIDActivity.setText("Continue To Pay"+" ₹ "+binding.depositCoinsEt.getText().toString());

        binding.depositCoinsEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                binding.btnCreateIDActivity.setText("Continue To Pay"+" ₹ "+binding.depositCoinsEt.getText().toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.btnCreateIDActivity.setText("Continue To Pay"+" ₹ "+binding.depositCoinsEt.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.btnCreateIDActivity.setText("Continue To Pay"+" ₹ "+binding.depositCoinsEt.getText().toString());
            }
        });

        binding.btnCreateIDActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Objects.requireNonNull(binding.usernameEt.getText()).toString().equals("")){
                    binding.usernameEt.setError("Username is Mandatory");
                }
            }
        });



    }
}