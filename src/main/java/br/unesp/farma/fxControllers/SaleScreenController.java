package br.unesp.farma.fxControllers;

import br.unesp.farma.models.*;

import br.unesp.farma.repos.Stock;
import br.unesp.farma.utils.DemonstrationUtils;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class SaleScreenController {
    Stock stock = DemonstrationUtils.loadStockFromJson();

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
    private ComboBox<Payment> paymentComboBox;
    private final Cart cart = new Cart(stock.getStockList());
    private final Date timeStamp = new Date();
    private String log;

    @FXML
    public void initialize() {
        Random random = new Random();
        int num = random.nextInt(10000);
        String id = Integer.toString(num);


        // Populate ComboBoxes with sample data
        List<Employee> employees = Arrays.asList(new Employee("Claudio", Role.clerk), new Employee("Roberto", Role.manager));
        List<Client> clients = Arrays.asList(new Client("Acme Corp"), new Client("Globex Inc"));

        for(Item item : cart.getItemList()){
            if(item.getAmount() > 0)
                item.setAmount(0);
        }

        
        idTextField.setText(id);
        timeTextField.setText(timeStamp.toString());

        employeeComboBox.getItems().addAll(employees);
        clientComboBox.getItems().addAll(clients);
        paymentComboBox.getItems().addAll(Arrays.asList(Payment.values()));
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
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        quantityColumn.setOnEditCommit(event -> {
            Item item = event.getRowValue();
            item.setAmount(event.getNewValue());
            cartTableView.refresh();
            updateTotalValue();
        });
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
        Payment payment = paymentComboBox.getSelectionModel().getSelectedItem();
        int id = Integer.parseInt(idTextField.getText());

        Sale sale = new Sale(id, employee, client, timeStamp, cart, payment, "Sale log: ");

        sale.closeSale();
    }

    @FXML
    private void cancelSale() {
        Employee employee = employeeComboBox.getSelectionModel().getSelectedItem();
        Client client = clientComboBox.getSelectionModel().getSelectedItem();
        Payment payment = paymentComboBox.getSelectionModel().getSelectedItem();
        int id = Integer.parseInt(idTextField.getText());

        Sale sale = new Sale(id, employee, client, timeStamp, cart, payment, "Sale log: ");

        sale.cancelSale();
    }
}