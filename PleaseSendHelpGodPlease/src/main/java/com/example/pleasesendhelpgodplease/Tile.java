package com.example.pleasesendhelpgodplease;

import java.util.ArrayList;

/**
 * <h1>Tile class</h1>
 * The Tile class implements the interactions of
 * specific locations on the board. This includes
 * Item and Character interactions management and
 * location tracking.
 *
 * @author Leo Muller, edited by Peter Jones
 * @version 1.0
 * @since 2022-11-20
 */
public class Tile {
    private final int x;
    private final int y;
    private final String colours;
    private String itemID;
    private String charID;

    private Entity character;
    private Item item;

    public Tile(int x, int y, String colours, String ID) {
        this.x = x;
        this.y = y;
        this.colours = colours;

        //if ID isn't empty, run to add item or entity to tile
        if (ID != null) {
            this.itemID = ID.substring(0, 2);
            this.charID = ID.substring(2);
            int[] coords = {x, y};
            ArrayList<Integer> location = new ArrayList<Integer>();
            location.add(x);
            location.add(y);
            //creates character on tile based on ID input
            switch (charID) {
                case "PC":
                    this.character = new Player(x, y, "North");
                    break;
                //case "ST":
                //    this.character = new SmartThief();
                //    break;
                case "DT":
                    this.character = new DumbThief(coords, 'n');
                    break;
                case "FA":
                    this.character = new FlyingAssasin();
                    break;
                default:
                    this.character = null;
                    this.charID = "NA";
            }
            //creates item in tile based on ID input
            switch (itemID) {
                case "LO":
                    this.item = new Loot1(location, ID, y);
                    break;
                case "L1":
                    this.item = new Loot2(location, ID, y);
                    break;
                case "L2":
                    this.item = new Loot3(location, ID, y);
                    break;
                case "L3":
                    break;
                case "CO":
                    this.item = new Loot4(location, ID, y);
                    break;
                case "RD":
                    this.item = new Gate(location, colours, false);
                    break;
                case "BD":
                    this.item = new Gate(location, colours, false);
                    break;
                case "GD":
                    this.item = new Gate(location, colours, false);
                    break;
                case "RK":
                    this.item = new Lever(location, colours);
                    break;
                case "BK":
                    this.item = new Lever(location, colours);
                    break;
                case "GK":
                    this.item = new Lever(location, colours);
                    break;
                case "Bo":
                    this.item = new Bomb(location, false, 0);
                    break;
                case "Do":
                    this.item = new Door(location);
                    break;
                default:
                    this.item = null;
                    this.itemID = "NA";
            }
        }
    }

    public void drawTile () {
        //to be programmed
        // probs will be call a instance of Draw class
    }

    /**
     * Merges x and y coordinates into array.
     * @return coordinates of tile.
     */
    public int[] getCoords() {
        int[] coords = {x, y};
        return coords;
    }

    /**
     * Partition colour String into array of strings
     * @return array of colours on tile
     */
    public String[] getColours() {
        String c1=colours.substring(0,1);
        String c2=colours.substring(1,2);
        String c3=colours.substring(2,3);
        String c4=colours.substring(3);
        String [] colourArray = {c1,c2,c3,c4};
        return colourArray;
    }

    /**
     * Returns the colour String from tile
     * @return colours as single String
     */
    public String getColoursAsString() {
        return colours;
    }

    /**
     * Merges Item ID and character ID
     * @return all IDs on tile as single String
     */
    public String getID() {
        return (itemID+charID);
    }

    /**
     * Checks to see if there are entities or a gate in tile
     * @return true if the tile is free for character occupation
     */
    public boolean isOccupied() {
        boolean occupy;
        //sets occupy boolean based on tile occupiers
        if ((character != null) && !(character instanceof FlyingAssasin)) {
            occupy = true;
        }else if (item instanceof Gate) {
            occupy = true;
        } else {
            occupy = false;
        }
        return occupy;
    }

    /**
     * Returns itemID String from tile
     * @return ID of item in tile as string
     */
    public String getItemID() {
        return itemID;
    }
    /**
     * Returns Item instance on tile
     * @return instance of Item on tile
     */
    public Item getItem() {
        return this.item;
    }

    /**
     * Returns boolean for presence of item
     * @return true if tile has instance of item
     */
    public boolean hasItem() {
        boolean hasItem = false;

        if (item != null) {
            hasItem = true;
        }
        return hasItem;
    }

    /**
     * Sets item in class
     * @param item instance of item on class
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Removes item from class
     */
    public void removeItem() {
        this.itemID = "NA";
        this.item = null;
    }

    /**
     * Returns charID String from tile
     * @return ID of character in tile as string
     */
    public String getCharID() {
        return charID;
    }

    /**
     * Returns boolean for presence of character
     * @return true if tile has instance of character
     */
    public boolean hasCharacter() {
        boolean hasCharacter = false;

        if (character != null) {
            hasCharacter = true;
        }
        return hasCharacter;
    }

    /**
     * Returns Entity instance on tile
     * @return instance of Entity on tile
     */
    public Entity getCharacter() {
        return character;
    }
    public void setCharacter(Entity character) {
        //just adds character if tile doesn't have one
        if ((this.character == null) && !(this.item instanceof Gate)) {
            charID = "NA";
            if (character instanceof Player) {
                charID = "PC";
            }
            //if (character instanceof SmartThief) {
            //    charID = "ST";
            //}
            if (character instanceof DumbThief) {
                charID = "DT";
            }
            if (character instanceof FlyingAssasin) {
                charID = "FA";
            }
            this.character = character;
        } else {
            if (this.character instanceof FlyingAssasin) {
                //does nothing, character will delete itself
            } else if (character instanceof FlyingAssasin) {
                this.character = character;
                charID = "FA";
            } else {
                throw new IllegalStateException("Tile is occupied");
            }
        }
    }
    public void removeCharacter() {
        this.charID = "NA";
        this.character = null;
    }
}