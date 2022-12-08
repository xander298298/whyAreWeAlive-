package com.example.pleasesendhelpgodplease;

import java.util.ArrayList;

public class Loot4 extends Item{

    private ArrayList<Integer> location = new ArrayList<Integer>(); // Create an ArrayList object
    private String typeOfLoot;
    private int value;


    public Loot4(ArrayList<Integer> location, String typeOfLoot, int value) {
        this.location = location;
        this.typeOfLoot = typeOfLoot;
        this.value = value;
    }

    public int collectLoot(String collector) {
        removeLocation(location);
        if (collector == "player") {
            return value;
        } else {
            return 0;
        }
    }

    public ArrayList<Integer> getLocation() {
        return location;
    }

    public String getTypeOfLoot() {
        return typeOfLoot;
    }

    public void setTypeOfLoot(String typeOfLoot) {
        this.typeOfLoot = typeOfLoot;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
