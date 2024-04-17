package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        bas = new HBox(vert,rouge,bleu);
        bas.setAlignment(Pos.CENTER);
        bas.setSpacing(10);
        bas.setPadding(new Insets(10,0,10,0));

        label = new Label();
        panneau = new Pane();
        panneau.setMaxHeight(200);
        root = new BorderPane();
        label.setFont( Font.font("Courier", FontWeight.NORMAL, 20) );

        root.setTop(label);
        root.setCenter(panneau);
        root.setBottom(bas);
        BorderPane.setAlignment(label,Pos.CENTER);

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            panneau.setStyle("-fx-background-color: green");
            nbVert += 1;
            label.setText("Vert choisi " + Integer.toString(nbVert) + " fois");
        });

        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            panneau.setStyle("-fx-background-color: red");
            nbRouge += 1;
            label.setText("Rouge choisi " + Integer.toString(nbRouge) + " fois");
        });

        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            panneau.setStyle("-fx-background-color: blue");
            nbBleu += 1;
            label.setText("Bleu choisi " + Integer.toString(nbBleu) + " fois");
        });

        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Palette");

        primaryStage.setWidth(400);
        primaryStage.setHeight(300);
        primaryStage.show();
    }
}

