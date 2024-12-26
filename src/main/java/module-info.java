module com.task4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.task4 to javafx.fxml;
    exports com.task4;
}