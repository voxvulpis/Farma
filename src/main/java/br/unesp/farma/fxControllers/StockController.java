package br.unesp.farma.fxControllers;

import br.unesp.farma.models.Item;
import br.unesp.farma.utils.DemonstrationUtils;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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


    Item currentItem;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>( cellData.getValue().getProduct().getId()));
        nameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProduct().getName()));
//        amountCol.setCellValueFactory((new PropertyValueFactory<>("amount")));
        amountCol.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getAmount()));
        stockTable.setItems(itemList());
    }

    private ObservableList<Item> itemList(){
        return FXCollections.observableArrayList(DemonstrationUtils.loadStockFromJson().getStockList());
    }
}
