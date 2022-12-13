package com.example.comp214_groupassignment4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class BBCoffeeController {


    public Button updatebasket_button;
    public Button emptybasket_button;
    public Button checkout_button;
    public Button continue_button;

    public Hyperlink department_hyperlink;
    public Hyperlink basket_hyperlink;
    public Hyperlink checkout_hyperlink;
    public Hyperlink search_hyperlink;
    public Hyperlink accont_hyperlink;
    public Hyperlink ordertatus_hyperlink;

    @FXML
    public TextField item_code, quantity, item_price, item_total, item_subtotal, item_name, item_options;
    @FXML
    public TableView itemTable;
    public TableColumn s_item_col, s_name_col, s_options_col, s_qty_col, s_price_col, s_total_col,s_subtotal_col;


    public void onUpdateBasketButtonClick(ActionEvent actionEvent) throws SQLException {
        System.out.println(item_code.getText());
        System.out.println(item_name.getText());
        System.out.println(item_options.getText());
        System.out.println(quantity.getText());
        System.out.println(item_price.getText());
        System.out.println(item_total.getText());
        System.out.println(item_subtotal.getText());
        DBUtil.insertData("bb_product", parseInt(item_code.getText()), item_name.getText(), item_options.getText(), parseInt(quantity.getText()),
                parseInt(item_price.getText()), parseInt(item_total.getText()), parseInt(item_subtotal.getText()));
        populateData();
    }

    public void onEmptyBasketButtonClick(ActionEvent actionEvent) throws SQLException {
        BBCoffee item_code = (BBCoffee) itemTable.getSelectionModel().getSelectedItem();
        DBUtil.deleteData("Item-Table", (item_code.getItem_code()));
        populateData();

    }

    public void onCheckOutButtonClick(ActionEvent actionEvent) {

    }

    public void onContinueButtonClick(ActionEvent actionEvent) {

    }

    public void populateData()throws SQLException{
        ResultSet rs = DBUtil.query("SELECT * FROM BBCoffee");

        // creating a list of objects that we want to add to the table
        ObservableList<BBCoffee> itemsTable = FXCollections.observableArrayList();

        // add objects one by one to the list by going through the resultSet we got from running query

        while (rs.next()) {
            BBCoffee itTable = new BBCoffee(rs.getInt("item_code"), rs.getString("item_name"),
                    rs.getString("item_options"), rs.getInt("item_options"),
                    rs.getInt("item_price"), rs.getInt("item_total"),
                    rs.getInt("item_subtotal"));
            itemsTable.add(itTable);
        }


        // Assign each attribute of the BBCoffee entity into the ItemTable table
        s_item_col.setCellValueFactory(new PropertyValueFactory("item_code"));
        s_name_col.setCellValueFactory(new PropertyValueFactory("item_name"));
        s_options_col.setCellValueFactory(new PropertyValueFactory("item_options"));
        s_qty_col.setCellValueFactory(new PropertyValueFactory("quantity"));
        s_price_col.setCellValueFactory(new PropertyValueFactory("item_price"));
        s_total_col.setCellValueFactory(new PropertyValueFactory("item_total"));
        s_subtotal_col.setCellValueFactory(new PropertyValueFactory("item_subtotal"));


        //clear table before adding new records
        itemTable.getItems().clear();

        // add data to the table
        itemTable.getItems().addAll(itemsTable);

        // sort the table by item_code
        s_item_col.setSortType(TableColumn.SortType.ASCENDING);
        itemTable.getSortOrder().add(s_item_col);
        itemTable.sort();
    }
}