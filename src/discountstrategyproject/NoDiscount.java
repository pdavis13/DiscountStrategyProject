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
public class NoDiscount implements DiscountStrategy{
    double discountRate = 0;
    
    @Override
    public final double getDiscountRate(){
        return 0;
    }
    
    @Override    
    public final void setDiscountRate(double discountRate){
        discountRate = 0;
    }
    
    @Override
    public final double getDiscountAmt(double unitPrice, int qty){
        return 0;
    }
}
