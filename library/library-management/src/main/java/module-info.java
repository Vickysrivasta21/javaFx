module com.library {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.mongodb.bson;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.driver.core;
    requires javafx.graphics;
    requires javafx.base;

    opens com.library to javafx.fxml;

    exports com.library;
}
