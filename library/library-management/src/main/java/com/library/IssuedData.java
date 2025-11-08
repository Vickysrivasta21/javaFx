package com.library;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.bson.Document;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
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
import javafx.stage.Stage;

public class IssuedData extends Application {

    VBox vb = new VBox(10);

    @Override
    public void start(Stage stg) throws Exception {
        Iterable<Document> issued = DatabaseConnection.getAllIssues();
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
        hb.setPadding(new Insets(15));

        Label l = new Label("ISSUED BOOKS DATA");
        l.setTextFill(Color.NAVY);
        l.setFont(Font.font("oswald", FontWeight.EXTRA_BOLD, 30));

        DropShadow ds = new DropShadow();
        ds.setOffsetX(3.0);
        ds.setOffsetY(3.0);
        ds.setColor(Color.color(0.4, 0.4, 0.4));
        ds.setRadius(5);
        l.setEffect(ds);

        int i = 0;
        for (Document issue : issued) {
            i++;
            String issuedate = issue.getString("issDate");
            String ret = issue.getString("ret");

            LocalDateTime issuedt = LocalDateTime.parse(issuedate);
            LocalDate retdate = LocalDate.parse(ret);
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");
            DateTimeFormatter form = DateTimeFormatter.ofPattern("dd MMM yyyy");
            String f = issuedt.format(format);
            String r = retdate.format(form);
            Label label = new Label(
                    i + "." + "Student Name : " + issue.getString("studentname") + "\n" + "Roll No : "
                            + issue.getInteger("roll") + "\n" + "Issued : " + issue.getString("bookName") + "\n"
                            + "Issued On : " + f + "\n" + "To be Return by date : "
                            + r);
            label.setFont(Font.font("Verdana", FontWeight.BOLD, 16));

            label.setTextFill(Color.DARKBLUE);
            label.setStyle("-fx-background-color: #f3f6ff; -fx-padding: 10 20 10 20; -fx-background-radius:8;");
            label.setMinWidth(790);
            vb.getChildren().add(label);
        }

        Button add = new Button("GO TO ADD BOOK SECTION");
        add.setStyle("-fx-background-color: rgba(6, 23, 119, 0.85); -fx-text-fill: white; -fx-padding: 10 15 10 15; -fx-border-radius: 5px; -fx-cursor:hand;");
        add.setAlignment(Pos.CENTER);
        add.setFont(Font.font("calibri",FontWeight.BOLD ,FontPosture.ITALIC, 15));

        add.setOnAction(e->navigate(stg));

        ScrollPane sp = new ScrollPane(vb);
        sp.setFitToWidth(true);
        sp.setPannable(true);
        sp.setStyle("-fx-background-color: #ffffff;");

        VBox vbx = new VBox(15);
        vbx.getChildren().addAll(l, sp);
        vbx.setAlignment(Pos.TOP_CENTER);
        vbx.setPadding(new Insets(20));


        BorderPane bp = new BorderPane();

        bp.setTop(hb);
        bp.setCenter(vbx);
        bp.setBottom(add);
        BorderPane.setAlignment(add, Pos.CENTER);
        BorderPane.setMargin(add, new Insets(15));
        BorderPane.setAlignment(vbx, Pos.TOP_CENTER);

        Scene sc = new Scene(bp, 800, 700);
        stg.setScene(sc);
        stg.setTitle("Issued books");
        stg.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void navigate(Stage stg){
        try{
            new add().start(new Stage());
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        stg.close();
    }
}
