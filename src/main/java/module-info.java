module com.example.software_engineering_labs {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.software_engineering_labs.lab1 to javafx.fxml;
    exports com.example.software_engineering_labs.lab1;

    opens com.example.software_engineering_labs.lab2 to javafx.fxml;
    exports com.example.software_engineering_labs.lab2;
}
