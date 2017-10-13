package de.ddkfm.logicsimfx;

import de.ddkfm.logicsimfx.models.LogicValue;
import de.ddkfm.logicsimfx.views.CustomComponent;
import de.ddkfm.logicsimfx.views.NotGate;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class LogicSimFXController implements Initializable{

    @FXML
    private MenuBar menubar;

    @FXML
    private Pane simulatorPane;

    @FXML
    private VBox sideBar;

    private double orgTranslateX;
    private double orgTranslateY;

    private double orgSceneX;
    private double orgSceneY;

    public void initialize(URL location, ResourceBundle resources) {
        double width = 1280;
        double height = 720;
        for(int i = 0; i < width ; i += Constants.STRUCTURE_SIZE) {
            for(int j = 0 ; j < height ; j += Constants.STRUCTURE_SIZE) {
                Rectangle rect = new Rectangle(1, 1, Color.GRAY);
                rect.setLayoutX(i);
                rect.setLayoutY(j);
                simulatorPane.getChildren().add(rect);
            }
        }
        CustomComponent rect0 = new NotGate();
        LogicValue lv = new LogicValue(1, "Gate");
        lv.addFunction("output", "input");
        rect0.setLogic(lv);

        rect0.setOnMousePressed(e -> {
            orgSceneX = e.getSceneX();
            orgSceneY = e.getSceneY();
            orgTranslateX = rect0.getTranslateX();
            orgTranslateY = rect0.getTranslateY();
            System.out.println(String.format("X: %.2f, Y: %.2f, SceneX: %.2f, SceneY: %.2f", orgTranslateX, orgTranslateY, orgSceneX, orgSceneY));
            rect0.setCursor(Cursor.HAND);
        });
        rect0.setOnMouseDragged(e -> {
            double newTranslateX = orgTranslateX + e.getSceneX() - orgSceneX;
            double newTranslateY = orgTranslateY + e.getSceneY() - orgSceneY;
            rect0.setTranslateX((int) (newTranslateX / Constants.STRUCTURE_SIZE) * Constants.STRUCTURE_SIZE);
            rect0.setTranslateY((int) (newTranslateY / Constants.STRUCTURE_SIZE) * Constants.STRUCTURE_SIZE);
            rect0.setCursor(Cursor.HAND);

        });
        rect0.setOnMouseReleased(e -> {
            System.out.println("Hier");
        });
        simulatorPane.getChildren().add(rect0);
    }
}
