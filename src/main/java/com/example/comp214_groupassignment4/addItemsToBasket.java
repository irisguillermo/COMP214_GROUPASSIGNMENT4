package com.example.comp214_groupassignment4;



public class addItemsToBasket {
    int product_ID;

    int basket_ID;

    double item_price;

    int item_quantity;

    int item_size;

    int item_form;

    public addItemsToBasket (int product_ID, double item_price, int item_quantity, int basket_ID,  int item_size, int item_form)
    {
        this.product_ID = product_ID;
        this.basket_ID = basket_ID;
        this.item_price = item_price;
        this.item_quantity = item_quantity;
        this.item_size = item_size;
        this.item_form = item_form;
    }

    public int getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(int product_ID) {
        this.product_ID = product_ID;
    }

    public int getBasket_ID() {
        return basket_ID;
    }

    public void setBasket_ID(int basket_ID) {
        this.basket_ID = basket_ID;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public int getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(int item_quantity) {
        this.item_quantity = item_quantity;
    }

    public int getItem_size() {
        return item_size;
    }

    public void setItem_size(int item_size) {
        this.item_size = item_size;
    }

    public int getItem_form() {
        return item_form;
    }

    public void setItem_form(int item_form) {
        this.item_form = item_form;
    }
}