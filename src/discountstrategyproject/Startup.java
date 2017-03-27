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
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataAccessStrategy db = new InMemoryDataAccess();
        OutputStrategy os = new GUIOutput();
        CheckoutKiosk kiosk = new CheckoutKiosk();
        
        // Customer #1 sale
        kiosk.startSale("100", db);
        kiosk.addItemToSale("B205", 2);
        kiosk.addItemToSale("A101", 1);
        kiosk.endSaleAndOutputReceipt(os);
        
        // Customer #2 sale
        kiosk.startSale("200", db);
        kiosk.addItemToSale("C222", 4);
        kiosk.addItemToSale("B205", 6);
        kiosk.endSaleAndOutputReceipt(os);
    }
    
}
