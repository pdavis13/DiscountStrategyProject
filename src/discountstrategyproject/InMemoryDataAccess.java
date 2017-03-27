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
public class InMemoryDataAccess implements DataAccessStrategy {
    private Customer[] customers = {
        new Customer("100", "John Smith"),
        new Customer("200", "Sally Jones"),
        new Customer("300", "Bob Clementi")
    };
    
    private Product[] products = {
        new Product("A101", "MLB Brewer's Hat ", 19.95, new QtyDiscount(5, .1)),
        new Product("B205", "Men's Dress Shirt", 35.50, new PercentOffDiscount(.2)),
        new Product("C222", "Women's Socks    ", 9.50, new NoDiscount())
    };
    
    /**
     * Tries to find a Customer by customer id.
     * @param custId - must not be null or empty
     * @return found Customer or null if not found or bad argument
     */
    @Override
    public final Customer findCustomer(final String custId) {
        // validation is needed for method parameter
        if(custId == null || custId.length() == 0) {
            throw new IllegalArgumentException("error: customerID is null or length is 0");
        }
        
        Customer customer = null;
        for(Customer c : customers) {
            if(custId.equals(c.getCustomerID())) {
                customer = c;
                break;
            }
        }
        
        if(customer == null)
            throw new IllegalArgumentException("error: customer associated with customerID was not found");
        
        return customer;
    }
    
    /**
     * Tries to find a Product by product id.
     * @param prodId - must not be null or empty
     * @return found Product or null if not found or bad argument
     */
    @Override
    public final Product findProduct(final String prodId) {
        // validation is needed for method parameter
        if(prodId == null || prodId.length() == 0) {
            throw new IllegalArgumentException("error: productID is null or 0");
        }
        
        Product product = null;
        for(Product p : products) {
            if(prodId.equals(p.getProductID())) {
                product = p;
                break;
            }
        }
        
        if(product == null)
            throw new IllegalArgumentException("error: product associated with productID was not found");
        
        return product;
    }
}
