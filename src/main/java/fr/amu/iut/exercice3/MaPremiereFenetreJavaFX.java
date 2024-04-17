package fr.amu.iut.exercice3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MaPremiereFenetreJavaFX extends Application {

    private Label helloLabel;

    private TextField nameField;

    private Button button;


    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        helloLabel = new Label("Bonjour à tous !");
        root.getChildren().add(helloLabel);

        nameField = new TextField("Veuillez saisir un nom");
        nameField.setMaxWidth(180.0d);
        nameField.setFont( Font.font("Courier", FontWeight.NORMAL, 12));
        nameField.setOnAction( actionEvent -> handleButonClick(actionEvent) );
        root.getChildren().add( nameField );

        button = new Button();
        root.getChildren().add(button);
        Image image = new Image("exercice3/silver_button.png");
        ImageView iv = new ImageView();
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, new ButtonClickHandler(helloLabel, nameField));

        iv.setImage(image);
        button.setGraphic(iv);
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);

        primaryStage.setTitle("Hello application");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }

    private void handleButonClick(ActionEvent actionEvent) {
        helloLabel.setText( "Bonjour à toi, "+nameField.getText() );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
