package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class IHMPendu extends Application {

    GridPane clavier;
    Label labelNbVies;
    Label labelMotCache;
    Dico dico;
    String mot;
    String motCache;
    int nbVies = 7;


    @Override
    public void start(Stage primaryStage) throws Exception {
        dico = new Dico();
        mot = dico.getMot();
        motCache = "";
        for (int i = 0; i < mot.length(); ++i){
            motCache += "*";
        }

        VBox root = new VBox();
        clavier = new GridPane();
        clavier.add(new Button("A"),2,0);
        clavier.add(new Button("Z"),9,2);
        clavier.add(new Button("E"),3,0);
        clavier.add(new Button("R"),3,2);
        clavier.add(new Button("T"),5,2);
        clavier.add(new Button("Y"),7,0);
        clavier.add(new Button("U"),6,0);
        clavier.add(new Button("I"),4,0);
        clavier.add(new Button("O"),5,0);
        clavier.add(new Button("P"),1,2);
        clavier.add(new Button("Q"),2,2);
        clavier.add(new Button("S"),4,2);
        clavier.add(new Button("D"),2,1);
        clavier.add(new Button("F"),3,1);
        clavier.add(new Button("G"),4,1);
        clavier.add(new Button("H"),5,1);
        clavier.add(new Button("J"),6,1);
        clavier.add(new Button("K"),7,1);
        clavier.add(new Button("L"),8,1);
        clavier.add(new Button("M"),9,1);
        clavier.add(new Button("W"),7,2);
        clavier.add(new Button("X"),8,2);
        clavier.add(new Button("C"),1,1);
        clavier.add(new Button("V"),6,2);
        clavier.add(new Button("B"),0,1);
        clavier.add(new Button("N"),0,2);
        labelNbVies = new Label("Nombre de vies : " + nbVies);
        labelMotCache = new Label(motCache);
        clavier.setAlignment(Pos.CENTER);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.getChildren().addAll(labelNbVies,labelMotCache,clavier);
        //lettre.setOnAction( actionEvent -> handleSubmission(actionEvent) );

        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);
        primaryStage.show();
    }

//    private void handleSubmission(ActionEvent event) {
//        ArrayList<Integer> positions = dico.getPositions(lettre.getText().charAt(0),mot);
//        if (positions.size()==0){
//            nbVies -= 1;
//            labelNbVies.setText("Nombre de vies : " + nbVies);
//
//        }else{
//            for (Integer i : positions){
//                motCache = motCache.substring(0,i) + lettre.getText().charAt(0) + motCache.substring(i+1);
//            }
//            labelMotCache.setText(motCache);
//        }
//    }

    public static void main(String[] args) {
        launch(args);
    }
}
