package fr.amu.iut.exercice2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Random;

public class TicTacToe extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Label case00 = new Label();
        ImageView image = new ImageView("exercice2/Croix.png");
        case00.setGraphic(image);

        Random random = new Random();
        int nombre = random.nextInt(3);

        Scene sc = new Scene(root,600,400);
        primaryStage.setScene(sc);
        primaryStage.setTitle("TicTac Toe");
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();
    }
}

