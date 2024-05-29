package fr.amu.iut.exercice16;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.util.StringConverter;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class ConvertisseurTemperatures extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label celsius = new Label("°C");
        Label fahrenheit = new Label("°F");
        VBox panneauCelsius = new VBox(30);
        VBox panneauFahrenheit = new VBox(30);
        TextField champCelsius = new TextField();
        TextField champFahrenheit = new TextField();

        panneauCelsius.setPrefSize(100,800);
        panneauFahrenheit.setPrefSize(100,800);
        panneauCelsius.setFillWidth(true);
        panneauFahrenheit.setFillWidth(true);

        Slider sliderCelsius = new Slider(0,100,0);
        sliderCelsius.setShowTickMarks(true);
        sliderCelsius.setShowTickLabels(true);
        sliderCelsius.setMajorTickUnit(10);
        sliderCelsius.setOrientation(Orientation.VERTICAL);

        Slider sliderFahrenheit = new Slider(0,212,32);
        sliderFahrenheit.setShowTickMarks(true);
        sliderFahrenheit.setShowTickLabels(true);
        sliderFahrenheit.setMajorTickUnit(10);
        sliderFahrenheit.setOrientation(Orientation.VERTICAL);

/*        DoubleBinding convert = sliderCelsius.valueProperty().multiply(9/5).add(32);
        sliderFahrenheit.valueProperty().bind(convert);
        DoubleBinding convert2 = sliderCelsius.valueProperty().subtract(32).divide(9/5);
        sliderCelsius.valueProperty().bind(convert2);*/

        StringConverter<Number> converter = new NumberStringConverter();
        Bindings.bindBidirectional(champCelsius.textProperty(),sliderCelsius.valueProperty(),converter);
        Bindings.bindBidirectional(champFahrenheit.textProperty(),sliderFahrenheit.valueProperty(),converter);
        panneauCelsius.getChildren().addAll(celsius,sliderCelsius,champCelsius);
        panneauFahrenheit.getChildren().addAll(fahrenheit,sliderFahrenheit,champFahrenheit);

        HBox root = new HBox(30, panneauCelsius, panneauFahrenheit);
        root.setPadding(new Insets(20));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}