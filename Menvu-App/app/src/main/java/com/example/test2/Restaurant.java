package com.example.test2;

public class Restaurant {
    private int id;
    private String name;
    private String phoneNumber;
    private String image;
    private Menu currentMenu;
    private String address;

    public Restaurant(int id, String name, String phoneNumber, String address,String image, Menu currentMenu) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.image = image;
        this.currentMenu = currentMenu;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }
}
