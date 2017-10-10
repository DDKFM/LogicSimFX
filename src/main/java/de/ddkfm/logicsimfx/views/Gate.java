package de.ddkfm.logicsimfx.views;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 * Created by maxsc on 10.10.2017.
 */
public class Gate extends Pane {

    public Gate(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        Rectangle rect = new Rectangle(width - 10, height - 10, Color.WHITE);
        rect.setLayoutX(5);
        rect.setLayoutY(5);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(1);
        Line line = new Line(0, 10, 5, 10);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(1);
        this.getChildren().addAll(rect, line);
    }
}
