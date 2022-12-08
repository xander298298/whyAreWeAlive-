package com.example.pleasesendhelpgodplease;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Bomb extends Item{

    private ArrayList<Integer> location = new ArrayList<Integer>(); // Create an ArrayList object
    private Boolean exploded;
    private int explosion;

    private Menu menu = new Menu();


    public Bomb(ArrayList<Integer> location, Boolean exploded, int explosion) {
        this.location = location;
        this.exploded = exploded;
        this.explosion = explosion;
    }

    public void explodeBomb(ArrayList<Integer> location, ArrayList<String> listOfItems) throws FileNotFoundException {
        for (String i : listOfItems) {
            if (i.equals(location.get(0)) || i.equals(location.get(1))) {
                listOfItems.remove(i);
                //board.getTile(location).removeItem();
                menu.getBoard().getTile(location.get(0), location.get(1)).removeItem();
            }

        }
    }

    public ArrayList<Integer> getLocation() {
        return location;
    }

    public Boolean getExploded() {
        return exploded;
    }

    public int getExplosion() {
        return explosion;
    }
}



