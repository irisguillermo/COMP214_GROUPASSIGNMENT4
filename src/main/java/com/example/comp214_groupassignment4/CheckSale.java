package com.example.comp214_groupassignment4;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;
public class CheckSale {

    int product_ID;

    int date;

    public TextField productID;

    public DatePicker datePicker;
    public Button check_btn;

public CheckSale(int product_ID, int date)
{
    this.product_ID = product_ID;
    this.date = date;
}

    public int getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

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
