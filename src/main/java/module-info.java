module com.example.ccps209_lab_1 {
    requires javafx.controls;
    requires javafx.fxml;
    //requires junit;
    requires junit.platform.console.standalone;


    opens com.example.ccps209_lab_1 to javafx.fxml;
    exports com.example.ccps209_lab_1;
    exports FirstDraft;
    opens FirstDraft to javafx.fxml;
    exports Working;
    opens Working to javafx.fxml;
    exports Tested;
    opens Tested to javafx.fxml;
}