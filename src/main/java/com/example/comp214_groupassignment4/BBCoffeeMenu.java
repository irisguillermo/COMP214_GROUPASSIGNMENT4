package com.example.comp214_groupassignment4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BBCoffeeMenu {

    public BBCoffeeMenu() {

    }
    @FXML
    public Button editProductDescription, createNewProduct, calculateTaxForOrder, updateOrderStatus, AddItemsToBasket, checkSaleProducts, reportItemInStock, reportCalculateTotalSpending;


    public void editProductDescriptionBtn(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EditDescription.class.getResource("EditDescription.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        Stage stage = new Stage();
        stage.setTitle("Task 1: Edit Product Description");
        stage.setScene(scene);
        stage.show();
    }

    public void createNewProductBtn(ActionEvent actionEvent) {
    }

    public void calculateTaxForOrderBtn(ActionEvent actionEvent) {
    }

    public void updateOrderStatusBtn(ActionEvent actionEvent) {
    }

    public void AddItemsToBasketBtn(ActionEvent actionEvent) {
    }

    public void checkSaleProductsBtn(ActionEvent actionEvent) {
    }

    public void reportItemInStockBtn(ActionEvent actionEvent) {
    }

    public void reportCalculateTotalSpendingBtn(ActionEvent actionEvent) {
    }
}
