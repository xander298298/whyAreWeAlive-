/*package com.example.gamebutworking;

import java.io.FileNotFoundException;
import java.util.ArrayList;
public class SmartThief extends Thieves {
    private int velocity;
    private int[] coords;
    private char dirFacing;
    private char [] quickestPath;
    private ArrayList<TileNode> graph;




    private String openListPath;
    private ArrayList<Tile> visitedNodes;

    //the initial start coords
    public SmartThief(int[] coords) throws FileNotFoundException {
        this.coords = coords;
        createTileNodes();
    }




    // going to construct a new Bfs object for each path,
    // or create one and use any changes to listOfItemLocations to change my graph model
    //this must also be ran with the i and j swapped to populate all possible moves that ST can make
    public void createTileNodes(){
        try{
            Menu menu = new Menu();
            for(int i = 1 ; i <= 10 ; i++){
                for(int j = 1 ; j <= 10 ; j++){
                    graph.add(new TileNode(menu.getBoard().getTile(i,j)));
                }
            }
        }
        catch(FileNotFoundException e){
        System.out.println("no file there pal :)");
        }
    }

    public ArrayList<TileNode> getGraph(){
        return graph;
    }

}
*/
