package com.example.test2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
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
    private OnRestaurantListener onRestaurantListener;
    public RestaurantAdapter(Context mCtx, List<Restaurant> restaurantList, OnRestaurantListener onRestaurantListener) {
        this.mCtx = mCtx;
        this.restaurantList = restaurantList;
        this.onRestaurantListener = onRestaurantListener;
    }

    @NonNull
    @Override // returns an instance of RestaurantViewHolder
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);

        return new RestaurantViewHolder(view, onRestaurantListener);
    }

    @Override // binding the data to the cards that will be in the recyclerview
    public void onBindViewHolder(@NonNull final RestaurantViewHolder holder, int i) {
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

    class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView TXTName, TXTPhone, TXTAddress;
        OnRestaurantListener onRestaurantListener;

        public RestaurantViewHolder(@NonNull View itemView, OnRestaurantListener onRestaurantListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.IMGRestaurant);
            TXTName = itemView.findViewById(R.id.TXTRestaurantName);
            TXTPhone = itemView.findViewById(R.id.TXTPhone);
            TXTAddress = itemView.findViewById(R.id.TXTAddress);

            this.onRestaurantListener = onRestaurantListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRestaurantListener.onRestaurantClick(getAdapterPosition());
        }
    }

    public interface OnRestaurantListener{
        void onRestaurantClick(int position);


    }

}
