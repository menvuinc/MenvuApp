package com.example.test2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.google.gson.Gson;

public class RestaurantInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restuarantinfo);
        String receiveClickedRestaurant = getIntent().getStringExtra("ClickedRestaurant");
        Restaurant ClickedRestaurant = new Gson().fromJson(receiveClickedRestaurant, Restaurant.class);
        Button BTNTest = findViewById(R.id.BTNTest);
        BTNTest.setText(ClickedRestaurant.getName());
    }
}
