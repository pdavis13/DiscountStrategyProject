package discountstrategyproject;


public interface DataAccessStrategy {
    public Customer findCustomer(final String custId);
    
    public Product findProduct(final String prodId);
}
