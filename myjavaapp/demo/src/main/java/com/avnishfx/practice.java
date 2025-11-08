package com.avnishfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class practice extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override 
    public void start(Stage stage) throws Exception {
        Button b = new Button("hey this is my first javafx program!");
        b.setFont(Font.font("arial",FontWeight.BOLD,18));
        b.setTextFill(Color.RED);
        StackPane root = new StackPane(b);
        Scene scene = new Scene(root, 800, 700);
        stage.setScene(scene);

        b.setOnAction(e->System.out.println("hello world"));

        // b.setOnAction(new EventHandler<ActionEvent>() {

        //     @Override
        //     public void handle(ActionEvent arg0) {
        //         System.out.println("hello the button is clicked!");    
        //     }
        // });

        stage.show();
    }
}
