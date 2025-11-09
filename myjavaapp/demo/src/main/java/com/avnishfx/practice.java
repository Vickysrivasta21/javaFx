package com.avnishfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
        BorderPane bp = new BorderPane();
        bp.setCenter(b);
        b.setAlignment(Pos.CENTER);

        b.setOnAction(e->System.out.println("hello world"));

        // b.setOnAction(new EventHandler<ActionEvent>() {

        //     @Override
        //     public void handle(ActionEvent arg0) {
        //         System.out.println("hello the button is clicked!");    
        //     }
        // });

        Button btn = new Button("hello");
        btn.setPrefSize(80, 90);
        Button btn1 = new Button("india");
        btn1.setPrefSize(80, 90);
        Button btn2 = new Button("hello");
        btn2.setPrefSize(80, 90);
        Button btn3 = new Button("we ");
        btn3.setPrefSize(80, 90);
        Button btn4 = new Button("love");
        btn4.setPrefSize(80, 90);
        Button btn5 = new Button("you");
        btn5.setPrefSize(80, 90);

        


       
        // AnchorPane ap = new AnchorPane();
        FlowPane fp = new FlowPane();
        // fp.setPrefWidth(900);
        fp.getChildren().addAll(btn,btn1,btn2,btn3,btn4,btn5);
        bp.setTop(fp);
        

        Scene scene = new Scene(bp, 800, 700);
        stage.setScene(scene);

        stage.show();
    }
}
