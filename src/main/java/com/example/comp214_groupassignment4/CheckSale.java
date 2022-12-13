package com.example.comp214_groupassignment4;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

import static java.lang.Integer.parseInt;

public class CheckSale {

    public Button check_btn;

    public DatePicker datePicker;

    public TextField productID;

    @FXML
    private Label saleStatus;




    public void checkSaleButton(ActionEvent actionEvent) throws SQLException {
        Connection connection = DBUtil.dbConnect();
        PreparedStatement statement = connection.prepareStatement("{(CALL CK_SALE_SF (? , ? )}");
        try {

            connection.setAutoCommit(false);
            statement.setInt(1, parseInt(productID.getText()));
            statement.setString(2, (String.valueOf(datePicker.getValue())));
            statement.addBatch();


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

        }

    }

}
