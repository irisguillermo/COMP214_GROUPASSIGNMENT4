package com.example.comp214_groupassignment4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.security.cert.Extension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class CheckSaleController {

    public Button check_btn;

    public  DatePicker datePicker;

    public TextField productID;


    public void checkSaleButton(ActionEvent actionEvent) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        try
        {
            connection = DBUtil.dbConnect();
            connection.setAutoCommit(false);

            String query = "(CK_SALE_SF (? , ? ))";
            statement = connection.prepareCall(query);

            query = "(CK_SALE_SF (? , ? ,?))";
            statement = connection.prepareCall(query);


            statement.setInt(1, parseInt(productID.getId()));
            statement.setInt(2, parseInt(String.valueOf(datePicker.getValue())));
            statement.executeUpdate();
            System.out.println(query);
            int count = statement.executeUpdate();
            if (count == 1)
            {
                this.alert("OnSale", "Product is ON SALE!!", Alert.AlertType.INFORMATION);
            }else
            {
                this.alert("NotOnSale", "Product has Great Deal!", Alert.AlertType.ERROR);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally
        {
            if (null != statement)
            {
                try
                {
                    statement.close();
                }catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            if (null != connection)
            {
                try
                {
                    connection.close();
                }catch (SQLException e)
                {
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
