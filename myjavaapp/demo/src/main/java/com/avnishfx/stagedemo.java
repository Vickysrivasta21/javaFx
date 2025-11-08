package com.avnishfx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class stagedemo extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // dOperationException("Unimplemented method 'start'");
        Group root = new Group();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("hello to avnish!");
        stage.show();
    }
}
