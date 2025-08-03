module com.ijse.layeredarchitecture {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jakarta.mail;

    opens com.ijse.layeredarchitecture to javafx.fxml;
    opens com.ijse.layeredarchitecture.controller to javafx.fxml;
    opens com.ijse.layeredarchitecture.view.tdm to javafx.fxml;

    exports com.ijse.layeredarchitecture;
    exports com.ijse.layeredarchitecture.controller;
}