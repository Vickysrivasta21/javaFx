package com.library;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

public class Return extends Application {

    VBox vx = new VBox(10);

    @Override
    public void start(Stage st) throws Exception {
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

        Label l = new Label("RETURN YOUR BOOK");
        l.setTextFill(Color.NAVY);
        l.setFont(Font.font("oswald", FontWeight.EXTRA_BOLD, 30));

        DropShadow ds = new DropShadow();
        ds.setOffsetX(3.0);
        ds.setOffsetY(3.0);
        ds.setColor(Color.color(0.4, 0.4, 0.4));
        ds.setRadius(5);

        l.setEffect(ds);

        VBox vb = new VBox(10);
        vb.getChildren().addAll(hb, l);
        vb.setAlignment(Pos.CENTER);

        Label n = new Label("Enter your name: ");
        TextField nm = new TextField();
        HBox h1 = new HBox(10);
        h1.getChildren().addAll(n, nm);
        h1.setAlignment(Pos.CENTER);
        n.setFont(Font.font("calibri", FontWeight.BOLD, 18));

        Label i = new Label("Roll no : ");
        TextField id = new TextField();
        HBox h2 = new HBox(10);
        h2.getChildren().addAll(i, id);
        h2.setAlignment(Pos.CENTER);
        i.setFont(Font.font("calibri", FontWeight.BOLD, 18));

        Label b = new Label("Book ID: ");
        TextField bid = new TextField();
        HBox h3 = new HBox(10);
        h3.getChildren().addAll(b, bid);
        h3.setAlignment(Pos.CENTER);
        b.setFont(Font.font("calibri", FontWeight.BOLD, 18));

        VBox v1 = new VBox(10);
        v1.getChildren().addAll(h1, h2, h3);
        v1.setAlignment(Pos.TOP_CENTER);
        v1.setPadding(new Insets(30));
        v1.setMinWidth(200);

        Button submit = new Button("SUBMIT");

        Button home = new Button("HOME");

        Button issue = new Button("GO TO ISSUE SECTION");

        submit.setStyle("-fx-background-color: linear-gradient(to right, #0e9213ff, #0c7011ff);" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 8 20 8 20;" +
                "-fx-cursor: hand;" + 
                "-fx-background-radius: 8;");

        home.setStyle("-fx-background-color: #083ff5ff;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;" + 
                "-fx-padding: 8 20 8 20;" +
                "-fx-background-radius: 8;");

        issue.setStyle("-fx-background-color: #a700fbfa;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;" +
                "-fx-padding: 8 20 8 20;" +
                "-fx-background-radius: 8;");
        vx.getChildren().add(v1);

        submit.setOnAction(e -> {
            long f = Library.returnbook(Integer.parseInt(id.getText()), Integer.parseInt(bid.getText()));

            Label label = new Label("BOOK RETURNED SUCCESSFULLY!");
            label.setFont(Font.font("vergana", FontPosture.ITALIC, 25));
            label.setTextFill(Color.GREEN);
            label.setAlignment(Pos.CENTER);
            Label l2 = new Label();
            if (f > 0) {
                l2.setText("YOUR FINE IS : " + "₹"+f);
                l2.setFont(Font.font("vergana", FontPosture.ITALIC, 20));
                l2.setTextFill(Color.GREEN);
                l2.setAlignment(Pos.CENTER);
            }

            vx.getChildren().addAll(label,l2);
            vx.setAlignment(Pos.CENTER);
        });

        home.setOnAction(e -> {
            try {
                new App().start(new Stage());
            } catch (Exception ex) {
                System.out.println(ex);
            }
            st.close();
        });

        issue.setOnAction(e -> {
            try {
                new issuebook().start(new Stage());
            } catch (Exception ex) {
                System.out.println(ex);
            }
            st.close();
        });

        HBox h = new HBox(10);
        h.getChildren().addAll(home, issue);
        h.setAlignment(Pos.CENTER);
        // h.setSpacing(10);

        HBox hx = new HBox(5);
        hx.getChildren().add(submit);
        hx.setAlignment(Pos.CENTER);

        VBox v = new VBox(10);
        v.getChildren().addAll(hx, h);
        v.setAlignment(Pos.CENTER);
        v.setPadding(new Insets(20));

        BorderPane bp = new BorderPane();
        bp.setTop(vb);

        bp.setBottom(v);
        BorderPane.setAlignment(v, Pos.TOP_CENTER);

        bp.setCenter(vx);
        BorderPane.setAlignment(v1, Pos.CENTER);

        Scene sc = new Scene(bp, 800, 700);
        st.setScene(sc);
        st.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
