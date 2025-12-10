module com.example.projeto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.projeto_integrado to javafx.fxml;
    exports com.example.projeto_integrado;
}