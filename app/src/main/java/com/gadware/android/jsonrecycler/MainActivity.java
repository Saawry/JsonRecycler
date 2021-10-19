package com.gadware.android.jsonrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.gadware.android.jsonrecycler.databinding.ActivityDetailsBinding;
import com.gadware.android.jsonrecycler.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<DataPojo> modelList=new ArrayList<>();
    ItemsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("DemoTitle1", "DemoDescription1");

        binding.recycler.setLayoutManager(new LinearLayoutManager(this));

        String json = "{"
                        + "'title':'DemoTitle1',"
                        + "'description':'DemoDescription1'"
                        + "}";

        DataPojo data = new Gson().fromJson(json, DataPojo.class);
        modelList.add(data);

        adapter=new ItemsAdapter(this,modelList);
        binding.recycler.setAdapter(adapter);

    }
}