module br.unesp.farma {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires jakarta.validation;
    requires org.testng;
    requires org.hibernate.validator;
    requires junit;
    requires javax.el.api;

    exports br.unesp.farma.view;
    exports br.unesp.farma.fxControllers;
    exports br.unesp.farma.validation;

    opens br.unesp.farma.validation to org.hibernate.validator;
    opens br.unesp.farma.view to javafx.fxml;
    opens br.unesp.farma.fxControllers to javafx.fxml;
    opens br.unesp.farma.models to com.google.gson, org.hibernate.validator;
    opens br.unesp.farma.repos to com.google.gson;
}