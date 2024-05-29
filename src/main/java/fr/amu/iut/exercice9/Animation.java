package fr.amu.iut.exercice9;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        CustomButton customButton = new CustomButton();
        root.setCenter(customButton);
        Scene scene = new Scene(root, 400, 400);

        Duration duration = Duration.millis(1500);
        TranslateTransition transition1 = new TranslateTransition(duration, customButton);
        transition1.setByX(150);
        transition1.setByY(-150);
        transition1.setAutoReverse(false);

        TranslateTransition transition2 = new TranslateTransition(duration, customButton);
        transition2.setByX(-300);
        transition2.setAutoReverse(false);

        TranslateTransition transition3 = new TranslateTransition(duration, customButton);
        transition3.setByY(300);
        transition3.setAutoReverse(false);

        TranslateTransition transition4 = new TranslateTransition(duration, customButton);
        transition4.setByX(300);
        transition4.setAutoReverse(false);

        TranslateTransition transition5 = new TranslateTransition(duration, customButton);
        transition5.setByY(-300);
        transition5.setAutoReverse(false);

        TranslateTransition transition6 = new TranslateTransition(duration, customButton);
        transition6.setByX(-150);
        transition6.setByY(150);
        transition6.setAutoReverse(false);

        TranslateTransition transition7 = new TranslateTransition(duration, customButton);
        transition7.setByX(-300);
        transition7.setAutoReverse(false);

        TranslateTransition transition8 = new TranslateTransition(duration, customButton);
        transition8.setByY(300);
        transition8.setAutoReverse(false);

        TranslateTransition transition9 = new TranslateTransition(duration, customButton);
        transition9.setByX(300);
        transition9.setAutoReverse(false);

        TranslateTransition transition10 = new TranslateTransition(duration, customButton);
        transition10.setByY(-300);
        transition10.setAutoReverse(false);

        SequentialTransition st = new SequentialTransition(transition1, transition2, transition3, transition4, transition5, transition8, transition7, transition10, transition9, transition6);

        customButton.setOnMousePressed(mouseEvent -> st.play());

        primaryStage.setTitle("Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}