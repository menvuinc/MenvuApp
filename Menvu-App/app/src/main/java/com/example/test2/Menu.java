package com.example.test2;

import java.util.ArrayList;

public class Menu {
    private int restaurantId;
    private ArrayList<String> categories;
    private ArrayList<String> items;
    private ArrayList<String> descriptions;

    public Menu(int restaurantId, ArrayList<String> categories, ArrayList<String> items, ArrayList<String> descriptions) {
        this.restaurantId = restaurantId;
        this.categories = categories;
        this.items = items;
        this.descriptions = descriptions;
    }

    public Menu() {
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public ArrayList<String> getDescriptions() {
        return descriptions;
    }
}
