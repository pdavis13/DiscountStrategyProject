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
public class Customer {
    private String customerID;
    private String name;

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }
    
    public Customer(String customerID, String name){
        this.customerID = customerID;
        this.name = name;
    }
}
