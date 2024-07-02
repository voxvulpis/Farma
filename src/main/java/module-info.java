module br.unesp.farma {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens br.unesp.farma.view to javafx.fxml;
    exports br.unesp.farma.view;
    exports br.unesp.farma.fxControllers;
    opens br.unesp.farma.fxControllers to javafx.fxml;

    opens br.unesp.farma.models to com.google.gson;
    opens br.unesp.farma.repos to com.google.gson;
}