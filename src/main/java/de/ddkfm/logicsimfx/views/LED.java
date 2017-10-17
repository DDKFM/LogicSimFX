package de.ddkfm.logicsimfx.views;

import de.ddkfm.logicsimfx.Constants;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class LED extends CustomComponent {
    public LED() {
        this.maxInputConnections = 1;
        this.maxOutputConnections = 0;

        this.setBounds(60, 40);
        this.setRectangle(this.getWidth(), this.getHeight());

        this.addInputConnections();

        this.addOutputConnections(this.getWidth());

    }

    @Override
    public void call() {
        
    }

    @Override
    protected void addOutputConnections(double width) {

    }
}
