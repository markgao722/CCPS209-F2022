module com.example.ccps209_lab_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.ccps209_lab_1 to javafx.fxml;
    exports com.example.ccps209_lab_1;
    exports working;
    opens working to javafx.fxml;
    exports workingB;
    opens workingB to javafx.fxml;
}