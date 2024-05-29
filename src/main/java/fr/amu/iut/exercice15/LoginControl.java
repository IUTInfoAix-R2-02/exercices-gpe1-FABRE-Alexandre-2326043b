package fr.amu.iut.exercice15;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

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
    private Button okBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private HBox hBox;

    private void createBindings() {
        BooleanProperty userIdLenght= new SimpleBooleanProperty(userId.getText().length()<6);
        pwd.editableProperty().bind(userIdLenght);
        BooleanProperty cancel = new SimpleBooleanProperty(userId.getText().length()==0 && pwd.getText().length()==0);
        cancelBtn.disableProperty().bind(cancel);
        BooleanProperty ok = new SimpleBooleanProperty(userId.getText().length()<8);
        for (char c : pwd.getText().toCharArray()) {
            ok.setValue(ok.getValue() && Character.isUpperCase(c) && Character.isDigit(c));
        }
        okBtn.disableProperty().bind(ok);
    }

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