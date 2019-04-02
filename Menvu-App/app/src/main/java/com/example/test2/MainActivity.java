package com.example.test2;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RestaurantAdapter.OnRestaurantListener {

    private static final  String RESTAURANT_URL = "http://menvu.menu/php/api.php";
    
    RecyclerView recyclerView;
    RestaurantAdapter adapter;

    List<Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button BTNLogin = findViewById(R.id.BTNLogin);
        BTNLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.menu_directory);
                searchForRestaurants();
                BottomNavigationView BottomNavigationView = findViewById(R.id.bottomNavigation);
            }
        });
    }

    void searchForRestaurants(){

        restaurantList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        loadRestaurants();


    }
    private void loadRestaurants(){
        final Menu m = new Menu();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, RESTAURANT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray restaurants = new JSONArray(response);

                            for (int i = 0; i < restaurants.length(); i ++){

                                JSONObject restaurantObject = restaurants.getJSONObject(i);
                                int id = restaurantObject.getInt("id");
                                String name = restaurantObject.getString("name");
                                String phone = restaurantObject.getString("phone");
                              String address = restaurantObject.getString("address");
                                String imageurl = restaurantObject.getString("imageurl");

                                Restaurant restaurant = new Restaurant(id, name, phone, address, imageurl, m);
                                restaurantList.add(restaurant);
                            }
                            adapter = new RestaurantAdapter(MainActivity.this, restaurantList, MainActivity.this);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Volley.newRequestQueue(MainActivity.this).add(stringRequest);
    }

    @Override
    public void onRestaurantClick(int position) {
    Intent intent = new Intent(this, RestaurantInfoActivity.class);
    String clickedRestaurant = new Gson().toJson(restaurantList.get(position));
    intent.putExtra("ClickedRestaurant", clickedRestaurant);
    startActivity(intent);
    }
}
