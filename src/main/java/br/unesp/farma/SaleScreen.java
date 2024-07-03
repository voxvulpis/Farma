package br.unesp.farma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SaleScreen extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("sale-screen.fxml"));
        Parent root = fxmlLoader.load();
        primaryStage.setTitle("Sales Screen");
        primaryStage.setScene(new Scene(root, 675, 490));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
