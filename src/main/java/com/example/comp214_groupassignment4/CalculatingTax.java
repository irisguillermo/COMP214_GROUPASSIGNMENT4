package com.example.comp214_groupassignment4;


import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class CalculatingTax {
    @FXML
    private TextField productID, taxField;

    @FXML
    private TextField productID1;

    @FXML
    private Button saveChanges;

    @FXML
    void OnSaveChanges(ActionEvent event) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.dbConnect();
            connection.setAutoCommit(false);
            String query = "{CALL TAX_COST_SP (?, ?)}";
            statement = connection.prepareCall(query);
            statement.setString(1, productID.getText());
            statement.setInt(2, parseInt(productID1.getText()));
            //statement.executeQuery();
            System.out.println(query);
            taxField.setText(query);

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
    /*
    public void alert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

     */


}
