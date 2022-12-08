package com.example.comp214_groupassignment4;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
public class BBCoffee {
    String item_name;

    String item_options;

    int item_code;
    int quantity;

    int item_price;

    int item_total;

    int item_subtotal;

    public BBCoffee(int item_code, String item_name, String item_options, int quantity, int  item_price, int item_total, int item_subtotal)
    {
        this.item_code = item_code;
        this.item_name = item_name;
        this.item_options = item_options;
        this.quantity = quantity;
        this.item_price = item_price;
        this.item_total = item_total;
        this.item_subtotal = item_subtotal;
    }

    //getters and setters
    public int getItem_code() {
        return item_code;
    }

    public void setItem_code(int item_code) {
        this.item_code = item_code;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_options() {
        return item_options;
    }

    public void setItem_options(String item_options) {
        this.item_options = item_options;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price = item_price;
    }

    public int getItem_total() {
        return item_total;
    }

    public void setItem_total(int item_total) {
        this.item_total = item_total;
    }

    public int getItem_subtotal() {
        return item_subtotal;
    }

    public void setItem_subtotal(int item_subtotal) {
        this.item_subtotal = item_subtotal;
    }
}
