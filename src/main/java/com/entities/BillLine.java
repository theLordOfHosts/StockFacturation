/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

/**
 *
 * @author TheLord
 */
public class BillLine {
    private Product product;
    private double qty;
    private double price;

    public BillLine() {
        this.price = this.getQty()*product.getPrice();
    }

    public BillLine(Product product, double qty) {
        this.price = this.getQty()*product.getPrice();
        this.product = product;
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
