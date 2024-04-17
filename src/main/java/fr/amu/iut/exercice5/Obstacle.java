package fr.amu.iut.exercice5;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Obstacle extends Rectangle {
    public Obstacle(int longueur, int largeur, Color couleurContour, Color couleurRemplissage) {
        super(longueur,largeur,couleurContour);
        this.setFill(couleurRemplissage);
    }
}
