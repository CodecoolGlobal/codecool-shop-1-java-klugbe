package com.codecool.shop.model;


public class CartItem {

    private final int id;

    private final double price;

    private final String name;

    private int count;

    private double totalPrice;


    public CartItem(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public double getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }

    public int getCount() {
        return this.count;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "CartItem(id=" + this.getId() + ", price=" + this.getPrice() + ", name=" + this.getName() + ", count=" + this.getCount() + ", totalPrice=" + this.getTotalPrice() + ")";
    }
}
