module br.unesp.farma {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.unesp.farma to javafx.fxml;
    exports br.unesp.farma;
}