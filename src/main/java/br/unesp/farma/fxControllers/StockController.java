package br.unesp.farma.fxControllers;

import br.unesp.farma.models.Item;
import br.unesp.farma.repos.Stock;
import br.unesp.farma.utils.DemonstrationUtils;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class StockController implements Initializable {
    @FXML
    private TableView<Item> stockTable;
    @FXML
    private TableColumn<Item, Integer> idCol;
    @FXML
    private TableColumn<Item, String> nameCol;
    @FXML
    private TableColumn<Item, Integer> amountCol;

    @FXML
    private Label itemNameLabel;

    @FXML
    private Button setAmountBtn;
    @FXML
    private TextField amountField;

    Stock stock;
    Item currentItem;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stock = DemonstrationUtils.loadStockFromJson();
        idCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>( cellData.getValue().getProduct().getId()));
        nameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProduct().getName()));
//        amountCol.setCellValueFactory((new PropertyValueFactory<>("amount")));
        amountCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAmount()));
        stockTable.setItems(itemList());

        stockTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Item>() {
            @Override
            public void changed(ObservableValue<? extends Item> observable, Item oldValue, Item newValue) {
                currentItem = stockTable.getSelectionModel().getSelectedItem();
                itemNameLabel.setText(currentItem.getProduct().getName());
                amountField.setText(currentItem.getAmount().toString());
            }
        });

    }

    private ObservableList<Item> itemList(){
//        return FXCollections.observableArrayList(DemonstrationUtils.loadStockFromJson().getStockList());
        return FXCollections.observableArrayList(stock.getStockList());
    }


    public void setAmountAction(ActionEvent e){
        currentItem.setAmount( Integer.parseInt(amountField.getText()) );


        try {
            stock.adjustStock(currentItem.getProduct().getId(), Integer.parseInt(amountField.getText()) );
        } catch (Exception ex) {
            itemNameLabel.setText(ex.getMessage());
        }

        stockTable.refresh();
    }
}
