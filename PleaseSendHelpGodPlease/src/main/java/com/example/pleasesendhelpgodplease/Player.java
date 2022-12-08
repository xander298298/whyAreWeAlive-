package com.example.pleasesendhelpgodplease;

import java.io.FileNotFoundException;

public class Player extends Entity{
    Menu menu = new Menu();

    private KeyChecker keyCheck;
    private int[] locationCoord = {0,0};
    private int[] startingLocation = {0, 0};
    private String directionFacing;


    /*
     * Constructor of Player at a starting position
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @param directionFacing The direction the player is facing.
     */
    public Player (int x, int y,  String directionFacing){
        //System.out.println(x );
        //System.out.println(y );
        //System.out.println(directionFacing );
        this.locationCoord[0] = x;
        this.locationCoord[1] = y;
        this.directionFacing = directionFacing;
        this.startingLocation[0] = x;
        this.startingLocation[1] = y;
        this.keyCheck = new KeyChecker();
    }

    public int[] getLocation(){
        return this.locationCoord;
    }


    /*
     * Set the location of the player.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public void setLocation(int x, int y){
        this.locationCoord[0] = x;
        this.locationCoord[1] = y;
    }


    /*
     * Set the location of the player's x coordinate.
     * @param x The x coordinate.
     */
    public void setLocationX(int x){
        this.locationCoord[0] = x;
    }


    /*
     * Set the location of the player's y coordinate.
     * @param y The y coordinate.
     */
    public void setLocationY(int y){
        this.locationCoord[1] = y;
    }


    /*
     * Get the x coordinate of the player.
     * @return the x coordinate of the player.
     */
    public int getLocationX(int[] locationCoord){
        return locationCoord[0];
    }


    /*
     * Get the y location of the player.
     * @return the y coordinate of the player.
     */
    public int getLocationY(int[] locationCoord){
        return locationCoord[1];
    }


    public void updateLocation() throws FileNotFoundException {
        //Uses the keychecker class to determine movement.
        if(keyCheck.upPressed == true && isLegalMove() == true){
            System.out.println("up");
            move();
            //checks if the movement is legal, if so it updates the location to the nearest legal tile.
        }
        else if(keyCheck.downPressed == true && isLegalMove() == true){
            System.out.println("down");
            move();
        }else if(keyCheck.leftPressed == true && isLegalMove() == true){
            System.out.println("left");
            move();
        }else if(keyCheck.rightPressed == true && isLegalMove() == true){
            System.out.println("right");
            move();
        }
    }

    public Boolean isLegalMove() throws FileNotFoundException {

        //get the tile the player is currently on.
        Tile current = menu.getBoard().getTile(locationCoord[0], locationCoord[1]);

        //get the current tile's colour.

        String [] currentColour = current.getColours();
        //work out the player's proximity to the borders of the Board.
        int distanceToEdgeNorth = this.locationCoord[1];
        int distanceToEdgeSouth = 10 - this.locationCoord[1];
        int distanceToEdgeEast = this.locationCoord[0];
        int distanceToEdgeWest = 10 - this.locationCoord[0];
        boolean legal = false;
        //Loops to check which way the player is
        if(this.directionFacing.equals("North")){
            //loop through the remaining tiles to the edge from where the player's position.
            //with each iteration, check the tile's colour.
            legal = false;
            //If any colour matches one of the current tile legal move is valid and player's position is set to this.
            Tile nextTile;
            String[] nextColour = {"", "", "", ""};
            int[] nextLocation = this.locationCoord;
            for(int i = 0; i < distanceToEdgeNorth; i++){
                nextLocation[1] -= 1;
                //System.out.println((i));
                nextTile = menu.getBoard().getTile(nextLocation[0], nextLocation[1]);
                nextColour = nextTile.getColours();
                for(i = 0; i < nextColour.length; i++){
                    if(nextColour[i].equals(currentColour[i])){
                        legal = true;

                    }
                }
            }
        }

        if(this.directionFacing.equals("South")){
            legal = false;
            Tile nextTile;
            int[] nextLocation = this.locationCoord;
            for(int i = 0; i < distanceToEdgeSouth; i++){
                nextLocation[1] += 1;
                nextTile = menu.getBoard().getTile(nextLocation[0], nextLocation[1]);
                String[] nextColour = nextTile.getColours();
                for(i = 0; i < nextColour.length; i++){
                    if(nextColour[i] == currentColour[i]){
                        legal = true;
                    }
                }
            }

        }

        if(this.directionFacing.equals("East")){
            legal = false;
            Tile nextTile;
            int[] nextLocation = this.locationCoord;
            for(int i = 0; i < distanceToEdgeEast; i++){
                nextLocation[0] -= 1;
                nextTile = menu.getBoard().getTile(nextLocation[0], nextLocation[1]);
                String[] nextColour = nextTile.getColours();
                for(i = 0; i < nextColour.length; i++){
                    if(nextColour[i] == currentColour[i]){
                        legal = true;

                    }
                }
            }

        }

        if(this.directionFacing.equals("West")){
            legal = false;
            Tile nextTile;
            int[] nextLocation = this.locationCoord;
            for(int i = 0; i < distanceToEdgeWest; i++){
                nextLocation[0] += 1;
                nextTile = menu.getBoard().getTile(nextLocation[0], nextLocation[1]);
                String[] nextColour = nextTile.getColours();
                for(i = 0; i < nextColour.length; i++){
                    if(nextColour[i] == currentColour[i]){
                        legal = true;

                    }
                }
            }

        }
        return legal;
    }

