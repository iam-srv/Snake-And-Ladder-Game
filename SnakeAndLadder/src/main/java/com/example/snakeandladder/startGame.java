package com.example.snakeandladder;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class startGame extends Node {
    public AnchorPane root;
    startGame() throws IOException{
        root = FXMLLoader.load(getClass().getResource("StartGame.fxml"));
    }
}
