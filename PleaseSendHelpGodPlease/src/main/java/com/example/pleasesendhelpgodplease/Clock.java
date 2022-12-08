package com.example.pleasesendhelpgodplease;

import java.util.ArrayList;

public class Clock extends Item{
    private ArrayList<Integer> location = new ArrayList<Integer>(); // Create an ArrayList object
    private int timeToAdd;


    public Clock(ArrayList<Integer> location, int timeToAdd) {
        this.location = location;
        this.timeToAdd = timeToAdd;
    }

    public int collectClock(String collector) {
        //board.getTile(location).removeItem();
        if (collector == "player") {
            return timeToAdd;
        } else {
            return timeToAdd - (timeToAdd*2);
        }
    }

    public ArrayList<Integer> getLocation() {
        return location;
    }

    public int getTimeToAdd() {
        return timeToAdd;
    }

    public void setTimeToAdd(int timeToAdd) {
        this.timeToAdd = timeToAdd;
    }
}
