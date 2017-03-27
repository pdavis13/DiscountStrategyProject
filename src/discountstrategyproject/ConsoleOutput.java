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
public class ConsoleOutput implements OutputStrategy{
    @Override
    public final void generateReceipt(String data){
        if(data == null)
            throw new IllegalArgumentException("data is null at generateReceipt");
        System.out.println(data);
    }
}
