package de.ddkfm.logicsimfx.views;

import de.ddkfm.logicsimfx.Constants;
import de.ddkfm.logicsimfx.models.LogicValue;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class CustomComponent extends LogicNode{
    protected int maxInputConnections;
    protected int maxOutputConnections;

    private Rectangle nobble = new Rectangle(4, 4, Color.BLACK);

    protected void setBounds(double height , double width) {
        int maxConnections = Math.max(maxInputConnections, maxOutputConnections);
        height = height < 0 ? Constants.STRUCTURE_SIZE * maxConnections + 3 * Constants.STRUCTURE_SIZE : height;
        this.setWidth(width);
        this.setHeight(height);
    }
    protected void setRectangle(double width, double height) {
        Rectangle rect = new Rectangle(width - 2 * Constants.STRUCTURE_SIZE, height - 2 * Constants.STRUCTURE_SIZE, Color.WHITE);
        rect.setLayoutX(Constants.STRUCTURE_SIZE);
        rect.setLayoutY(Constants.STRUCTURE_SIZE);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(1);
        this.getChildren().add(rect);
    }
    protected void addInputConnections() {
        for(int i = 0 ; i < this.maxInputConnections ; i++) {
            Line line = new Line(0, Constants.STRUCTURE_SIZE + Constants.STRUCTURE_SIZE * (i + 1), Constants.STRUCTURE_SIZE, Constants.STRUCTURE_SIZE + Constants.STRUCTURE_SIZE * (i + 1));
            line.setStroke(Color.BLACK);
            line.setStrokeWidth(1);
            line.setOnMouseEntered(event -> {
                nobble.setLayoutX(line.getStartX() - 2);
                nobble.setLayoutY(line.getStartY() - 2);
                nobble.setVisible(true);
            });
            line.setOnMouseExited(event -> {
                nobble.setVisible(false);
            });
            this.getChildren().addAll(line);
        }
    }
    protected void addOutputConnections(double width) {
        for(int i = 0 ; i < this.maxOutputConnections ; i++) {
            Line line = new Line(width - Constants.STRUCTURE_SIZE, Constants.STRUCTURE_SIZE + Constants.STRUCTURE_SIZE * (i + 1), width, Constants.STRUCTURE_SIZE + Constants.STRUCTURE_SIZE * (i + 1));
            line.setStroke(Color.BLACK);
            line.setStrokeWidth(1);
            this.getChildren().addAll(line);
        }
    }
    protected void addNobble() {
        nobble.setVisible(false);
        this.getChildren().add(nobble);
    }
    public CustomComponent() {}
    public CustomComponent(int inputConnections, int outputConnections) {
        this.maxInputConnections = inputConnections;
        this.maxOutputConnections = outputConnections;

        this.setBounds(-1, 70);
        this.setRectangle(this.getWidth(), this.getHeight());

        this.addInputConnections();
        this.addOutputConnections(this.getWidth());

    }
    @Override
    public void setLogic(LogicValue logic) {
        super.setLogic(logic);
    }
}
