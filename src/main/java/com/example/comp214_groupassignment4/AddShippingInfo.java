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
                String query = "{EXECUTE STATUS_SHIP_SP (?, ?, ?, ?)}";
                statement = connection.prepareCall(query);

                    statement.setInt(1, parseInt(productID.getText()));
                    statement.setString(2, productID1.getText());
                    statement.setString(3, shipDate.toString());
                    statement.setString(4, productID11.getText());
                 //   statement.addBatch();
                statement.executeBatch();
                System.out.println(query);

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


    }