    public void move() throws FileNotFoundException{
        Menu menu = new Menu();
        Tile current = menu.getBoard().getTile(locationCoord[0], locationCoord[1]);

        //get the current tile's colour.

        String [] currentColour = current.getColours();
        //work out the player's proximity to the borders of the Board.
        int distanceToEdgeNorth = this.locationCoord[1];
        int distanceToEdgeSouth = 10 - this.locationCoord[1];
        int distanceToEdgeEast = this.locationCoord[0];
        int distanceToEdgeWest = 10 - this.locationCoord[0];

        //Loops to check which way the player is
        if(this.directionFacing.equals("North")){
            //loop through the remaining tiles to the edge from where the player's position.
            //with each iteration, check the tile's colour
            //If any colour matches one of the current tile legal move is valid and player's position is set to this.
            Tile nextTile;
            String[] nextColour = {"", "", "", ""};
            int[] nextLocation = this.locationCoord;
            for(int i = 0; i < distanceToEdgeNorth; i++){
                nextLocation[1] -= 1;
                //System.out.println((i));
                nextTile = menu.getBoard().getTile(nextLocation[0], nextLocation[1]);
                nextColour = nextTile.getColours();
                for(i = 0; i < nextColour.length; i++){
                    if(nextColour[i].equals(currentColour[i])){
                        this.locationCoord = nextTile.getCoords();
                    }
                }
            }
        }

        if(this.directionFacing.equals("South")){
            Tile nextTile;
            int[] nextLocation = this.locationCoord;
            for(int i = 0; i < distanceToEdgeSouth; i++){
                nextLocation[1] += 1;
                nextTile = menu.getBoard().getTile(nextLocation[0], nextLocation[1]);
                String[] nextColour = nextTile.getColours();
                for(i = 0; i < nextColour.length; i++){
                    if(nextColour[i] == currentColour[i]){
                        this.locationCoord = nextTile.getCoords();
                    }
                }
            }

        }

        if(this.directionFacing.equals("East")){
            Tile nextTile;
            int[] nextLocation = this.locationCoord;
            for(int i = 0; i < distanceToEdgeEast; i++){
                nextLocation[0] -= 1;
                nextTile = menu.getBoard().getTile(nextLocation[0], nextLocation[1]);
                String[] nextColour = nextTile.getColours();
                for(i = 0; i < nextColour.length; i++){
                    if(nextColour[i] == currentColour[i]){
                        this.locationCoord = nextTile.getCoords();
                    }
                }
            }

        }

        if(this.directionFacing.equals("West")){
            Tile nextTile;
            int[] nextLocation = this.locationCoord;
            for(int i = 0; i < distanceToEdgeWest; i++){
                nextLocation[0] += 1;
                nextTile = menu.getBoard().getTile(nextLocation[0], nextLocation[1]);
                String[] nextColour = nextTile.getColours();
                for(i = 0; i < nextColour.length; i++){
                    if(nextColour[i] == currentColour[i]){
                        this.locationCoord = nextTile.getCoords();
                    }
                }
            }

        }
    }
}
