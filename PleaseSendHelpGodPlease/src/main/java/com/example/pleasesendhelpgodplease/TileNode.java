package com.example.pleasesendhelpgodplease;

import java.io.FileNotFoundException;
import java.util.*;

public class TileNode {
    private Tile tile;
    //is numbered the same as the index in the board
    private ArrayList<TileNode> validMoves;
    private boolean hasLoot;
    private final int boundaryPos = 10;
    private final int boundaryNeg = 1;

    public TileNode(Tile tile){
        this.tile = tile;
        populateValidMoves(tile);
    }

    /**
     *
     * @param tile - the tile represented by the current TileNode
     */
    public void populateValidMoves(Tile tile)  {
        Menu menu = new Menu();
        try{
            for(int i = 0 ; i <= 4 ; i++){
                //treating each number as a direction facing but checking if its a null tile
                switch(i){
                    //North ,
                    case(0):
                        int[] innitN = tile.getCoords();
                        int n = innitN[1];
                        //whilst the move is invalid keep traversing in that direction
                        while(checkValid(menu.getBoard().getTile(innitN[0], n), menu.getBoard().getTile(innitN[0], n - 1)) && n <= 9){
                            n += 1;
                        }
                        if(checkValid(tile, menu.getBoard().getTile(innitN[0],n))){
                            validMoves.add(new TileNode(menu.getBoard().getTile(innitN[0], n)));
                        }
                        //adding to valid move if there is a TileNode that can be accessed in that location
                    case(1):
                        int[] innitE = tile.getCoords();
                        int e = innitE[1];
                        while(checkValid(menu.getBoard().getTile(e, innitE[0]), menu.getBoard().getTile(innitE[0], e - 1)) && e <= 9){
                            e += 1;
                        }
                        if(checkValid(tile, menu.getBoard().getTile(e, innitE[0]))){
                            validMoves.add(new TileNode(menu.getBoard().getTile(e,innitE[0])));
                        }
                    case(2):
                        int[] innitS = tile.getCoords();
                        int s = innitS[1];
                        while(checkValid(menu.getBoard().getTile(innitS[0], s), menu.getBoard().getTile(innitS[0], s - 1)) && s >= 9){
                            s -= 1;
                        }
                        if(checkValid(tile, menu.getBoard().getTile(innitS[0],s))) {
                            validMoves.add(new TileNode(menu.getBoard().getTile(innitS[0], s)));
                        }
                    case(3):
                        int[] innitW = tile.getCoords();
                        int w = innitW[1];
                        while(checkValid(menu.getBoard().getTile(w, innitW[1]), menu.getBoard().getTile(innitW[0], w - 1)) && w >= 9){
                            w -= 1;
                        }
                        if((checkValid(tile, menu.getBoard().getTile(w, innitW[1])))) {
                             validMoves.add(new TileNode(menu.getBoard().getTile(w, innitW[1])));
                        }
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("no file there :)");
        }

    }






    public boolean checkValid(Tile from, Tile to){
        String outbound = from.getColoursAsString();
        String inBound = to.getColoursAsString();
        int count = 0;
        for (int i = 0 ; i < outbound.length() ; i++){
            for(int j = 0 ; j < inBound.length() ; j++){
                count++;
            }
        }
        return count > 0;
    }
}
