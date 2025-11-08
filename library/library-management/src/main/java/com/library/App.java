package com.library;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    Label label = new Label();

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        Image imglogo = new Image(getClass().getResourceAsStream("Babasaheb_Bhimrao_Ambedkar_University_logo.png"));
        ImageView imgview = new ImageView(imglogo);
        imgview.setFitHeight(90);
        imgview.setFitWidth(100);

        Image img = new Image(getClass().getResourceAsStream("BBAU_logo.png"));
        ImageView imgv = new ImageView(img);
        imgv.setFitHeight(110);
        imgv.setFitWidth(400);
        // imgv.setPreserveRatio(true);

        HBox hb = new HBox(15);
        hb.getChildren().addAll(imgview, imgv);
        hb.setAlignment(Pos.CENTER);
        hb.setPadding(new Insets(20));

        Label heading = new Label("GAUTAM BUDDHA CENTRAL LIBRARY");
        heading.setFont(Font.font("Algerian", FontWeight.EXTRA_BOLD, 30));
        heading.setTextFill(Color.ROYALBLUE);
        heading.setTextAlignment(TextAlignment.CENTER);

        VBox top = new VBox(8);
        top.getChildren().addAll(hb, heading);
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(20, 0, 20, 0));

        Button lib = new Button("Librarian login");
        Button std = new Button("Student login");

        HBox h = new HBox(20);
        h.getChildren().addAll(lib, std);
        h.setAlignment(Pos.TOP_CENTER);

        lib.setStyle(
                "-fx-background-color: #0216f8ff; -fx-text-fill: white; -fx-font-size: 14px;-fx-cursor: hand; -fx-font-weight: bold; -fx-padding: 8 20 8 20; -fx-background-radius: 5;");

        std.setStyle(
                "-fx-background-color: #95d205ff; -fx-text-fill: white; -fx-font-size: 14px; -fx-cursor: hand; -fx-font-weight: bold; -fx-padding: 8 20 8 20; -fx-background-radius: 5;");

        
        // student login section
        Label stdLabel = new Label("ENTER YOUR NAME : ");
        stdLabel.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15));
        TextField stdName = new TextField();

        HBox h1 = new HBox(10);
        h1.getChildren().addAll(stdLabel, stdName);
        h1.setAlignment(Pos.CENTER);

        Label roll = new Label("ENTER YOUR ROLL No : ");
        roll.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15));
        TextField tf = new TextField();

        HBox rollno = new HBox(10);
        rollno.getChildren().addAll(roll, tf);
        rollno.setAlignment(Pos.CENTER);

        Label l2 = new Label("ENTER YOUR PASSWORD : ");
        l2.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15));
        PasswordField psf = new PasswordField();

        HBox h2 = new HBox(10);
        h2.getChildren().addAll(l2, psf);
        h2.setAlignment(Pos.CENTER);

        // librarian login section
        Label libName = new Label("ENTER YOUR NAME : ");
        libName.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15));
        TextField libname = new TextField();

        HBox h5 = new HBox(10);
        h5.getChildren().addAll(libName, libname);
        h5.setAlignment(Pos.CENTER);

        Label libLabel = new Label("ENTER YOUR LIBRARIAN ID : ");
        libLabel.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15));
        TextField libid = new TextField();

        HBox h3 = new HBox(10);
        h3.getChildren().addAll(libLabel, libid);
        h3.setAlignment(Pos.CENTER);

        Label l3 = new Label("ENTER YOUR PASSWORD : ");
        l3.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 15));
        PasswordField psflib = new PasswordField();

        HBox h4 = new HBox(10);
        h4.getChildren().addAll(l3, psflib);
        h4.setAlignment(Pos.CENTER);

        Button stdlogin = new Button("LOGIN");
        stdlogin.setAlignment(Pos.CENTER);
        Button liblogin = new Button("LOGIN");
        stdlogin.setAlignment(Pos.CENTER);

        stdlogin.setStyle(
                "-fx-background-color: #4CAF50;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8 25 8 25;" +
                        "-fx-background-radius: 5;");

        liblogin.setStyle(
                "-fx-background-color: #2196F3;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8 25 8 25;" +
                        "-fx-background-radius: 5;");

        VBox v1 = new VBox(15);
        v1.getChildren().addAll(h1, h2, rollno, stdlogin);
        v1.setAlignment(Pos.CENTER);
        v1.setPadding(new Insets(50));

        VBox v2 = new VBox(15);
        v2.getChildren().addAll(h5, h3, h4, liblogin);
        v2.setAlignment(Pos.CENTER);
        v2.setPadding(new Insets(50));

        StackPane formPane = new StackPane();
        formPane.getChildren().addAll(v1, v2);

        VBox forms = new VBox(20);
        forms.setAlignment(Pos.TOP_CENTER);
        forms.getChildren().addAll(h, formPane, label);

        v1.setVisible(false);
        v2.setVisible(true);

        lib.setOnAction(e -> {
            v1.setVisible(false);
            v2.setVisible(true);
        });
        std.setOnAction(e -> {
            v1.setVisible(true);
            v2.setVisible(false);
        });

        liblogin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                if (libid.getText().equals("lib@123.bbau") && psflib.getText().equals("lib@2712")) {
                    System.out.println("login successsfull");
                    label.setText("LOGIN SUCCESSFULL");
                    label.setAlignment(Pos.CENTER);
                    label.setTextFill(Color.GREENYELLOW);
                    label.setFont(Font.font("vergana", FontPosture.ITALIC, 18));
                    libid.setText("");
                    psflib.setText("");

                    add.libName = libname.getText();
                    try {
                        new add().start(new Stage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    stage.close();
                } else {
                    System.out.println("login not successsfull");
                    label.setText("INCORRECT ID/PASSWORD");
                    label.setFont(Font.font("vergana", FontPosture.ITALIC, 18));
                    label.setAlignment(Pos.CENTER);
                    label.setTextFill(Color.RED);
                    libid.setText("");
                    psflib.setText("");
                }
            }
        });

        stdlogin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                if (psf.getText().equals(stdName.getText() + "@bbau")) {
                    System.out.println("login successsfull");
                    label.setText("LOGIN SUCCESSFULL");
                    issuebook.Name = stdName.getText();
                    issuebook.roll = Integer.parseInt(tf.getText());
                    label.setAlignment(Pos.CENTER);
                    label.setTextFill(Color.GREENYELLOW);
                    label.setFont(Font.font("vergana", FontPosture.ITALIC, 18));
                    stdName.setText("");
                    psf.setText("");
                    try {
                        new issuebook().start(new Stage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    stage.close();
                } else {
                    System.out.println("login not successsfull");
                    label.setText("INCORRECT ID/PASSWORD");
                    label.setFont(Font.font("vergana", FontPosture.ITALIC, 18));
                    label.setAlignment(Pos.CENTER);
                    label.setTextFill(Color.RED);
                    stdName.setText("");
                    psf.setText("");
                }
            }
        });

        BorderPane root = new BorderPane();
        root.setTop(top);
        root.setCenter(forms);
        BorderPane.setAlignment(h, Pos.TOP_CENTER);
        BorderPane.setAlignment(top, Pos.TOP_CENTER);

        scene = new Scene(root, 950, 600);
        stage.setScene(scene);
        stage.setTitle("GAUTAM BUDDHA LIBRARY PORTAL");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}