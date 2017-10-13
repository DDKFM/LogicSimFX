package de.ddkfm.logicsimfx.views;

import de.ddkfm.logicsimfx.Constants;
import de.ddkfm.logicsimfx.models.LogicValue;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class NotGate extends CustomComponent {
    public NotGate() {
        this.maxInputConnections = 1;
        this.maxOutputConnections = 1;

        this.setBounds(40, 40);
        this.setRectangle(this.getWidth(), this.getHeight());

        this.addInputConnections();

        this.addOutputConnections(this.getWidth());

    }

    @Override
    protected void addOutputConnections(double width) {
        for(int i = 0 ; i < this.maxOutputConnections ; i++) {
            Line line = new Line(width - Constants.STRUCTURE_SIZE, Constants.STRUCTURE_SIZE + Constants.STRUCTURE_SIZE * (i + 1), width, Constants.STRUCTURE_SIZE + Constants.STRUCTURE_SIZE * (i + 1));
            line.setStroke(Color.BLACK);
            line.setStrokeWidth(1);
            this.getChildren().addAll(line);

            Circle circle = new Circle(5, Color.WHITE);
            circle.setStroke(Color.BLACK);
            circle.setCenterX(line.getStartX() + circle.getRadius() / 2);
            circle.setCenterY(line.getStartY());
            this.getChildren().add(circle);
        }
    }
}
