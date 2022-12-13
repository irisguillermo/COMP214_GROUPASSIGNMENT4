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

    public Label saleStatus;




    public void checkSaleButton(ActionEvent actionEvent) throws SQLException {
        Connection connection = DBUtil.dbConnect();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall("{? = call CK_SALE_SF(?,TO_DATE(?,'YYYY-MM-DD'))}");
            connection.setAutoCommit(false);
            statement.setInt(2, parseInt(productID.getText()));
            statement.setString(3, (String.valueOf(datePicker.getValue())));
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.executeUpdate();
            String result = statement.getString(1);
            System.out.println(result);
            saleStatus.setText(result);

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
