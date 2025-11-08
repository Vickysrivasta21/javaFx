package com.library;

import com.mongodb.client.MongoCollection;

// import javax.swing.text.StyledEditorKit.ItalicAction;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
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
import org.bson.Document;

public class add extends Application {
    VBox vbx = new VBox(10);
    protected static String libName;

    public static void main(String[] args) {
        launch();
    }

    TextField name;
    TextField author;
    TextField copies;
    TextField publisher;
    TextField id;

    @Override
    public void start(Stage stage) {
        name = new TextField();
        author = new TextField();
        publisher = new TextField();
        copies = new TextField();
        id = new TextField();

        Image img = new Image(getClass().getResourceAsStream("Babasaheb_Bhimrao_Ambedkar_University_logo.png"));
        ImageView imgvw = new ImageView(img);
        imgvw.setFitWidth(100);
        imgvw.setFitHeight(90);

        Image i = new Image(getClass().getResourceAsStream("BBAU_logo.png"));
        ImageView imgv = new ImageView(i);
        imgv.setFitHeight(110);
        imgv.setFitWidth(400);

        HBox logo = new HBox(15);
        logo.getChildren().addAll(imgvw,imgv);
        logo.setAlignment(Pos.CENTER);
        logo.setPadding(new Insets(10));

        Text text = new Text();
        text.setText("HELLO! " + (libName==null?"User" : libName) + "\n" + "Add Book to The Library");
        text.setFont(Font.font("System", FontWeight.BOLD, 35));
        text.setFill(Color.MAGENTA);
        text.setTextAlignment(TextAlignment.CENTER);

        VBox vb = new VBox(logo, text);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(20);

        HBox h = new HBox(vb);
        h.setAlignment(Pos.CENTER);
        h.setPadding(new Insets(5));

        BorderPane root = new BorderPane();
        root.setTop(h);
        BorderPane.setAlignment(h, Pos.CENTER);

        HBox r1 = createRow("Book Name", name);
        HBox r2 = createRow("Author", author);
        HBox r3 = createRow("publisher", publisher);
        HBox r4 = createRow("available copies", copies);
        HBox r5 = createRow("book id", id);

        VBox vbox = new VBox(15);
        vbox.getChildren().addAll(r1, r2, r3, r4, r5);
        vbox.setAlignment(Pos.CENTER);

        VBox v = new VBox(10);
        v.getChildren().addAll(vbox, vbx);
        v.setAlignment(Pos.CENTER);

        root.setCenter(v);

        Button b = new Button("SUBMIT DETAILS");
        b.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        b.setTextFill(Color.WHITE);
        b.setStyle(
                "-fx-background-color: linear-gradient(#6a11cb, #2575fc);" +
                        "-fx-background-radius: 25;" +
                        "-fx-padding: 10 25 10 25;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 8, 0, 0, 3);");

        Button issuedata = new Button("CHECK ISSUED BOOKS");
        issuedata.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        issuedata.setTextFill(Color.WHITE);
        issuedata.setStyle("-fx-background-color: linear-gradient(#11998e, #38ef7d);-fx-background-radius: 25;-fx-padding: 10 25 10 25;-fx-cursor: hand;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 8, 0, 0, 3);");
        issuedata.setOnAction(e->{
            try {
                new IssuedData().start(new Stage());
            } catch (Exception e1) {
                System.out.println(e1);
            }
            stage.close();
        }); 

        Button hm = new Button("HOME");
        hm.setFont(Font.font("Verdana", FontWeight.BOLD, 16));
        hm.setTextFill(Color.WHITE);
        hm.setStyle("-fx-background-color: linear-gradient(#11998e, #58028dff);-fx-background-radius: 25;-fx-padding: 10 25 10 25;-fx-cursor: hand;-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 8, 0, 0, 3);");
        hm.setOnAction(e->{
            try {
                new App().start(new Stage());
            } catch (Exception e1) {
                System.out.println(e1);
            }
            stage.close();
        }); 
        HBox horBox = new HBox(15);
        horBox.getChildren().addAll(issuedata,hm);
        horBox.setPadding(new Insets(10));
        horBox.setAlignment(Pos.CENTER);

        VBox btnbox = new VBox(15);
        btnbox.getChildren().addAll(b,horBox);
        btnbox.setPadding(new Insets(20));
        btnbox.setAlignment(Pos.TOP_CENTER);


        root.setBottom(btnbox);
        BorderPane.setAlignment(b, Pos.CENTER);
        BorderPane.setMargin(b, new Insets(30));

        b.setOnAction(this::submitdetails);

        Scene scene = new Scene(root, 800, 700);
        stage.setScene(scene);
        stage.setTitle("WELCOME TO GAUTAM BUDDHA CENTRAL LIBRARY!!");
        stage.show();
    }

    private HBox createRow(String str, TextField tf) {
        Label label = new Label(str + ":");
        label.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 20));
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(label, tf);
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }

    private void submitdetails(ActionEvent e) {
        addbook b = new addbook(name.getText(), Integer.parseInt(id.getText()), author.getText(), publisher.getText(),
                Integer.parseInt(copies.getText()));
        DatabaseConnection.addBook(b);

        Library lib = new Library();
        lib.add(b);
        author.setText("");
        publisher.setText("");
        id.setText("");
        copies.setText("");
        name.setText("");

        Label label = new Label("BOOK ADDED SUCCESSFULLY!");
        label.setFont(Font.font("vergana", 20));
        label.setTextFill(Color.PURPLE);
        label.setAlignment(Pos.CENTER);

        vbx.getChildren().clear();
        // VBox v1 = display(b);
        vbx.getChildren().addAll(label);
        vbx.setAlignment(Pos.CENTER);
        vbx.setPadding(new Insets(10));

        System.out.println("book added to the library successfully!");

        System.out.println(b.book());
    }

    // private VBox display(addbook book) {
    //     Label l1 = new Label("Book name : " + book.getbookName() + "\n" + "book No. : " + book.getid() + "\n"
    //             + "author : " + book.author + "\n" + "available copies : " + book.getavailcopies());
    //     VBox data = new VBox(30);

    //     ScrollPane sp = new ScrollPane(l1);
    //     sp.setFitToWidth(true);

    //     data.getChildren().addAll(sp);

    //     data.setAlignment(Pos.CENTER);
    //     data.setPadding(new Insets(10));
    //     data.setPrefHeight(140);
    //     l1.setFont(Font.font("Calibri", FontPosture.ITALIC, 18));
    //     return data;
    // }
}
