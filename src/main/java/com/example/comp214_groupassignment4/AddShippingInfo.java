package com.example.comp214_groupassignment4;


    import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.sql.*;

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
        void OnSaveChanges(ActionEvent event) throws SQLException {
            Connection connection = DBUtil.dbConnect();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO bb_basketstatus(idbasket, dtstage, shipper, shippingnum) VALUES(?, ?, ?, ?)");
            try {
                //connection = DBUtil.dbConnect();

                        statement.setInt(1, parseInt(productID.getText()));
                        statement.setString(2, shipDate.toString());
                        statement.setString(3, productID1.getText());
                        statement.setString(4, productID11.getText());
                        statement.addBatch();


                statement.executeBatch();
                //statement.executeUpdate();


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
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

