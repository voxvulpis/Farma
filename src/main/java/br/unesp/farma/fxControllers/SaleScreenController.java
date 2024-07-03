package br.unesp.farma.fxControllers;

import br.unesp.farma.models.*;

import br.unesp.farma.repos.Stock;
import br.unesp.farma.utils.DemonstrationUtils;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.util.*;

public class SaleScreenController {

    @FXML
    private TextField idTextField;

    @FXML
    private ComboBox<Client> clientComboBox;

    @FXML
    private ComboBox<Employee> employeeComboBox;

    @FXML
    private TableView<Item> cartTableView;
    @FXML
    private TableColumn<Item, Integer> idColumn;

    @FXML
    private TableColumn<Item, String> nameColumn;

    @FXML
    private TableColumn<Item, Float> priceColumn;

    @FXML
    private TableColumn<Item, Integer> quantityColumn;

    @FXML
    private TableColumn<Item, Float> totalColumn;

    @FXML
    private TextField timeTextField;

    @FXML
    private TextField valueTextField;
    @FXML
    private ComboBox<String> paymentComboBox;

    @FXML
    private Button closeSaleBtn;

    private String log;
    Stock stock;
    Cart cart;

    @FXML
    public void initialize() {
        Date timeStamp = new Date();
        Random random = new Random();
        int num = random.nextInt(10000);
        String id = Integer.toString(num);
        cart = new Cart();

        // Populate ComboBoxes with sample data
        List<Employee> employees = Arrays.asList(new Employee("Claudio", Role.clerk), new Employee("Roberto", Role.manager));
        List<Client> clients = Arrays.asList(new Client("Acme Corp"), new Client("Globex Inc"));

        Product product1 = new Product(1, "Product A", "Description A", 15.0f,1.0f, 10, false);
        Product product2 = new Product(2, "Product B", "Description B", 10.0f, 2.0f, 20, true);
        Item item1 = new Item(product1, 2);
        Item item2 = new Item(product2, 3);

        cart.modItem(item1.getProduct(), item1.getAmount());
        cart.modItem(item2.getProduct(), item2.getAmount());
        
        idTextField.setText(id);
        timeTextField.setText(timeStamp.toString());

        employeeComboBox.getItems().addAll(employees);
        clientComboBox.getItems().addAll(clients);
        paymentComboBox.getItems().addAll(Arrays.asList("PIX", "Crédito", "Débito"));

        idColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getProduct().getId()));
        nameColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getProduct().getName()));
        priceColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getProduct().getPrice()));
        quantityColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getAmount()));
        totalColumn.setCellValueFactory(cellData -> {
            Item item = cellData.getValue();
            float total = item.getProduct().getPrice() * item.getAmount();
            return new ReadOnlyObjectWrapper<>(total);
        });


        cartTableView.getItems().addAll(cart.getItemList());
        updateTotalValue();
    }

    private void updateTotalValue() {
        float totalValue = 0;
        for (Item item : cartTableView.getItems()) {
            totalValue += item.getProduct().getPrice() * item.getAmount();
        }
        valueTextField.setText(String.format("%.2f", totalValue));
    }

    @FXML
    private void closeSale() {
        Employee employee = employeeComboBox.getSelectionModel().getSelectedItem();
        Client client = clientComboBox.getSelectionModel().getSelectedItem();
        String payment = paymentComboBox.getSelectionModel().getSelectedItem();
        String id = idTextField.getText();
        Iterator<Item> iterator = cart.getItemList().iterator();
        Item item;

        if (employee != null && client != null && payment != null) {
            log = "Sale " + id + " payed with " + payment + " closed on " + new Date() + " by " + employee.getName() + " for client " + client.getName();
        } else {
            log = "Sale " + id +  " closed on " + new Date();
        }

        System.out.println(log);

        stock = DemonstrationUtils.loadStockFromJson();

        while (iterator.hasNext()){
            item = iterator.next();
            try {
                stock.adjustStock(item);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        DemonstrationUtils.saveToJson(stock);

        Stage stage = (Stage) closeSaleBtn.getScene().getWindow();
        stage.close();

        // Implement more logic as needed
    }

    @FXML
    private void cancelSale() {
        Employee employee = employeeComboBox.getSelectionModel().getSelectedItem();
        Client client = clientComboBox.getSelectionModel().getSelectedItem();
        String id = idTextField.getText();

        if (employee != null && client != null) {
            log = "Sale " + id + " cancelled on " + new Date() + " by " + employee.getName() + " for client " + client.getName();
        } else {
            log = "Sale " + id +  " closed on " + new Date();
        }

        System.out.println(log);
        // Implement more logic as needed
    }
}