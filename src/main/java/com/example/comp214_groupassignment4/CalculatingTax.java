package com.example.comp214_groupassignment4;


import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import static java.lang.Integer.parseInt;

public class CalculatingTax {
    @FXML
    private TextField productID, taxField;

    @FXML
    private TextField productID1;

    @FXML
    private Button saveChanges;

    @FXML
    void OnSaveChanges(ActionEvent event) {
        Connection connection = null;
        PreparedStatement statement = null;
        CallableStatement cst = null;
        try {
            connection = DBUtil.dbConnect();
            cst = connection.prepareCall("{CALL TAX_COST_SP (?, ?, ?)}");
            cst.setString(1, productID.getText());
            cst.setInt(2, parseInt(productID1.getText()));
            cst.registerOutParameter(3, Types.VARCHAR);

            cst.execute();
            String result = cst.getString(3);
            System.out.println(result);
             taxField.setText(result);

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
