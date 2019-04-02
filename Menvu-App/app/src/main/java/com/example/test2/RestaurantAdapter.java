package com.example.test2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>{

    private Context mCtx;
    private List<Restaurant> restaurantList;

    public RestaurantAdapter(Context mCtx, List<Restaurant> restaurantList) {
        this.mCtx = mCtx;
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override // returns an instance of RestaurantViewHolder
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new RestaurantViewHolder(view);
    }

    @Override // binding the data to the cards that will be in the recyclerview
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int i) {
        Restaurant restaurant = restaurantList.get(i);

        holder.TXTName.setText(restaurant.getName());
        holder.TXTAddress.setText(restaurant.getAddress());
        holder.TXTPhone.setText(restaurant.getPhoneNumber());

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(R.drawable.menvusquarelogo));
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView TXTName, TXTPhone, TXTAddress;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.IMGRestaurant);
            TXTName = itemView.findViewById(R.id.TXTRestaurantName);
            TXTPhone = itemView.findViewById(R.id.TXTPhone);
            TXTAddress = itemView.findViewById(R.id.TXTAddress);
        }
    }


}
