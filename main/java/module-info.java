module com.example.projecteasybuy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projecteasybuy to javafx.fxml;
    exports com.example.projecteasybuy;
}