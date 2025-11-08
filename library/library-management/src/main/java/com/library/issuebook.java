package com.library;

import java.time.format.DateTimeFormatter;

import org.bson.Document;

import com.mongodb.client.MongoClient;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class issuebook extends Application {

    protected static String Name;
    protected static int roll;

    TextField stuName;
    TextField rollNo;
    TextField bookId;
    VBox bookdata = new VBox(10);

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image imglogo = new Image(getClass().getResourceAsStream("Babasaheb_Bhimrao_Ambedkar_University_logo.png"));
        ImageView imgview = new ImageView(imglogo);
        imgview.setFitHeight(90);
        imgview.setFitWidth(100);

        Image img = new Image(getClass().getResourceAsStream("BBAU_logo.png"));
        ImageView imgv = new ImageView(img);
        imgv.setFitHeight(110);
        imgv.setFitWidth(400);

        HBox hb = new HBox(15);
        hb.getChildren().addAll(imgview, imgv);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(10));

        Text text = new Text();
        text.setText("HELLO! " + (Name == null ? "User" : Name) + "\n" + "WHAT DO YOU WANT TO STUDY TODAY?");
        text.setFill(Color.DARKSLATEBLUE);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 28));
        text.setTextAlignment(TextAlignment.CENTER);

        stuName = new TextField();
        rollNo = new TextField();
        bookId = new TextField();

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0);
        ds.setColor(Color.color(0.4, 0.4, 0.4));
        text.setEffect(ds);

        HBox h = new HBox(text);
        h.setAlignment(Pos.CENTER);
        h.setPadding(new Insets(5));
        // h.setSpacing(30);

        VBox vbx = new VBox(hb, h);
        vbx.setAlignment(Pos.CENTER);
        vbx.setSpacing(20);

        BorderPane bp = new BorderPane();
        bp.setTop(vbx);
        BorderPane.setAlignment(h, Pos.CENTER);

        HBox r1 = createissuebook("student Name", stuName);
        stuName.setText((Name!=null?Name:""));
        HBox r2 = createissuebook("rollno", rollNo);
        rollNo.setText(Integer.toString(roll));
        HBox r3 = createissuebook("bookId", bookId);

        Button btn = new Button("SUBMIT");
        btn.setStyle(
                "-fx-background-color: linear-gradient(to right, #28a745, #218838);" +
                        "-fx-background-radius: 20;" +
                        "-fx-padding: 12 30 12 30;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 6, 0, 0, 2);");

        btn.setOnMouseEntered(e -> btn.setStyle(
                "-fx-background-color: linear-gradient(to right, #218838, #28a745);" +
                        "-fx-background-radius: 20;" +
                        "-fx-padding: 12 30 12 30;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.35), 8, 0, 0, 3);"));

        btn.setOnMouseExited(e -> btn.setStyle(
                "-fx-background-color: linear-gradient(to right, #28a745, #218838);" +
                        "-fx-background-radius: 20;" +
                        "-fx-padding: 12 30 12 30;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.25), 6, 0, 0, 2);"));

        btn.setOnAction(e -> {
            // Library l = new Library();
            issue iss = Library.issuebook(Integer.parseInt(rollNo.getText()), stuName.getText(),
                    Integer.parseInt(bookId.getText()));

            stuName.setText("");
            bookId.setText("");
            rollNo.setText("");

            Label label = new Label("BOOK ISSUED SUCCESSFULLY!");
            label.setFont(Font.font("vergana", 20));
            label.setTextFill(Color.GREEN);
            label.setAlignment(Pos.CENTER);

            bookdata.getChildren().clear();
            VBox v1 = displayfeatures(iss);
            bookdata.getChildren().addAll(label, v1);
            bookdata.setAlignment(Pos.CENTER);
            bookdata.setPadding(new Insets(20));

        });

        bookdata.setPrefHeight(130);
        ScrollPane scroll = new ScrollPane(bookdata);
        scroll.setFitToWidth(true);
        // bp.setCenter(scroll);

        VBox v = new VBox(15);
        v.getChildren().addAll(r1, r2, r3);
        v.setAlignment(Pos.CENTER);

        VBox detshow = new VBox(25);
        detshow.getChildren().addAll(v, scroll);
        detshow.setAlignment(Pos.CENTER);
        detshow.setPadding(new Insets(20));
        detshow.setMaxWidth(500);

        Button nav = new Button("AVAILABLE BOOKS");
        nav.setStyle(
                "-fx-background-color: #2196F3;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;" +
                        "-fx-padding: 10 25 10 25;" +
                        "-fx-background-radius: 8;");

        nav.setOnAction(e -> {
            try {
                new availablebooks().start(new Stage());
            } catch (Exception ex) {
                System.out.println(ex);
            }

            stage.close();
        });

        Button ret = new Button("RETURN SECTION");
        ret.setStyle("-fx-background-color: #6002e3ff;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;" +
                "-fx-padding: 10 20 10 20;" +
                "-fx-background-radius: 8;");
        ret.setOnAction(e -> {
            try {
                new Return().start(new Stage());
            } catch (Exception e1) {
                System.out.println(e1);
            }
            stage.close();
        });

        Button home = new Button("HOME");
        home.setStyle("-fx-background-color: #070665ff;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;" +
                "-fx-padding: 10 20 10 20;" +
                "-fx-background-radius: 8;");
        home.setOnAction(e -> {
            try {
                new App().start(new Stage());
            } catch (Exception e1) {
                System.out.println(e1);
            }
            stage.close();
        });

        HBox newhbox = new HBox(30);
        newhbox.getChildren().addAll(ret, nav, home);
        newhbox.setAlignment(Pos.CENTER);
        newhbox.setPadding(new Insets(30));

        VBox ver = new VBox(10);
        ver.getChildren().addAll(btn, newhbox);
        ver.setAlignment(Pos.TOP_CENTER);
        ver.setPadding(new Insets(10));

        bp.setBottom(ver);
        BorderPane.setAlignment(ver, Pos.CENTER);
        BorderPane.setMargin(ver, new Insets(20));

        bp.setCenter(detshow);

        Scene scene = new Scene(bp, 800, 720);
        stage.setScene(scene);
        stage.setTitle("WELCOME TO GAUTAM BUDDHA CENTRAL LIBRARY!");
        stage.show();
    }

    private HBox createissuebook(String str, TextField t) {
        Label l = new Label(str + " : ");
        l.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 20));

        HBox h = new HBox(10);
        h.getChildren().addAll(l, t);
        h.setAlignment(Pos.CENTER);

        return h;
    }

    private VBox displayfeatures(issue iss) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");
        String f = iss.issDate.format(format);
        Label l1 = new Label("student name : " + iss.studentname + "\n" + "roll No. : " + iss.getid() + "\n"
                + "has issued : " + iss.getbook().getString("bookName") + "\n" + "on : " + f);
        l1.setMinHeight(200);
        VBox data = new VBox(30);

        data.getChildren().addAll(l1);

        data.setAlignment(Pos.CENTER);
        data.setPadding(new Insets(20));
        data.setPrefHeight(140);
        l1.setFont(Font.font("Calibri", FontPosture.ITALIC, 18));
        return data;
    }
}
