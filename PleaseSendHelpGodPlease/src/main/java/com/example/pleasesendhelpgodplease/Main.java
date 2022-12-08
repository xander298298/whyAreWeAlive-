package com.example.pleasesendhelpgodplease;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main extends Application {
    public void start(Stage primaryStage) throws IOException {
        //Board b1 = new Board("src/board.txt");
    	
        //Player player = new Player( 1, 1, "North");
        //player.isLegalMove(new int[]{2, 2});
        //boolean a = true;
        //while (a = true){
        //    player.updateLocation();
        //}
        //System.out.println(player.getLocationX(player.getLocation()) );
        //System.out.println(player.getLocationY(player.getLocation()));
    	Menu menu = new Menu();
        //menu.start(primaryStage);
        //menu.getBoard();
        menu.getBoard().test();
        //menu.run();
        //10x10

        //Player player = new Player( 5, 6, "North");
        //System.out.println(player.getLocation());

    }

	public static void main(String[] args) throws Exception {
		launch(args);
		
	}
	//--module-path "D:\Java\javafx-sdk-19\lib" --add-modules javafx.controls,javafx.fxml
}