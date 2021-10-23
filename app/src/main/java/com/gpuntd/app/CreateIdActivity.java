package com.gpuntd.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gpuntd.app.databinding.ActivityCreateIdBinding;

public class CreateIdActivity extends AppCompatActivity {
    ActivityCreateIdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_id);

        String idImageUrl = getIntent().getStringExtra("idimageurl");
        String idName = getIntent().getStringExtra("idname");
        String idWebsite = getIntent().getStringExtra("idwebsite");

        if (idImageUrl!=null){
            Glide.with(getApplicationContext())
                    .load(idImageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(binding.ivIdProfile);
        }

        binding.tvIdName.setText(idName);
        binding.tvIdWebsite.setText(idWebsite);



    }
}