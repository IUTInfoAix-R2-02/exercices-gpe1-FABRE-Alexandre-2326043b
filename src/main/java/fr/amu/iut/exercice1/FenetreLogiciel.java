package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        MenuItem _new = new MenuItem("New");
        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem close = new MenuItem("Close");

        MenuItem cut = new MenuItem("Cut");
        MenuItem copy = new MenuItem("Copy");
        MenuItem paste = new MenuItem("Paste");

        Menu file = new Menu("File");
        file.getItems().addAll(_new,open,save,close);
        Menu edit = new Menu("Edit");
        edit.getItems().addAll(cut,copy,paste);

        Menu help = new Menu("Help");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(file,edit,help);

        Button b1 = new Button("Bouton 1");
        Button b2 = new Button("Bouton 2");
        Button b3 = new Button("Bouton 3");
        VBox boutons = new VBox();
        boutons.setAlignment(Pos.CENTER);

        boutons.setSpacing(10);
        boutons.getChildren().addAll(new Label("Boutons :"), b1, b2, b3);
        HBox droite = new HBox();
        droite.getChildren().addAll(boutons, new Separator(Orientation.VERTICAL));

        GridPane form = new GridPane();
        form.setAlignment(Pos.CENTER);
        form.setVgap(10);
        form.setHgap(10);
        Insets margin = new Insets(150);
        GridPane.setMargin(form,margin);

        form.add(new Label("Name:"),0 ,0);
        form.add(new Label("Email:"),0 ,1);
        form.add(new Label("Password:"),0 ,2);

        form.add(new TextField(),1,0);
        form.add(new TextField(),1,1);
        form.add(new TextField(),1,2);

        VBox centre = new VBox();
        HBox submit_cancel = new HBox();
        submit_cancel.setAlignment(Pos.CENTER);
        submit_cancel.setSpacing(10);

        submit_cancel.getChildren().addAll(new Button("Submit"),new Button("Cancel"));
        centre.setSpacing(10);
        centre.setAlignment(Pos.CENTER);
        centre.getChildren().addAll(form,submit_cancel);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setLeft(droite);

        Label pied_de_page = new Label("Ceci est un label de bas de page");
        VBox bas = new VBox();
        bas.setAlignment(Pos.CENTER);
        bas.getChildren().addAll(new Separator(), pied_de_page);
        root.setBottom(bas);
        root.setCenter(centre);

        Scene sc = new Scene(root,600,400);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

