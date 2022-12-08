module com.example.pleasesendhelpgodplease {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.pleasesendhelpgodplease to javafx.fxml;
    exports com.example.pleasesendhelpgodplease;
}