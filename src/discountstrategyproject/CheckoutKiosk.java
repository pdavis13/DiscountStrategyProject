package discountstrategyproject;

/**
 *
 * @author Peter
 */
public class CheckoutKiosk {
    private Receipt receipt;
    private OutputStrategy output;
    
    public CheckoutKiosk(OutputStrategy output){
        this.output = output;
    }
    
    public final void startSale(String custId, DataAccessStrategy db){
        receipt = new Receipt(custId, db);
    }
    
    public final void addItemToSale(String prodId, int qty){
        receipt.addLineItem(prodId, qty);
    }
    
    public final void endSale(){
        output.generateReceipt(receipt.getData());
    }
}
