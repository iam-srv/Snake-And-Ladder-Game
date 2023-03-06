package com.example.snakeandladder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Group root;
    @Override

    public void start(Stage stage) throws IOException {

        root = new Group();

        stage.setTitle("Snake And Ladder");

        startGame start = new startGame();
        root.getChildren().add(start.root);

        Scene scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}