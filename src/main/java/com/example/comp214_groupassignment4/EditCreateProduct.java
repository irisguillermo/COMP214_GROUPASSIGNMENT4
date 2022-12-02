package com.example.comp214_groupassignment4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class EditCreateProduct {

    public TableColumn rule, currency, combination, group, customer, impact, fixedPrice, action, period, qty;
    public TableView specificTable;

    public Button addPrice, cancelBtn, saveStaybtn, saveBtn, cancelBtn2,saveStaybtn2,saveBtn2 ;
    public ComboBox shop,group2,currency2, country2;
    public CheckBox checkbox1;

    String v_rule, v_combination, v_currency, v_group, v_customer, v_impact, v_action ;
   int v_fixedPrice, v_period, v_qty;
    public EditCreateProduct(String rule, String combination, String currency, String group, String customer,
                             int fixedPrice, String impact, int period, int qty, String action ){
        this.v_rule = rule;
        this.v_combination = combination;
        this.v_currency = currency;
        this.v_group = group;
        this.v_customer = customer;
        this.v_fixedPrice = fixedPrice;
        this.v_impact = impact;
        this.v_period = period;
        this.v_qty   = qty;
        this.v_action = action;
    }

    //setters and getters.
    public String getRule() {
        return v_rule;
    }
    public void setRule(String rule){
        this.v_rule = rule;
    }

    public String getCombination() {
        return v_combination;
    }
    public void setCombination(String combination){
        this.v_combination = combination;
    }


    public String getCurrency() {
        return v_currency;
    }

    public void setCurrency(String currency) {
        this.v_currency = currency;
    }

    public String getGroup() {
        return v_group;
    }

    public void setGroup(String group) {
        this.v_group = group;
    }

    public String getCustomer() {
        return v_customer;
    }

    public void setCustomer(String customer) {
        this.v_customer = customer;
    }

    public String getImpact() {
        return v_impact;
    }

    public void setImpact(String impact) {
        this.v_impact = impact;
    }

    public String getAction() {
        return v_action;
    }

    public void setAction(String action) {
        this.v_action = action;
    }

    public int getFixedPrice() {
        return v_fixedPrice;
    }

    public void setFixedPrice(int fixedPrice) {
        this.v_fixedPrice = fixedPrice;
    }

    public int getPeriod() {
        return v_period;
    }

    public void setPeriod(int period) {
        this.v_period = period;
    }

    public int getQty() {
        return v_qty;
    }

    public void setQty(int qty) {
        this.v_qty = qty;
    }

    public void OnAddNewPrice(ActionEvent actionEvent) {
    }

    public void OnCancel(ActionEvent actionEvent) {
    }

    public void OnSaveStay(ActionEvent actionEvent) {
    }

    public void OnSave(ActionEvent actionEvent) {
    }

    public void OnCancel2(ActionEvent actionEvent) {
    }

    public void OnSaveStay2(ActionEvent actionEvent) {
    }

    public void OnSave2(ActionEvent actionEvent) {
    }
}
