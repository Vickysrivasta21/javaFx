package com.library;

import java.io.IOException;

import org.bson.Document;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class availablebooks extends Application {

    @Override
    public void start(Stage stg) throws Exception {

        Image imglogo = new Image(getClass().getResourceAsStream("Babasaheb_Bhimrao_Ambedkar_University_logo.png"));
        ImageView imgview = new ImageView(imglogo);
        imgview.setFitHeight(90);
        imgview.setFitWidth(100);

        Image img = new Image(getClass().getResourceAsStream("BBAU_logo.png"));
        ImageView imgvw = new ImageView(img);
        imgvw.setFitHeight(90);
        imgvw.setFitWidth(500);

        HBox hb = new HBox(10);
        hb.getChildren().addAll(imgview, imgvw);
        hb.setPadding(new Insets(20));
        hb.setAlignment(Pos.TOP_CENTER);
        hb.setSpacing(50);

        Label l = new Label("AVAILABLE BOOKS TO ISSUE");
        l.setAlignment(Pos.CENTER);
        l.setTextFill(Color.NAVY);
        l.setFont(Font.font("Vergana", FontPosture.REGULAR, 25));

        Iterable<Document> books = DatabaseConnection.getAllBooks();
        VBox vb = new VBox(10);
        int i = 0;

        for (Document doc : books) {
            i++;
            // System.out.println(doc);
            // System.out.println("bookname : " + doc.getString("bookName"));
            Label label = new Label(
                    i + "." + "Book - " + doc.getString("bookName") + "\n" + "Book ID : " + doc.getInteger("id")
                            + "\n" + "written by : " + doc.getString("author") + "\n" + "Published By : "
                            + doc.getString("publisher") + "\n" + "Available copies : "
                            + doc.getInteger("availcopies"));
            label.setFont(Font.font("Verdana", FontWeight.BOLD, 16));

            label.setTextFill(Color.DARKBLUE);
            label.setStyle("-fx-background-color: #f3f6ff; -fx-padding: 10 20 10 20; -fx-background-radius:8;");
            label.setMinWidth(790);
            vb.getChildren().add(label);

        }

        ScrollPane sp = new ScrollPane(vb);
        sp.setFitToWidth(true);
        sp.setPannable(true);
        sp.setStyle("-fx-background-color: #ffffff;");

        VBox vbx = new VBox(15);
        vbx.getChildren().addAll(l, sp);
        vbx.setAlignment(Pos.CENTER);
        vbx.setPadding(new Insets(20));

        Button home = new Button("HOME");
        home.setStyle(
                "-fx-background-color: #4CAF50;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-cursor: hand;" + 
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8 25 8 25;" +
                        "-fx-background-radius: 8;");
        Button issue = new Button("GO TO ISSUE SECTION");
        issue.setStyle(
                "-fx-background-color: #2196F3;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8 25 8 25;" +
                        "-fx-cursor: hand;" +
                        "-fx-background-radius: 8;");

        home.setOnAction(e->{
            try {
                new App().start(new Stage());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            stg.close();
        });
        issue.setOnAction(e->{
            try {
                new issuebook().start(new Stage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            stg.close();
        });
        HBox hbx = new HBox(20);
        hbx.getChildren().addAll(home,issue);
        hbx.setAlignment(Pos.CENTER);
        hbx.setPadding(new Insets(20));
        BorderPane bp = new BorderPane();
        bp.setTop(hb);
        bp.setCenter(vbx);
        bp.setBottom(hbx);
        BorderPane.setAlignment(hbx, Pos.CENTER);
        BorderPane.setAlignment(l, Pos.TOP_CENTER);
        BorderPane.setAlignment(hb, Pos.CENTER);
        Scene sc = new Scene(bp, 900, 750);
        stg.setScene(sc);
        stg.setTitle("Available books section");
        stg.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
