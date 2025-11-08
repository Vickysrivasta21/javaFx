module com.avnishfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens com.avnishfx to javafx.fxml;

    exports com.avnishfx;
}
