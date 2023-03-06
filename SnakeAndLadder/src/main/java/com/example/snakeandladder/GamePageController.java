package com.example.snakeandladder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class GamePageController {
    public ImageView player1;
    public ImageView player2;


    @FXML
    Text number;
    @FXML
    Text turnname;

     boolean turn = true;

     HashMap<Pair<Double , Double> , Pair<Double , Double>> coordinateChanges;
    @FXML
    public void rolldice(MouseEvent event) throws IOException{
        getSnakeLadderCoordinates();

        Random random = new Random();
            int randomNumber = random.nextInt(6)+1;

            number.setText(""+randomNumber);

           // movement of tokens in linear manner
        if (turn) {
            double moveX = player1.getTranslateX();
            double moveY = player1.getTranslateY();
        Pair<Double,Double> movementCoordinates = movement(moveX , moveY ,randomNumber);
            player1.setTranslateX(movementCoordinates.getKey());
            player1.setTranslateY(movementCoordinates.getValue());
        if(coordinateChanges.containsKey(movementCoordinates)){
            player1.setTranslateX(coordinateChanges.get(movementCoordinates).getKey());
            player1.setTranslateY(coordinateChanges.get(movementCoordinates).getValue());
            }
           checkWin(player1.getTranslateX(), player1.getTranslateY());
        }
        else {
            double moveX = player2.getTranslateX();
            double moveY = player2.getTranslateY();
            Pair<Double,Double> movementCoordinates = movement(moveX , moveY ,randomNumber);
            player2.setTranslateX(movementCoordinates.getKey());
            player2.setTranslateY(movementCoordinates.getValue());
            if(coordinateChanges.containsKey(movementCoordinates)){
                player2.setTranslateX(coordinateChanges.get(movementCoordinates).getKey());
                player2.setTranslateY(coordinateChanges.get(movementCoordinates).getValue());
             }
            checkWin(player2.getTranslateX() , player2.getTranslateY());
            }



            if(randomNumber!=6) {
                if (turn) {
                    turnname.setText("Player 1");
                    turn = false;
                } else {
                    turnname.setText("Player 2");
                    turn = true;
                }
            }

    }
    Pair<Double ,Double> movement (double moveX , double moveY , int randomNumber){
       double x = moveX;
       double y = moveY;

        if(moveY%100 == 0){
            moveX += randomNumber * 50;

            if(moveX > 500){
                moveX = 500*2 - moveX +50;
                moveY -=50;
            }
        }
        else {
            moveX -= randomNumber*50;
            if(moveX <50){
                if( moveY == -450 ){
                    return new Pair<>(x,y);
                }
                moveX = -1*(moveX -50);
                moveY -= 50;
            }
        }
        return new Pair<>(moveX ,moveY);
    }

    void getSnakeLadderCoordinates(){

        coordinateChanges = new HashMap<>();

          coordinateChanges.put(new Pair<>( 150.0 ,0.0 ) , new Pair<>(50.0 , -50.0));
          coordinateChanges.put(new Pair<>( 300.0 ,0.0 ) , new Pair<>(350.0 , -50.0));
          coordinateChanges.put(new Pair<>( 400.0 ,0.0 ) , new Pair<>(200.0 , 0.0));
          coordinateChanges.put(new Pair<>( 500.0 ,-50.0 ) , new Pair<>(400.0 , -100.0));
          coordinateChanges.put(new Pair<>( 300.0 ,-50.0 ) , new Pair<>(350.0 , -150.0));
          coordinateChanges.put(new Pair<>( 200.0 ,-50.0 ) , new Pair<>(350.0 , -350.0));
          coordinateChanges.put(new Pair<>(100.0 ,-100.0 ) , new Pair<>(200.0 , -150.0));
          coordinateChanges.put(new Pair<>(300.0 ,-100.0 ) , new Pair<>(500.0 , 0.0));
          coordinateChanges.put(new Pair<>(150.0 ,-150.0 ) , new Pair<>(100.0 , -250.0));
          coordinateChanges.put(new Pair<>(450.0 ,-200.0 ) , new Pair<>(350.0 , -300.0));
          coordinateChanges.put(new Pair<>(200.0 ,-250.0 ) , new Pair<>(250.0 , -350.0));
          coordinateChanges.put(new Pair<>(0.0 ,-250.0 ) , new Pair<>(150.0 , -100.0));
          coordinateChanges.put(new Pair<>(150.0 ,-50.0 ) , new Pair<>(50.0 , 0.0));
          coordinateChanges.put(new Pair<>(100.0 ,-150.0 ) , new Pair<>(250.0 , 0.0));
          coordinateChanges.put(new Pair<>(500.0 ,-250.0 ) , new Pair<>(300.0 , 0.0));
          coordinateChanges.put(new Pair<>(350.0 ,-250.0 ) , new Pair<>(250.0 , -150.0));
          coordinateChanges.put(new Pair<>(250.0 ,-250.0 ) , new Pair<>(50.0 , 0.0));
          coordinateChanges.put(new Pair<>(50.0 ,-250.0 ) , new Pair<>(150.0 , -100.0));
          coordinateChanges.put(new Pair<>(50.0 ,-300.0 ) , new Pair<>(150.0 , -350.0));
          coordinateChanges.put(new Pair<>(300.0 ,-350.0 ) , new Pair<>(400.0 , -100.0));
          coordinateChanges.put(new Pair<>(50.0 ,-400.0 ) , new Pair<>(150.0 , -450.0));
          coordinateChanges.put(new Pair<>(150.0 ,-400.0 ) , new Pair<>(250.0 , -200.0));
          coordinateChanges.put(new Pair<>(250.0 ,-400.0 ) , new Pair<>(100.0 , -250.0));
          coordinateChanges.put(new Pair<>(500.0 ,-400.0 ) , new Pair<>(400.0 , -200.0));
          coordinateChanges.put(new Pair<>(400.0 ,-400.0 ) , new Pair<>(500.0 , -450.0));
          coordinateChanges.put(new Pair<>(450.0 ,-450.0 ) , new Pair<>(250.0 , -100.0));
          coordinateChanges.put(new Pair<>(200.0 ,-450.0 ) , new Pair<>(350.0 , -400.0));
          coordinateChanges.put(new Pair<>(100.0 ,-450.0 ) , new Pair<>(150.0 , -300.0));

    }
    void checkWin( Double x , Double y) throws IOException {
        if(x == 50.0 && y == -450.0){
          Alert resultAlert = new Alert(Alert.AlertType.INFORMATION);
          resultAlert.setHeaderText("RESULT");
          if(turn) {
              resultAlert.setHeaderText("Player 1 Won" );
              resultAlert.showAndWait();
          }else {
              resultAlert.setHeaderText("player 2 Won");
              resultAlert.showAndWait();
          }

        }
    }
}
