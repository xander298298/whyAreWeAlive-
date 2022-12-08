package com.example.pleasesendhelpgodplease;

import java.util.ArrayList;

public class Gate extends Item{
    private ArrayList<Integer> location = new ArrayList<Integer>(); // Create an ArrayList object
    private String colour;
    private boolean opened;


    public Gate(ArrayList<Integer> location, String colour, boolean opened) {
        this.location = location;
        this.colour = colour;
        this.opened = opened;
    }

    public void openGate() {
        //board.getTile(location).removeItem();
    }

    public ArrayList<Integer> getLocation() {
        return location;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
}


