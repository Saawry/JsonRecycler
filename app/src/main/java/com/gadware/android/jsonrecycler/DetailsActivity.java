package com.gadware.android.jsonrecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gadware.android.jsonrecycler.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;
    private String title,description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        title=getIntent().getStringExtra("title");
        description=getIntent().getStringExtra("desc");

        binding.tvTitle.setText(title);
        binding.tvDesc.setText(description);


    }
}