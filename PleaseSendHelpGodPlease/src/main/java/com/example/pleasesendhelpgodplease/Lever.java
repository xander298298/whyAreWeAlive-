package com.example.pleasesendhelpgodplease;

import java.util.ArrayList;

public class Lever extends Item{
    private ArrayList<Integer> location = new ArrayList<Integer>(); // Create an ArrayList object
    private String colour;
    private boolean collected = false;


    public Lever(ArrayList<Integer> location, String colour) {
        this.location = location;
        this.colour = colour;
    }

    public void collectLeaver() {
        collected = false;
        //Gate.openGate();
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

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }
}
