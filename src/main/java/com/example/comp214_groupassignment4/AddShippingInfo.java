package com.example.comp214_groupassignment4;


    import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

    public class AddShippingInfo {
        @FXML
        private TextField productID;

        @FXML
        private TextField productID1;

        @FXML
        private TextField productID11;

        @FXML
        private Button saveChanges;

        @FXML
        private  DatePicker shipDate;

        @FXML
        void OnSaveChanges(ActionEvent event) {
            Connection connection = null;
            PreparedStatement statement = null;
            try {
                connection = DBUtil.dbConnect();
                connection.setAutoCommit(false);
                String query = "{CALL STATUS_SHIP_SP (?, ?, ?, ?)}";
                statement = connection.prepareCall(query);
                statement.setInt(1, parseInt(productID.getText()));
                statement.setString(2, productID1.getText());
                statement.setString(3, shipDate.toString());
                statement.setString(4, productID11.getText());
                // statement.executeUpdate();
                System.out.println(query);
                int count = statement.executeUpdate();
                if (count == 1) {
                    this.alert("Success", "shipping info has been added successfully", Alert.AlertType.INFORMATION);
                } else {
                    this.alert("Failure", "error while adding shipping info", Alert.AlertType.ERROR);
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

