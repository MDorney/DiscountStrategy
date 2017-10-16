/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author L117student
 */
public class PrinterReceiptOutput implements ReceiptOutputStrategy {

    @Override
    public final void outputReceipt(Receipt receiptToPrint) {
        System.out.println(receiptToPrint.returnReceiptHeader());
        System.out.println(receiptToPrint.returnLineItems());
        System.out.println(receiptToPrint.returnReceiptFooter() + "\n\n");
             //To change body of generated methods, choose Tools | Templates.
    }
    
}
