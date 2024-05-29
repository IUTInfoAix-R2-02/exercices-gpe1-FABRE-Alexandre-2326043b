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

    char lettre;
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
        Button boutonA = new Button("A");
        Button boutonZ = new Button("Z");
        Button boutonE = new Button("E");
        Button boutonR = new Button("R");
        Button boutonT = new Button("T");
        Button boutonY = new Button("Y");
        Button boutonU = new Button("U");
        Button boutonI = new Button("I");
        Button boutonO = new Button("O");
        Button boutonP = new Button("P");
        Button boutonQ = new Button("Q");
        Button boutonS = new Button("S");
        Button boutonD = new Button("D");
        Button boutonF = new Button("F");
        Button boutonG = new Button("G");
        Button boutonH = new Button("H");
        Button boutonJ = new Button("J");
        Button boutonK = new Button("K");
        Button boutonL = new Button("L");
        Button boutonM = new Button("M");
        Button boutonW = new Button("W");
        Button boutonX = new Button("X");
        Button boutonC = new Button("C");
        Button boutonV = new Button("V");
        Button boutonB = new Button("B");
        Button boutonN = new Button("N");

        clavier.add(boutonA, 2, 0);
        clavier.add(boutonZ, 9, 2);
        clavier.add(boutonE, 3, 0);
        clavier.add(boutonR, 3, 2);
        clavier.add(boutonT, 5, 2);
        clavier.add(boutonY, 7, 0);
        clavier.add(boutonU, 6, 0);
        clavier.add(boutonI, 4, 0);
        clavier.add(boutonO, 5, 0);
        clavier.add(boutonP, 1, 2);
        clavier.add(boutonQ, 2, 2);
        clavier.add(boutonS, 4, 2);
        clavier.add(boutonD, 2, 1);
        clavier.add(boutonF, 3, 1);
        clavier.add(boutonG, 4, 1);
        clavier.add(boutonH, 5, 1);
        clavier.add(boutonJ, 6, 1);
        clavier.add(boutonK, 7, 1);
        clavier.add(boutonL, 8, 1);
        clavier.add(boutonM, 9, 1);
        clavier.add(boutonW, 7, 2);
        clavier.add(boutonX, 8, 2);
        clavier.add(boutonC, 1, 1);
        clavier.add(boutonV, 6, 2);
        clavier.add(boutonB, 0, 1);
        clavier.add(boutonN, 0, 2);
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

    private void handleSubmission(ActionEvent event) {
        ArrayList<Integer> positions = dico.getPositions(lettre,mot);
        if (positions.size()==0){
            nbVies -= 1;
            labelNbVies.setText("Nombre de vies : " + nbVies);

        }else{
            for (Integer i : positions){
                motCache = motCache.substring(0,i) + lettre + motCache.substring(i+1);
            }
            labelMotCache.setText(motCache);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
