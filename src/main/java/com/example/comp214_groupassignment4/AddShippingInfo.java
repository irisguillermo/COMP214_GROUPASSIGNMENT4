package com.example.comp214_groupassignment4;


import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class AddShippingInfo {
    //shipping info added
    @FXML
    private TextField productID;

    @FXML
    private TextField shippingNum;

    @FXML
    private TextField shipper;

    @FXML
    private Button saveChanges;

    @FXML
    private DatePicker shipDate;

    @FXML
    void OnSaveChanges(ActionEvent event) throws SQLException {
        Connection connection = DBUtil.dbConnect();
        PreparedStatement statement = connection.prepareStatement("{CALL STATUS_SHIP_SP (?, ?, ?, ?)");
        try {
            //connection = DBUtil.dbConnect();

            statement.setInt(1, parseInt(productID.getText()));
            statement.setString(2, String.valueOf(shipDate.getValue()));
            statement.setString(3, shipper.getText());
            statement.setString(4, shippingNum.getText());
            statement.addBatch();


            statement.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}