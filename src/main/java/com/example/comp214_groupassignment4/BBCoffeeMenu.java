package com.example.comp214_groupassignment4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class BBCoffeeMenu {

    public BBCoffeeMenu() {

    }
    @FXML
    public Button editProductDescription, createNewProduct, calculateTaxForOrder, updateOrderStatus, AddItemsToBasket, checkSaleProducts, reportItemInStock, reportCalculateTotalSpending;


    public void editProductDescriptionBtn(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EditProductDescription.class.getResource("EditProductDescription.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        Stage stage = new Stage();
        stage.setTitle("Task 1: Edit Product Description");
        stage.setScene(scene);
        stage.show();
    }

    public void createNewProductBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(addNewProduct.class.getResource("addNewProduct.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        Stage stage = new Stage();
        stage.setTitle("Task 2: Add New Product");
        stage.setScene(scene);
        stage.show();
    }

    public void calculateTaxForOrderBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatingTax.class.getResource("CalculatingTax.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        Stage stage = new Stage();
        stage.setTitle("Task 2: Add New Product");
        stage.setScene(scene);
        stage.show();
    }

    public void updateOrderStatusBtn(ActionEvent actionEvent) throws  IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(AddShippingInfo.class.getResource("AddShippingInfo.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        Stage stage = new Stage();
        stage.setTitle("Task 2: Add New Product");
        stage.setScene(scene);
        stage.show();
    }

    public void AddItemsToBasketBtn(ActionEvent actionEvent) throws SQLException, IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(addItemsToBasketController.class.getResource("addItemsToBasket.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setTitle("Task 5: Add Item To Basket");
        stage.setScene(scene);
        stage.show();
    }


    public void checkSaleProductsBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CheckSale.class.getResource("CheckSale.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        Stage stage = new Stage();
        stage.setTitle("Task 6: Check Sale");
        stage.setScene(scene);
        stage.show();
    }

    public void reportItemInStockBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CheckStock.class.getResource("checkStock.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        Stage stage = new Stage();
        stage.setTitle("Report 1: Check item in stock");
        stage.setScene(scene);
        stage.show();
    }

    public void reportCalculateTotalSpendingBtn(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TotalSpending.class.getResource("totalSpending.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        Stage stage = new Stage();
        stage.setTitle("Report 1: Check item in stock");
        stage.setScene(scene);
        stage.show();
    }
}
