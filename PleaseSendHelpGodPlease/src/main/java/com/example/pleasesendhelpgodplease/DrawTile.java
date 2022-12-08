package com.example.pleasesendhelpgodplease;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DrawTile extends Application{
	private static final int TILE_WIDTH=79;
	private static final int CANVAS_WIDTH=80;
	private static final int SUB_TILE_WIDTH=40;
	private ArrayList<Tile> tiles = new ArrayList<Tile>();
	private int X;
	private int Y;
	private Image flyingAssasinImage = new Image ("images/flying assasin.png");
	private Image playerImage1 = new Image ("images/playerchar.png");
	private Image dumbThiefImage = new Image ("images/dumbtThief.png");
	private Image smartTHiefImage = new Image ("images/smartThief.png");
	
	private Image blueFireWall = new Image ("images/bluFireWall.png");
	private Image redFireWall = new Image ("images/redFireWall.png");
	private Image greenFireWall = new Image ("images/greFileWall.png");
	
	private Image blueUSB = new Image ("images/bluUSB.png");
	private Image redUSB = new Image ("images/redUsb.png");
	private Image greenUSB = new Image ("images/greUSB.png");
	
	private Image loot1 = new Image ("images/lootBasic.png");
	private Image loot2 = new Image ("images/loot2.png");
	private Image loot3 = new Image ("images/loot3.png");
	private Image loot4 = new Image ("images/loot4.png");
	
	private Image clockImage = new Image ("images/clock.png");
	private Image bombImage = new Image ("images/ratbomb.png");
	private Image doorImage = new Image ("images/door.png");
	private Menu menu;
	
	

	public void start(Stage primaryStage) throws FileNotFoundException {
		setDrawTile();
		StackPane stackPane=drawGame();
		Scene scene = new Scene(stackPane);
		primaryStage.setTitle("tile creator");
		primaryStage.setScene(scene); // Place in scene in the stage
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
	private void setDrawTile() throws FileNotFoundException {
		this.menu= new Menu();
		this.tiles = menu.getBoard().getTiles();
		this.X=tiles.get((tiles.size()-1)).getCoords()[0]+1;
		this.Y=tiles.get((tiles.size()-1)).getCoords()[1]+1;
		System.out.println(X+" "+Y);
	}
	public StackPane drawGame() throws FileNotFoundException {
		StackPane stackPane=new StackPane();

		Canvas clockLayer = new Canvas((X*CANVAS_WIDTH)+100,Y*CANVAS_WIDTH);
		GridPane miniTileLayer = new GridPane();
		GridPane largeTileLayer = new GridPane();
		Canvas itemLayer = new Canvas(X*CANVAS_WIDTH,Y*CANVAS_WIDTH);
		Canvas theivesLayer =new Canvas(X*CANVAS_WIDTH,Y*CANVAS_WIDTH);
		Canvas flyingAssasinLayer =new Canvas(X*CANVAS_WIDTH,Y*CANVAS_WIDTH);
		miniTileLayer=drawTiles(miniTileLayer);
		largeTileLayer=drawLargeTiles(largeTileLayer);
		
		itemLayer=drawAllItems(itemLayer, tiles);
		theivesLayer =drawAllTheives(theivesLayer, tiles);
		flyingAssasinLayer= drawAllNortons(flyingAssasinLayer, tiles);
		
		stackPane.getChildren().add(miniTileLayer);
		stackPane.getChildren().add(largeTileLayer);
		stackPane.getChildren().add(itemLayer);
		stackPane.getChildren().add(theivesLayer);
		stackPane.getChildren().add(flyingAssasinLayer);
		return stackPane;
	}
	
	private Canvas drawAllItems(Canvas canvas, ArrayList<Tile> items) {
		for (int i=0; i<items.size(); i++) {
			if (items.get(i).hasItem()) {
				int[] coords =items.get(i).getCoords();
				canvas=drawItems(canvas, coords[0], coords[1], items.get(i).getItemID());
			}
		}
		return canvas;
	}
	
	private Canvas drawAllNortons(Canvas canvas, ArrayList<Tile> theives) {
		for (int i=0; i<theives.size(); i++) {
			if (theives.get(i).getCharID().equals("FA")) {
				int[] coords =theives.get(i).getCoords();
				canvas=drawNorton(canvas, coords[0], coords[1]);
			}
		}
		return canvas;
	}
	
	private Canvas drawAllTheives(Canvas canvas, ArrayList<Tile> theives) {
		for (int i=0; i<theives.size(); i++) {
			if (theives.get(i).hasCharacter()) {
				int[] coords =theives.get(i).getCoords();
				canvas=drawPlayer(canvas, coords[0], coords[1], theives.get(i).getCharID());
			}
		}
		return canvas;
	}
	
	/**
	 * draws large black tiles to show groups of tiles
	 * @param pane2
	 * @return pane 2 
	 */
	public GridPane drawLargeTiles(GridPane pane2) {
		Color c=new Color(1f,0f,0f,.0f );
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				Rectangle r = new Rectangle(TILE_WIDTH , TILE_WIDTH+5, TILE_WIDTH, TILE_WIDTH);
				r.setStroke(Color.BLACK);
				r.setFill(c);
				pane2.add(r, (j), (i));
				}
			}
		return pane2;
	}

	/**
	 * draws the mini tiles
	 * @param pane1
	 * @return pane 1
	 */
	public GridPane drawTiles(GridPane pane1){
		for (int i = 0; i < X*2; i=i+2) {
		   for (int j = 0; j < Y*2; j=j+2) {
			    Rectangle r1 = new Rectangle(SUB_TILE_WIDTH , SUB_TILE_WIDTH, SUB_TILE_WIDTH, SUB_TILE_WIDTH);
				Rectangle r2 = new Rectangle(SUB_TILE_WIDTH , SUB_TILE_WIDTH, SUB_TILE_WIDTH, SUB_TILE_WIDTH);
				Rectangle r3 = new Rectangle(SUB_TILE_WIDTH , SUB_TILE_WIDTH, SUB_TILE_WIDTH, SUB_TILE_WIDTH);
				Rectangle r4 = new Rectangle(SUB_TILE_WIDTH , SUB_TILE_WIDTH, SUB_TILE_WIDTH, SUB_TILE_WIDTH);
				r1.setFill(Color.YELLOW);
				r2.setFill(Color.BLUE);
				r3.setFill(Color.RED);
				r4.setFill(Color.GREEN);
				pane1.add(r1, j, i);
				pane1.add(r2, (j+1), i);
				pane1.add(r3, (j), (i+1)); // +1 added to take 3rd and 4 mini tiles to row below
				pane1.add(r4, (j+1), (i+1));
		    }
		}
		return pane1;
	}
	
	public Canvas drawItems(Canvas iLayer, int x ,int y, String ID) {
		GraphicsContext gc= iLayer.getGraphicsContext2D();
		if (ID != null) {
            switch (ID) {
                case "LO":
            		gc.drawImage(loot1, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
                    break;
                case "L1":
            		gc.drawImage(loot2, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
                    break;
                case "L2":
                    gc.drawImage(loot3, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
                    break;
                case "L3":
            		gc.drawImage(loot4, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
                    break;
                case "CO":
                	gc.drawImage(clockImage, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
                	break;
                case "RD":
               	 	gc.drawImage(redFireWall, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
               	 	break;
                case "BD":
               	 	gc.drawImage(blueFireWall, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
               	 	break;
                case "GD":
               	 	gc.drawImage(greenFireWall, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
               	 	break;
                case "RK":
                	gc.drawImage(redUSB, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
                	break;
                case "BK":
                	gc.drawImage(blueUSB, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
                	break;
                case "GK":
               	 	gc.drawImage(greenUSB, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
                    break;
                case "Do":
               	 	gc.drawImage(doorImage, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
                    break;
            }    
           }
		return iLayer;
		
	}

	public Canvas drawPlayer(Canvas iLayer, int x ,int y, String ID) {
		GraphicsContext gc= iLayer.getGraphicsContext2D();
		if (ID != null) {
            switch (ID) {
                case "PC":
            		gc.drawImage(playerImage1, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
                    break;
                case "ST":
                	gc.drawImage(smartTHiefImage, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
                    break;
                case "DT":
                	gc.drawImage(dumbThiefImage, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
                    break;
            	}    
           }
		return iLayer;
		
	}
	
	public Canvas drawNorton(Canvas faLayer, int x, int y) {
		GraphicsContext gc= faLayer.getGraphicsContext2D();
		gc.drawImage(flyingAssasinImage, x*CANVAS_WIDTH,y*CANVAS_WIDTH);
		return faLayer;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}