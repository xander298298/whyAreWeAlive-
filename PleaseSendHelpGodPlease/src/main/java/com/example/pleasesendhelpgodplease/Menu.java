package com.example.pleasesendhelpgodplease;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import java.util.Scanner;



public class Menu extends Application{
    String playerTxtFile = "players.txt";
    String boardTxtFile= "board.txt";
    private Board board =null;


    //change this to any file name, dont think it needs to exist but meh
    boolean isThere = false;

    String name;
    int score;
    String line;

    Label player;
    private int windowHeight = 400;
    private int windowWidth = 400;

    double buttonWidth = 300;
    double buttonHeight = 50;

    private Stage stage;


    private Scene menuScene;

    @Override
    public void start(Stage aStage) throws IOException{

        stage = aStage;
        stage.setTitle("Menu!");
        stage.setHeight(windowHeight);
        stage.setWidth(windowWidth);
        //stage.setResizable(false);
        menuScene = mainMenu();
        stage.setScene(menuScene);
        stage.sizeToScene();
        stage.show();

    }


    private Scene mainMenu(){
        VBox root = new VBox();
        Scene scene = new Scene(root, windowWidth, windowHeight);
        root.setStyle("-fx-background-color: red");

        try {
            Label quote = new Label(getQutoe());
            quote.setAlignment(Pos.TOP_CENTER);
            root.getChildren().add(quote);

        }
        catch (Exception e){

        }


        Button createProfile = new Button("Create Profile");
        createProfile.setPrefWidth(buttonWidth);
        createProfile.setPrefHeight(buttonHeight);
        createProfile.setStyle("-fx-background-radius: 12;" + "-fx-background-color: Green;");
        createProfile.setOnAction(e -> switchToScene(createProfile()));

        Button loadProfile = new Button("Load Profile");
        loadProfile.setPrefWidth(buttonWidth);
        loadProfile.setPrefHeight(buttonHeight);
        loadProfile.setStyle("-fx-background-radius: 12;" + "-fx-background-color: Green;");
        loadProfile.setOnAction(e -> switchToScene(loadProfile()));

        Button loadGame = new Button("Load Game");
        loadGame.setPrefWidth(buttonWidth);
        loadGame.setPrefHeight(buttonHeight);
        loadGame.setStyle("-fx-background-radius: 12;" + "-fx-background-color: Green;");
        loadGame.setOnAction(e -> switchToScene(loadGame()));

        Button exitGame = new Button("Exit Game");
        exitGame.setPrefWidth(buttonWidth);
        exitGame.setPrefHeight(buttonHeight);
        exitGame.setStyle("-fx-background-radius: 12;" + "-fx-background-color: Green;");
        exitGame.setOnAction(e -> closeProgram());

        root.getChildren().addAll(createProfile, loadProfile, loadGame, exitGame);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);

