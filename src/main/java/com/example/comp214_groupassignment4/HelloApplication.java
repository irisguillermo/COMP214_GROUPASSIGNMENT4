package com.example.comp214_groupassignment4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(TotalSpending.class.getResource("totalSpending.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(EditProductDescription.class.getResource("EditProductDescription.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(BBCoffeeMenu.class.getResource("BBCoffeeMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setTitle("Welcome to Brewbean's Coffee!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}