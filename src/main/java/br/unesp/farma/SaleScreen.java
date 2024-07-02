package br.unesp.farma;

import br.unesp.farma.models.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SaleScreen extends Application {
    private int id;
    private Employee employee;
    private Client client;
    private Cart cart;
    private Payment payment;
    private String log;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sales Screen");

        Date timeStamp = new Date();

        Label idLabel = new Label("Sale ID: " + id);
        ComboBox<Employee> employeeComboBox = new ComboBox<>();
        ComboBox<Client> clientComboBox = new ComboBox<>();
        Label timeStampLabel = new Label("Timestamp: " + timeStamp.toString());
        TextArea logArea = new TextArea();
        logArea.setPromptText("Log");

        List<Employee> employees = Arrays.asList(new Employee("Claudio", Role.clerk), new Employee("Roberto", Role.manager));
        List<Client> clients = Arrays.asList(new Client("Acme Corp"), new Client("Globex Inc"));
        employeeComboBox.getItems().addAll(employees);
        clientComboBox.getItems().addAll(clients);

        employeeComboBox.setOnAction(e -> employee = employeeComboBox.getSelectionModel().getSelectedItem());
        clientComboBox.setOnAction(e -> client = clientComboBox.getSelectionModel().getSelectedItem());

        Button closeSaleButton = new Button("Close Sale");
        closeSaleButton.setOnAction(e -> closeSale());

        Button cancelSaleButton = new Button("Cancel Sale");
        cancelSaleButton.setOnAction(e -> cancelSale());

        VBox vbox = new VBox(10, idLabel, new Label("Employee:"), employeeComboBox, new Label("Client:"), clientComboBox, timeStampLabel, logArea, closeSaleButton, cancelSaleButton);
        Scene scene = new Scene(vbox, 300, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void closeSale() {
        log = "Sale closed on " + new Date();
        System.out.println(log);
        // Implement more logic as needed
    }

    public void cancelSale() {
        log = "Sale cancelled on " + new Date();
        System.out.println(log);
        // Implement more logic as needed
    }

    public static void main(String[] args) {
        launch(args);
    }
}
