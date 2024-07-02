package br.unesp.farma.fxControllers;

<<<<<<< HEAD
import br.unesp.farma.view.SaleScreen;
=======
>>>>>>> f124075 (Beta screens for main menu and stock manager)
import br.unesp.farma.view.Stock;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class MenuController {

    public void closeWindow(ActionEvent e){
        Platform.exit();
    }

    public void openSale(ActionEvent e){
        System.out.println("LOG: Open Sale");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SaleScreen.class.getResource("sale-screen.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Stock Management");
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void openStock(ActionEvent e){
        System.out.println("LOG: Open Stock");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Stock.class.getResource("stock-screen.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Stock Management");
            stage.setScene(scene);
            stage.show();

//            ((Node)(e.getSource())).getScene().getWindow().hide();
        } catch (Exception ex) {
//            throw new RuntimeException(ex);
            ex.printStackTrace();
        }
    }

    public void openPeople(ActionEvent e){
        System.out.println("LOG: Open People Management");
    }

    public void openProduct(ActionEvent e){
        System.out.println("LOG: Open Products Management");
    }
}
