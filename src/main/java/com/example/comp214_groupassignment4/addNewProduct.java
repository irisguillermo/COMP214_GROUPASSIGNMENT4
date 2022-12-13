package com.example.comp214_groupassignment4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class addNewProduct {

    int activeChecked;

    public addNewProduct(){

    }

    @FXML
    private CheckBox active;


    @FXML
    public void checked(ActionEvent event) {
        if (active.isSelected()) {
            activeChecked = 1;
        }
        else {
            activeChecked = 0;
        }
    }

    @FXML
    private TextArea productDescription;

    @FXML
    private TextField productName, productImage, productPrice;

    @FXML
    private Button addProduct;

    @FXML
    public void addProductbtn (ActionEvent event) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.dbConnect();
            connection.setAutoCommit(false);
            String query = "{CALL PROD_ADD_SP (?, ?, ?, ?, ?)}";
            statement = connection.prepareStatement(query);
            statement.setString(1, productName.getText());
            statement.setString(2, productDescription.getText());
            statement.setString(3, productImage.getText());
            statement.setDouble(4, Double.parseDouble(productPrice.getText()));
            statement.setInt(5, activeChecked);
            int count = statement.executeUpdate();
            if (count == 1) {
                this.alert("Success", "New product has been created successfully", Alert.AlertType.INFORMATION);
            } else {
                this.alert("Failure", "Some error while creating new product", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != statement) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void alert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}