        return scene;
    }

    private Scene createProfile(){
        Pane root = new Pane();
        Scene scene = new Scene(root, windowWidth, windowHeight, Color.RED);
        root.setStyle("-fx-background-color: red");


        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter Char Name: ");
        nameInput.setFocusTraversable(false);
        nameInput.setPrefWidth(buttonWidth);
        nameInput.setPrefHeight(buttonHeight);
        nameInput.setLayoutX((scene.getWidth() / 2) - (nameInput.getPrefWidth() / 2));
        nameInput.setLayoutY(50);

        nameInput.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                name = nameInput.getText();
                try {
                    createProfileFile(name);
                }
                catch (IOException e ){
                    throw new RuntimeException(e);
                }
            }
        });

        Button back = new Button("<- Main Menu");
        back.setPrefWidth(buttonWidth);
        back.setPrefHeight(buttonHeight);
        back.setOnAction(e -> switchToScene(mainMenu()));
        back.setStyle("-fx-background-radius: 12;" + "-fx-background-color: Green;");

        back.setLayoutX((scene.getWidth()/2)-(back.getPrefWidth()/2));
        back.setLayoutY(300);

        root.getChildren().addAll(nameInput, back);
        return scene;
    }

    private Scene loadProfile(){
        Pane root = new Pane();
        Scene scene = new Scene(root, windowWidth, windowHeight);
        root.setStyle("-fx-background-color: red");

        TextField nameInput = new TextField();
        nameInput.setPromptText("Enter Char Name to Search: ");
        nameInput.setFocusTraversable(false);
        nameInput.setPrefWidth(buttonWidth);
        nameInput.setPrefHeight(buttonHeight);
        nameInput.setLayoutX((scene.getWidth() / 2) - (nameInput.getPrefWidth() / 2));
        nameInput.setLayoutY(50);

        nameInput.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //System.out.println(nameInput.getText());
                name = nameInput.getText();
                try {
                    if (isThere) {
                        root.getChildren().remove(player);
                        isThere = false;
                    }
                    if (getScore(playerTxtFile, name) > -1){
                        player = new Label("Name: " + name + " Score: " + getScore(playerTxtFile, name) + " Highest Level: " + getMaxLvl(playerTxtFile, name));
                        player.setPrefHeight(buttonHeight);
                        player.setPrefWidth(buttonWidth);
                        player.setLayoutX((scene.getWidth() / 2) - (player.getPrefWidth() / 2));
                        player.setLayoutY(150);
                        if (!isThere){
                            root.getChildren().add(player);
                            isThere = true;
                        }
                    }
                    else{
                        player = new Label("Profile Not Found Try Again.");
                        player.setPrefHeight(buttonHeight);
                        player.setPrefWidth(buttonWidth);
                        player.setLayoutX((scene.getWidth() / 2) - (player.getPrefWidth() / 2));
                        player.setLayoutY(150);
                        if (!isThere){
                            root.getChildren().add(player);
                            isThere = true;
                        }
                    }

                }
                catch (IOException e ){
                    throw new RuntimeException(e);
                }
            }
        });

        Button back = new Button("<- Main Menu");
        back.setPrefWidth(buttonWidth);
        back.setPrefHeight(buttonHeight);
        back.setOnAction(e -> switchToScene(mainMenu()));
        back.setStyle("-fx-background-radius: 12;" + "-fx-background-color: Green;");
        back.setLayoutX((scene.getWidth()/2)-(back.getPrefWidth()/2));
        back.setLayoutY(300);

        root.getChildren().addAll(nameInput, back);


        return scene;
    }

    private Scene loadGame(){
        VBox root = new VBox();
        Scene scene = new Scene(root, windowWidth, windowHeight);
        root.setStyle("-fx-background-color: red");

        Button back = new Button("<- Main Menu");
        back.setPrefWidth(buttonWidth);
        back.setPrefHeight(buttonHeight);
        back.setOnAction(e -> switchToScene(mainMenu()));
        back.setStyle("-fx-background-radius: 12;" + "-fx-background-color: Green;");

        root.getChildren().addAll(back);
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.setSpacing(10);

        return scene;
    }



    public void createProfileFile(String name) throws IOException {
        FileOutputStream players = new FileOutputStream(playerTxtFile, true);
        players.write((name + " 0 0"+ "\n").getBytes());
        players.close();

    }

    public ArrayList<String> getNames(String aFile, String name) throws FileNotFoundException{
        ArrayList<String> names = new ArrayList<String>();
        File scoreFile = new File(aFile);
        Scanner scan = new Scanner(scoreFile);
        while (scan.hasNextLine()){
            names.add((scan.nextLine().split(" ")[0]));
        }
        return names;
    }

    public int getScore(String aFile, String name) throws FileNotFoundException {
        score = -1;
        File scoreFile = new File(aFile);
        Scanner scan = new Scanner(scoreFile);
        while (scan.hasNextLine()){
            line = scan.nextLine();
            if ((line.split(" ")[0]).equals(name)){
                score = Integer.valueOf(line.split(" ")[1]);
            }
        }

        return score;
    }


    public int getMaxLvl(String aFile, String name) throws FileNotFoundException {
        score = -1;
        File scoreFile = new File(aFile);
        Scanner scan = new Scanner(scoreFile);
        while (scan.hasNextLine()){
            line = scan.nextLine();
            if (line.split(" ")[0].equals(name)){
                score = Integer.valueOf(line.split(" ")[2]);
            }
        }

        return score;
    }

    public int getHighLvl(String name, String playersTxt) throws  FileNotFoundException{
        File players = new File(playersTxt);
        Scanner scan = new Scanner(players);

        while (scan.hasNextLine()){
            if (scan.next() == name){
                return scan.nextInt();
            }
        }

        return 0;
    }

    private void closeProgram(){
        //code to save state
        stage.close();
    }


    public void switchToScene(Scene scene){
        stage.setScene(scene);
    }

    public String getQutoe() throws Exception {
        GetQuote getQuote = new GetQuote();
        return getQuote.send();
    }
    public void run(){
        launch();
    }

    public Board getBoard() throws FileNotFoundException {
        return board;
    }



    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu();
        launch();
        //System.out.println(menu.getBoard().get)
    }
}
