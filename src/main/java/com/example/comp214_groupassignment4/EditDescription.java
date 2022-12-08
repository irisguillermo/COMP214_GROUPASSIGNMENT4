//package com.example.comp214_groupassignment4;
//
//import javafx.event.ActionEvent;
//import javafx.scene.control.*;
//
//import javax.swing.*;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//
//
//public class EditDescription {
//    public TextField productID, newDescription;
//
//    int v_productID;
//    String v_newDescription;
//
//    public EditDescription(int v_productID, String v_newDescription) {
//        this.v_productID = v_productID;
//        this.v_newDescription = v_newDescription;
//    }
//
//    public int getV_productID() {
//        return v_productID;
//    }
//
//    public void setV_productID(int v_productID) {
//        this.v_productID = v_productID;
//    }
//
//    public String getV_newDescription() {
//        return v_newDescription;
//    }
//
//    public void setV_newDescription(String v_newDescription) {
//        this.v_newDescription = v_newDescription;
//    }
//
//    public void OnSaveChanges(ActionEvent actionEvent) {
//        Connection connection = null;
//        PreparedStatement statement = null;
//        try {
//            connection = DBUtil.dbConnect();
//            connection.setAutoCommit(false);
//            String query = "EXECUTE CHANGE_PROD_DES_SP (?, ?)";
//            statement = connection.prepareStatement(query);
//            statement.setInt(1, getV_productID());
//            statement.setString(2, getV_newDescription());
//            statement.executeUpdate();
//            int count = statement.executeUpdate();
//            if (count == 1) {
//                this.alert("Success", "New description has updated successfully", Alert.AlertType.INFORMATION);
//            } else {
//                this.alert("Failure", "Some error while updating description", Alert.AlertType.ERROR);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (null != statement) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (null != connection) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public void alert(String title, String message, Alert.AlertType alertType) {
//        Alert alert = new Alert(alertType);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.showAndWait();
//    }
//
//
//}

package com.example.comp214_groupassignment4;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class EditDescription {

    public EditDescription() {
    }

    @FXML
    public TextField productID, newDescription;

    @FXML
    public Button saveChanges;

    public void OnSaveChanges(ActionEvent actionEvent) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.dbConnect();
            connection.setAutoCommit(false);
            String query = "EXECUTE CHANGE_PROD_DES_SP (?, ?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, parseInt(productID.getText()));
            statement.setString(2, newDescription.getText());
            statement.executeUpdate();
            int count = statement.executeUpdate();
            if (count == 1) {
                this.alert("Success", "New description has updated successfully", Alert.AlertType.INFORMATION);
            } else {
                this.alert("Failure", "Some error while updating description", Alert.AlertType.ERROR);
            }
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

    public void alert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



    }

