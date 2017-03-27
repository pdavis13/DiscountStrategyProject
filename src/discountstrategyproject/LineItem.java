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
public class LineItem {
    private Product product;
    private int quantity;
    private double subtotal;

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        if(product == null)
            throw new IllegalArgumentException("error: attempted to set product to null");

        this.product = product;
    }

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        subtotal = product.getPrice()*quantity;
    }

    public final int getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) {
        if(quantity < 1)
            throw new IllegalArgumentException("error: attempted to set quantity to an invalid value");
        this.quantity = quantity;
    }

    public final double getSubtotal() {
        return subtotal;
    }
}
