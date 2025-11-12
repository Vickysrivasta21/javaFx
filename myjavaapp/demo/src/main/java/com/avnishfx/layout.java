package com.avnishfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class layout extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button top = Createbtn("top");
        Button left = Createbtn("left");
        Button right = Createbtn("right");
        Button bottom = Createbtn("bottom");
        Button center = Createbtn("center");


        BorderPane root = new BorderPane();
        
        root.setLeft(left);
        root.setBottom(bottom);
        root.setRight(right);
        root.setCenter(center);

        PasswordField pg = new PasswordField();  
        root.setTop(pg);
        Scene sc = new Scene(root,600,600);
        stage.setScene(sc);
        stage.show();
    }

    private Button Createbtn(String string) {
        Button b = new Button(string);
        b.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);

        return b;
    }
}
