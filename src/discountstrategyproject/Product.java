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
    private DiscountStrategy discountStrategy;

    public final String getProductID() {
        return productID;
    }

    public final DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public final void setDiscountStrategy(DiscountStrategy discountStrategy) {
        if(discountStrategy == null)
            throw new IllegalArgumentException("error: attempted to set discount strategy to null");
        this.discountStrategy = discountStrategy;
    }

    public final String getName() {
        return name;
    }

    public final double getPrice() {
        return price;
    }
    
    public Product(String productID, String name, double price, DiscountStrategy ds){
        this.productID = productID;
        this.name = name;
        this.price = price;
        discountStrategy = ds;
    }
}
