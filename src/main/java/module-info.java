module com.example.ccps209_lab_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;
    requires java.desktop;
    // requires junit.platform.console.standalone;


    opens com.example.ccps209_lab_1 to javafx.fxml;
    exports TestedLabs;
    opens TestedLabs to javafx.fxml;
}