package br.unesp.farma;

import br.unesp.farma.models.*;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class SaleScreenController {

    @FXML
    private TextField idTextField;

    @FXML
    private ComboBox<Client> clientComboBox;

    @FXML
    private ComboBox<Employee> employeeComboBox;

    @FXML
    private ComboBox<Cart> cartComboBox;
    private String log;

    @FXML
    public void initialize() {
        Date timeStamp = new Date();
        Random random = new Random();
        int num = random.nextInt(10000);
        String id = Integer.toString(num);

        // Populate ComboBoxes with sample data
        List<Employee> employees = Arrays.asList(new Employee("Claudio", Role.clerk), new Employee("Roberto", Role.manager));
        List<Client> clients = Arrays.asList(new Client("Acme Corp"), new Client("Globex Inc"));
        
        idTextField.setText(id);

        employeeComboBox.getItems().addAll(employees);
        clientComboBox.getItems().addAll(clients);
    }

    @FXML
    private void closeSale() {
        Employee employee = employeeComboBox.getSelectionModel().getSelectedItem();
        Client client = clientComboBox.getSelectionModel().getSelectedItem();

        if (employee != null && client != null) {
            log = "Sale closed on " + new Date() + " by " + employee.getName() + " for client " + client.getName();
        } else {
            log = "Sale closed on " + new Date();
        }

        System.out.println(log);
        // Implement more logic as needed
    }

    @FXML
    private void cancelSale() {
        Employee employee = employeeComboBox.getSelectionModel().getSelectedItem();
        Client client = clientComboBox.getSelectionModel().getSelectedItem();

        if (employee != null && client != null) {
            log = "Sale cancelled on " + new Date() + " by " + employee.getName() + " for client " + client.getName();
        } else {
            log = "Sale cancelled on " + new Date();
        }

        System.out.println(log);
        // Implement more logic as needed
    }
}