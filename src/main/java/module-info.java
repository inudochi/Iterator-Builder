module com.task5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.task5 to javafx.fxml;
    exports com.task5;
}