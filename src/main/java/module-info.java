module com.example.software_engineering_labs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.software_engineering_labs to javafx.fxml;
    exports com.example.software_engineering_labs;
}