package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;
import javafx.scene.control.*;

public class LoginControl extends GridPane {
    @FXML
    private GridPane gridPane;
    @FXML
    private Text text;
    @FXML
    private Label label;
    @FXML
    private PasswordField pwd;
    @FXML
    private Label label2;
    @FXML
    private TextField userId;
    @FXML
    private Button ok;
    @FXML
    private Button cancel;
    @FXML
    private HBox hBox;
    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}