module com.example.headsxhands {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.headsxhands to javafx.fxml;
    exports com.example.headsxhands;
}