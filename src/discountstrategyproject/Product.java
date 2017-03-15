/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

/**
 *
 * @author Peter
 */
public class Product {
    private String productID;
    private String name;
    private double price;

    public void setPercentOffDiscount(double percentOffDiscount) {
        this.percentOffDiscount = percentOffDiscount;
    }

    public void setQtyDiscount(double qtyDiscount) {
        this.qtyDiscount = qtyDiscount;
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getPercentOffDiscount() {
        return percentOffDiscount;
    }

    public double getQtyDiscount() {
        return qtyDiscount;
    }
    private double percentOffDiscount;
    private double qtyDiscount;
    
    public Product(String productID, String name, double price){
        this.productID = productID;
        this.name = name;
        this.price = price;
    }
}
