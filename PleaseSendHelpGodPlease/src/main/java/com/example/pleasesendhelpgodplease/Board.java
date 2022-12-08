package com.example.pleasesendhelpgodplease;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 *
 * @author Peej
 *
 */

public class Board {
    private ArrayList<Tile> tiles = new ArrayList<Tile>();
    private String saveFile;
    private long timeLimit;
    private int itemsLeft =0;
    private int coloumns;
    private int rows;
    private int FILE_STRING_SPLIT_NUMB=4;

    public Board(String saveFile) throws FileNotFoundException{
        setBoard(saveFile);
        //System.out.println(("hi"));
    }
    private void setBoard(String saveFile) throws FileNotFoundException{
        System.out.println("imm here");
        File initialLevelFile = new File(saveFile);
        Scanner in = new Scanner(initialLevelFile);
        this.rows=0;
        String line;
        Tile tile;
        String colour;
        String ID;
        while (in.hasNextLine()){
            line = in.nextLine();
            //System.out.println(line);
            if (rows>0){
                //String[] colomns = line.split(" "); // at tabs
                this.coloumns=line.split(" ").length;
                //System.out.println((this.coloumns));
                for (int xCoord=0; xCoord<coloumns; xCoord++) {
                    colour=line.split(" ")[xCoord].substring(0,FILE_STRING_SPLIT_NUMB);
                    ID=line.split(" ")[xCoord].substring(FILE_STRING_SPLIT_NUMB);
                    tile = new Tile(xCoord, rows - 1, colour, ID);
                    tiles.add(tile);
                    if (tile.getItemID().equals("LO") || tile.getItemID().equals("L1") 
                    		|| tile.getItemID().equals("L2") || tile.getItemID().equals("L3")){
                        itemsLeft=itemsLeft+1;

                    }
                }
            } else {
                timeLimit=Integer.parseInt(line)*1000;
            }
            this.rows++;
        }
        runGame();
    }

    //int[] coords = {0, 0};

    public Tile getTile(int xCoord, int yCoord) { //make it work with remove item
        for (int i=0; i<tiles.size(); i++) {
            //coords =tiles.get(i).getCoords();
            if ((xCoord==tiles.get(i).getCoords()[0])&&(yCoord==tiles.get(i).getCoords()[1])) {
                return tiles.get(i);
            }
        }
        return null;
    }
    public String getSaveFile() {
        return saveFile;
    }

  
    public void updateItemsLeft(){
    	int items=0;
    	for (int i=0; i<tiles.size(); i++) {
    		if (tiles.get(i).getItemID().equals("LO") || tiles.get(i).getItemID().equals("L1") 
            		|| tiles.get(i).getItemID().equals("L2") || tiles.get(i).getItemID().equals("L3")) {
    			items++;
    		}	
    	}
    	this.itemsLeft=items;
    }
    
    public boolean checkLeversLeft() {
    	boolean leversLeft=false;
    	for (int i=0; i<tiles.size(); i++) {
    		if (tiles.get(i).getItemID().equals("RK")|| tiles.get(i).getItemID().equals("BK") 
    				|| tiles.get(i).getItemID().equals("GK")) {
    			leversLeft=true;
    		}
    	}
    	return leversLeft;
    }
    
    private boolean checkPlayerWin() {
    	boolean playerWin=false;
    	if (itemsLeft==0) {
    		for (int i = 0; i<tiles.size(); i++) {
        		if (tiles.get(i).getItemID().equals("DO") && tiles.get(i).getCharID().equals("PC") && !checkLeversLeft()) {
        			playerWin=true;
        		}
    		}
    	}
    	
    	
    	return playerWin;
    } 
    
    private boolean checkPlayerLoose(){
    	boolean playerLoose=false;
    	for (int i = 0; i<tiles.size(); i++) {
    		if (tiles.get(i).getCharID().equals("PC")) {
    			boolean playerAlive=true;
    		}
    	}
    	if (timeLimit==0) {
    		playerLoose=true;
    	}
    	if (itemsLeft==0) {
    		for (int i = 0; i<tiles.size(); i++) {
        		if (tiles.get(i).getItemID().equals("DO") && (!tiles.get(i).getCharID().equals("PC") || !tiles.get(i).getCharID().equals("PC") )) {
        			playerLoose=true;
        		}
    		}
    	}
    	return playerLoose;
    }


    private void runGame() throws FileNotFoundException{
        long time = System.currentTimeMillis();
        long end =time+timeLimit;
        System.out.println(tiles.size());
        
        DrawTile d1 = new DrawTile();
        Stage stage = new Stage();
        d1.start(stage);
        while (checkPlayerWin() && !checkPlayerLoose() && System.currentTimeMillis()<end) {
            updateItemsLeft();
            

        }

    System.out.println("ended");
    }

    public void test() throws FileNotFoundException {
        //setBoard("src/board.txt");
        System.out.println(tiles.get(0));
        System.out.println(saveFile(tiles, 0, 100 ));
    }

    public String saveFile(ArrayList<Tile> tiles, int itemsLeft , int timeLeft) {
        String str=Integer.toString(timeLeft)+"\n";
        String saveFile = this.saveFile+"playerName"+".txt";
        File levelFile= new File (saveFile);
        Tile tile;
        //System.out.println(rows);
        //System.out.println(coloumns);
        for (int i =0; i < rows; i++) {
            for (int j =0; j < coloumns; j++) {
                //System.out.println(i);
                //System.out.println(j);
                for (int k=0; k<tiles.size(); k++) {
                	int x=tiles.get(k).getCoords()[0];
                	int y=tiles.get(k).getCoords()[1];
                	if (x==j && y==i) {
                		tile=tiles.get(k);
                        str+=tile.getColoursAsString() +tile.getID()+" ";
                        System.out.println(str);
                	}
                }
            }
            str += "\n";
        }
        PrintWriter out = null;
        try {
            out = new PrintWriter(levelFile);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(0);
        }
        out.print(str);
        out.close();
        return saveFile;
    }
	
    public ArrayList<Tile> getTiles() {
		return tiles;
	}

	
}