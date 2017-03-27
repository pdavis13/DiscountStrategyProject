package discountstrategyproject;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
/**
 *
 * @author Peter
 */
public class Receipt {
    private final Customer customer;
    private final int receiptNum;
    private LineItem[] lineItems;
    
    public Receipt(String custID, int receiptNum, DataAccessStrategy db){
        customer = db.findCustomer(custID);
        this.receiptNum = receiptNum;
        lineItems = new LineItem[0];
    }
    
    // add a lineItem to the receipt's array of lineItems using addToArray
    public final void addLineItem(String prodID, int qty, DataAccessStrategy db){
        if(qty < 1)
            throw new IllegalArgumentException("error: invalid qty for lineItem");

        Product prod = db.findProduct(prodID);
        LineItem lineItem = new LineItem(prod, qty);
        addToArray(lineItem);
    }
    
    // add to the LineItem array by creating a temporary copy
    private final void addToArray(final LineItem lineItem) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = lineItem;
        lineItems = tempItems;
    }
    
    // create and return the receipt data as a string
    public final String getData(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String data ="Thank you for shopping at Kohls!\n\nSold to: " + customer.getName() + "\n" + dateFormat.format(new Date()) + "\nReceipt No.: " + receiptNum + "\n\nID\tItem\t\t\tPrice\tQty\tSubtotal\tDiscount\n--------------------------------------------------";
        double netTotalCost = 0;
        double totalSaved = 0;
        for(int i = 0; i < lineItems.length; i++){
            Product prod = lineItems[i].getProduct();
            data += "\n" + prod.getProductID() + "\t" + prod.getName() + "\t" + decimalFormat.format(prod.getPrice()) + "\t" + lineItems[i].getQuantity() + "\t" + decimalFormat.format(lineItems[i].getSubtotal()) + "\t" + decimalFormat.format(prod.getDiscountStrategy().getDiscountAmt(prod.getPrice(), lineItems[i].getQuantity()));
            netTotalCost += lineItems[i].getSubtotal();
            totalSaved += prod.getDiscountStrategy().getDiscountAmt(prod.getPrice(), lineItems[i].getQuantity());
        }
        data += "\n----------\nNet Total: " + decimalFormat.format(netTotalCost) + "\nTotal Saved: -" + decimalFormat.format(totalSaved) + "\nTotal Due: " + decimalFormat.format((netTotalCost - totalSaved)) + "\n\nHave a great day!";
        return data;
    }
}
