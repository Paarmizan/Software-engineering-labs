module com.example.software_engineering_labs {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.software_engineering_labs.lab1 to javafx.fxml;
    exports com.example.software_engineering_labs.lab1;
}
