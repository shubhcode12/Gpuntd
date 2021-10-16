package com.gpuntd.app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gpuntd.app.databinding.ActivityWithdrawDetailsBinding;

public class WithdrawDetailsActivity extends AppCompatActivity {

    ActivityWithdrawDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_withdraw_details);
        setSupportActionBar(binding.toolbarWithdrawDetails);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        binding.toolbarWithdrawDetails.setNavigationOnClickListener(view -> {
            super.onBackPressed();
        });

        binding.btnAddNewBank.setOnClickListener(view -> {
            setupAddBankDialog();
        });

        binding.btnAddPaytmNo.setOnClickListener(view -> {
            setupAddPaytmWalletDialog();
        });

        binding.btnAddGPay.setOnClickListener(view -> {
            setupGooglePayDialog();
        });

        binding.btnAddPhonePe.setOnClickListener(view -> {
            setupPhonePeDialog();
        });

        binding.btnAddPaytmUPI.setOnClickListener(view -> {
            setupPaytmUpiDialog();
        });

        binding.btnAddUPI.setOnClickListener(view -> {
            setupUPIDialog();
        });

    }

    void setupAddBankDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(WithdrawDetailsActivity.this).inflate(R.layout.dialog_add_bank_account, findViewById(R.id.addBankView));
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        EditText etAccountNo = view.findViewById(R.id.accountNoEt);
        EditText etIfse = view.findViewById(R.id.ifscEt);
        EditText etAccHolderName = view.findViewById(R.id.accountHolderNameEt);

        view.findViewById(R.id.btnSubmitBankAcc).setOnClickListener(view1 -> {
            Toast.makeText(WithdrawDetailsActivity.this, "Added Bank Account", Toast.LENGTH_SHORT).show();
        });

        view.findViewById(R.id.btnDismissAddBank).setOnClickListener(view1 -> {
            alertDialog.dismiss();

        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    void setupAddPaytmWalletDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(WithdrawDetailsActivity.this).inflate(R.layout.dialog_add_paytm_wallet, findViewById(R.id.addPaytmView));
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        EditText etNamePaytm = view.findViewById(R.id.namePaytmEt);
        EditText etPaytmNo = view.findViewById(R.id.paytmNoEt);


        view.findViewById(R.id.btnSubmitPaytmInfo).setOnClickListener(view1 -> {
            Toast.makeText(WithdrawDetailsActivity.this, "Paytm no submitted!", Toast.LENGTH_SHORT).show();
        });

        view.findViewById(R.id.btnDismissPaytm).setOnClickListener(view1 -> {
            alertDialog.dismiss();

        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    void setupGooglePayDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(WithdrawDetailsActivity.this).inflate(R.layout.dialog_add_google_pay, findViewById(R.id.addGooglePayView));
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        EditText etNameGpay = view.findViewById(R.id.nameGooglePayEt);
        EditText etGpayNo = view.findViewById(R.id.googlePayNoEt);


        view.findViewById(R.id.btnSubmitGpayInfo).setOnClickListener(view1 -> {
            Toast.makeText(WithdrawDetailsActivity.this, "Google Pay no submitted!", Toast.LENGTH_SHORT).show();
        });

        view.findViewById(R.id.btnDismissGpay).setOnClickListener(view1 -> {
            alertDialog.dismiss();

        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    void setupPhonePeDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(WithdrawDetailsActivity.this).inflate(R.layout.dialog_add_phonepe, findViewById(R.id.addPhonePeView));
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        EditText etNamePhonePe = view.findViewById(R.id.namePhonePeEt);
        EditText etGpayNo = view.findViewById(R.id.phonPeNoEt);


        view.findViewById(R.id.btnSubmitPhonepe).setOnClickListener(view1 -> {
            Toast.makeText(WithdrawDetailsActivity.this, "PhonePe no submitted!", Toast.LENGTH_SHORT).show();
        });

        view.findViewById(R.id.btnDismissPhonePe).setOnClickListener(view1 -> {
            alertDialog.dismiss();

        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    void setupPaytmUpiDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view2 = LayoutInflater.from(WithdrawDetailsActivity.this).inflate(R.layout.dialog_add_paytm_upi, findViewById(R.id.addPaytmUpiView));
        builder.setView(view2);
        final AlertDialog alertDialog = builder.create();
        EditText etNamePaytmUpi = view2.findViewById(R.id.namePaytmUpiEt);
        EditText etPaytmUpiNo = view2.findViewById(R.id.paytmUpiNoEt);


        view2.findViewById(R.id.btnDismissPaytmUpi).setOnClickListener(view1 -> {
            Toast.makeText(WithdrawDetailsActivity.this, "Paytm Upi submitted!", Toast.LENGTH_SHORT).show();
        });

        view2.findViewById(R.id.btnDismissPaytmUpi).setOnClickListener(view1 -> {
            alertDialog.dismiss();

        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    void setupUPIDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(WithdrawDetailsActivity.this).inflate(R.layout.dialog_add_upi, findViewById(R.id.addUpiView));
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        EditText etNameUpi = view.findViewById(R.id.nameUpiEt);
        EditText etUpiId = view.findViewById(R.id.upiIdEt);


        view.findViewById(R.id.btnSubmitUpi).setOnClickListener(view1 -> {
            Toast.makeText(WithdrawDetailsActivity.this, "UPI submitted!", Toast.LENGTH_SHORT).show();
        });

        view.findViewById(R.id.btnDismissUpi).setOnClickListener(view1 -> {
            alertDialog.dismiss();

        });

        if (alertDialog.getWindow() != null){
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }
}