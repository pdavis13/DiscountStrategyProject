package discountstrategyproject;


public interface DataAccessStrategy {
    public abstract Customer findCustomer(final String custId);
    
    public abstract Product findProduct(final String prodId);
}
