package com.example.comp214_groupassignment4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class CheckStock {

    @FXML
    private TextField productID;

    @FXML
    private Label stockStatus;

    @FXML
    private Button saveChanges;


    @FXML
    void OnSaveChanges(ActionEvent event) {
        Connection connection = null;
        CallableStatement cs = null;
        try {
            connection = DBUtil.dbConnect();
            cs = connection.prepareCall("{call check_basket_stock(?,?)}");
            cs.setInt(1, Integer.parseInt(productID.getText()));
            cs.registerOutParameter(2,Types.VARCHAR);
        cs.execute();
        String result = cs.getString(2);
        System.out.println(result);
            // Set the text of the stockStatus text field.
            stockStatus.setText(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cs != null) {
                    cs.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

