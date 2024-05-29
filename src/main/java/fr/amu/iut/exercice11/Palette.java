package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private IntegerProperty nbFois;
    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;
    private StringProperty nomDuBouton;
    private StringProperty couleurPanneau;

    public Palette() {
        this.nbFois = new SimpleIntegerProperty(0);
        this.nomDuBouton = new SimpleStringProperty("");
        this.couleurPanneau = new SimpleStringProperty("#000000");
    }


    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        createBindings();

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            ++nbVert;
            nbFois.setValue(nbVert);
            couleurPanneau.setValue("green");
            nomDuBouton.setValue(vert.getText());
        });

        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            ++nbRouge;
            nbFois.setValue(nbRouge);
            couleurPanneau.setValue("red");
            nomDuBouton.setValue(rouge.getText());
        });

        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            ++nbBleu;
            nbFois.setValue(nbBleu);
            couleurPanneau.setValue("blue");
            nomDuBouton.setValue(bleu.getText());
        });

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createBindings(){
        BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty(false);
        pasEncoreDeClic.bind(Bindings.equal(nbFois,0));
        texteDuHaut.textProperty().bind(Bindings.when(pasEncoreDeClic).then("Cliquez sur un bouton").otherwise(Bindings.concat(nomDuBouton, " choisi ", nbFois.asString(), " fois")));
        panneau.styleProperty().bind(Bindings.concat("-fx-background-color:" ,couleurPanneau));
        texteDuBas.textProperty().bind(Bindings.when(pasEncoreDeClic).then("").otherwise(Bindings.concat("Le ",nomDuBouton, " est une jolie couleur !")));
        texteDuBas.styleProperty().bind(Bindings.concat("-fx-text-fill:",couleurPanneau));
    }
}

