package discountstrategyproject;

/**
 *
 * @author Peter
 */
public class CheckoutKiosk {
    private Receipt receipt;
    private int receiptNum = 0;
    DataAccessStrategy db;
    
    public final void startSale(String custId, DataAccessStrategy db){
        receiptNum++;
        receipt = new Receipt(custId, receiptNum, db);
        this.db = db;
    }
    
    public final void addItemToSale(String prodId, int qty){
        if(prodId == null)
            throw new IllegalArgumentException("error: invalid prodId");
        if(qty < 1)
            throw new IllegalArgumentException("error: invalid qty");
        receipt.addLineItem(prodId, qty, db);
    }
    
    public final void endSaleAndOutputReceipt(OutputStrategy os){
        if(os == null)
            throw new IllegalArgumentException("error: OutputStrategy is null at endSaleAndOutputReceipt");
        os.generateReceipt(receipt.getData());
    }
}
