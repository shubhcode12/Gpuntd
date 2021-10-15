package com.gpuntd.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.gpuntd.app.databinding.ActivityLoginPageBinding;

public class LoginPageActivity extends AppCompatActivity {

    ActivityLoginPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_page);
        binding.btnLogin.setOnClickListener(view -> {
            startActivity(new Intent(LoginPageActivity.this, MainActivity.class));
        });
        binding.btnLoginWithOtp.setOnClickListener(view -> {
            startActivity(new Intent(LoginPageActivity.this, OtpLoginActivity.class));
        });
    }
}