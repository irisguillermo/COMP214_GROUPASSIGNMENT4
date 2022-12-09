package com.example.comp214_groupassignment4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TotalSpending {

    @FXML
    private TextField shopperID;

    @FXML
    private TableView<TotalSpendingData> tableView;

    @FXML
    TableColumn idshopper;
    @FXML
    TableColumn total;

    @FXML
    private Button saveChanges;

    @FXML
    void OnSaveChanges(ActionEvent event) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBUtil.dbConnect();

            String query = "";
            if (shopperID.getText().trim().isEmpty()) {
                // If shopperID is empty, return total spending for all shoppers
                query = "select idshopper, TOT_PURCH_SF(idshopper) as total from bb_shopper";
                ps = connection.prepareStatement(query);
            } else{
            ps = connection.prepareStatement("select idshopper, TOT_PURCH_SF(idshopper) as total from bb_shopper where idshopper = ?");
            ps.setInt(1, Integer.parseInt(shopperID.getText()));}
            rs = ps.executeQuery();

            tableView.getItems().clear(); // clear existing data from table
            if (!rs.isBeforeFirst()) {
                // Query returned empty result, show error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Shopper ID not found");
                alert.setContentText("The shopper ID you entered does not exist in the database.");
                alert.showAndWait();
            } else {while (rs.next()) {
                TotalSpendingData data = new TotalSpendingData();
                System.out.print(rs.getInt("idshopper"));
                System.out.print(rs.getDouble("total"));
                data.setShopperID(rs.getInt("idshopper"));
                data.setTotalSpending(rs.getDouble("total"));
                tableView.getItems().add(data);
            }

            idshopper.setCellValueFactory(new PropertyValueFactory<>("ShopperID"));
            total.setCellValueFactory(new PropertyValueFactory<>("TotalSpending"));}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
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