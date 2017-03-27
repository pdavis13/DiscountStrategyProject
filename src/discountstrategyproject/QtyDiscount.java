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
public class QtyDiscount implements DiscountStrategy{
    int minQty;
    double discountRate;
    
    @Override
    public final double getDiscountRate(){
        return discountRate;
    }
    
    @Override    
    public final void setDiscountRate(double discountRate){
        if(discountRate <= 0 || discountRate > 1)
            throw new IllegalArgumentException("attempted to set an invalid discountRate");
        this.discountRate = discountRate;
    }
    
    @Override
    public final double getDiscountAmt(double unitPrice, int qty){
        if(qty >= minQty){
            return unitPrice*discountRate*qty;
        } else{
            return 0;
        }
    }
    
    public QtyDiscount(int minQty, double discountRate) {
        this.discountRate = discountRate;
        this.minQty = minQty;
    }
}
