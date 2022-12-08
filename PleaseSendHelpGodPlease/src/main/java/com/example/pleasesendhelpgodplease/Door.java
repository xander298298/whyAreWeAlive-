package com.example.pleasesendhelpgodplease;

import java.util.ArrayList;

public class Door extends Item{

    private ArrayList<Integer> location = new ArrayList<Integer>(); // Create an ArrayList object

    public Door(ArrayList<Integer> location) {
        this.location = location;
    }

    public ArrayList<Integer> getLocation() {
        return location;
    }
}
