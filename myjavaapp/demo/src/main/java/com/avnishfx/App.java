package com.avnishfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        // stage.setScene(scene);
        // stage.show();
        Line l = new Line();
        l.setStartX(100.0);
        l.setStartY(150.0);
        l.setEndX(200.0);
        l.setEndY(150.0);
        // l.setFill(Color.hsb(50,0,12));
        Line line2 = new Line(200, 150, 200, 250);
        Line line3 = new Line(200, 250, 100, 250);
        Line line4 = new Line(100, 250, 100, 150);

        Rectangle r = new Rectangle();
        r.setX(200.0f);
        r.setY(300.0f);
        r.setWidth(200.0);
        r.setHeight(200.0);

        Line l1 = new Line(200,300,300,200);
        Line l2 = new Line(300,200,400,300);

        Group root = new Group();

        root.getChildren().addAll(l, line2, line3, line4, r ,l1,l2);
        Scene scene = new Scene(root, 500, 300, Color.PINK);
        stage.setTitle("Sample application");

        stage.setScene(scene);

        stage.show();
        Button b = new Button();
        b.setText("hello world");
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}