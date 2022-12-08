package com.example.pleasesendhelpgodplease;

import java.util.ArrayList; // import the ArrayList class

abstract class Item {

    ArrayList<Integer> listOfItemLocations = new ArrayList<Integer>(); // Create an ArrayList object
    ArrayList<String> listOfDoorsOrGates = new ArrayList<String>(); // Create an ArrayList object

    private int amountOfItems;
    private int noOfBomb;
    private int noOfClock;
    private int noOfLoot;
    private int noOfGatesandLevers;
    private int noOfDoors;


    public void removeLocation(ArrayList<Integer> locationsToRemove) {
        for (Integer i : locationsToRemove) {
            if (i.equals(listOfItemLocations.get(0)) || i.equals(listOfItemLocations.get(1))) {
                listOfItemLocations.remove(i);
            }
        }
    }

    public ArrayList<Integer> getListOfItemLocations() {
        return listOfItemLocations;
    }

    public void setlistOfItemLocations (ArrayList <Integer> listOfItemLocations) {
        this.listOfItemLocations = listOfItemLocations;
    }

    public ArrayList<String> getListOfDoorsOrGates () {
        return listOfDoorsOrGates;
    }

    public void setListOfDoorsOrGates (ArrayList < String > listOfDoorsOrGates) {
        this.listOfDoorsOrGates = listOfDoorsOrGates;
    }

    public int getAmountOfItems () {
        return amountOfItems;
    }

    public void setAmountOfItems ( int amountOfItems){
        this.amountOfItems = amountOfItems;
    }

    public int getNoOfBomb () {
        return noOfBomb;
    }

    public void setNoOfBomb ( int noOfBomb){
        this.noOfBomb = noOfBomb;
    }

    public int getNoOfClock () {
        return noOfClock;
    }

    public void setNoOfClock ( int noOfClock){
        this.noOfClock = noOfClock;
    }

    public int getNoOfLoot () {
        return noOfLoot;
    }

    public void setNoOfLoot ( int noOfLoot){
        this.noOfLoot = noOfLoot;
    }

    public int getNoOfGatesandLevers () {
        return noOfGatesandLevers;
    }

    public void setNoOfGatesandLevers ( int noOfGatesandLevers){
        this.noOfGatesandLevers = noOfGatesandLevers;
    }

    public int getNoOfDoors () {
        return noOfDoors;
    }

    public void setNoOfDoors ( int noOfDoors){
        this.noOfDoors = noOfDoors;
    }


}
