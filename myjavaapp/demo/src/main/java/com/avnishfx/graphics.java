package com.avnishfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class graphics extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Group g = new Group();

        Text t = new Text(20, 20, "hello this is my first text");
        t.setFont(Font.font("Times New Roman", 20));
        t.setFill(Color.PINK);
        t.setStroke(Color.BLACK);
        t.setStrokeWidth(0.5);
        // t.setStrikethrough(true);

        TextField text = new TextField();
        Label l1 = new Label("enter the name");
        l1.setLabelFor(text);
        text.setLayoutX(80);
        text.setLayoutY(60);

        Button bt = new Button("submit");
        bt.setLayoutX(10);
        bt.setLayoutY(60);
        bt.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                System.out.println("you entered " + text.getText());
            }

        });

        Line l = new Line();
        l.setStartX(40);
        l.setEndX(185);
        l.setStartY(30);
        l.setEndY(30);

        DropShadow s = new DropShadow();
        t.setEffect(s);

        g.getChildren().addAll(t, l,text,bt,l1);
        Scene sc = new Scene(g, 400, 400);
        stage.setScene(sc);
        stage.setTitle("graphics tutorial");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}