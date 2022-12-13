package com.example.comp214_groupassignment4;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class addItemsToBasketController {



    public Button addItemBtn;

    @FXML
    public TextField productID_txtfld, price_txtfld,  quantity_txtfld, basketId_txtfld,   size_txtfld, form_fld;
    private String message;


    public void OnSAveChangesButton(ActionEvent actionEvent) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.dbConnect();
            connection.setAutoCommit(false);

            String query = "{CALL BASKET_ADD_SP (?, ?, ?, ?, ? ,?)}";
            statement = connection.prepareCall(query);
            statement = connection.prepareStatement(query);
            statement.setInt(1, parseInt(productID_txtfld.getText()));
            statement.setDouble(2, Double.parseDouble(price_txtfld.getText()));
            statement.setInt(3, parseInt(quantity_txtfld.getText()));
            statement.setInt(4, parseInt(basketId_txtfld.getText()));
            statement.setInt(5, parseInt(size_txtfld.getText()));
            statement.setInt(6, parseInt(form_fld.getText()));
            statement.executeUpdate();
            int count = statement.executeUpdate();
            if (count ==1)
        {
                this.alert("Success", "Items added successfully",Alert.AlertType.INFORMATION);
            }else
            {
                this.alert("Failure", "Item not added", Alert.AlertType.ERROR);
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            if(null != statement){
                try {
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

        }

    }

    private void alert(String title, String message, Alert.AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}