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
public class StartUp {
    public static void main(String[] args) {
        // Configuration
        ReceiptDataAccessStrategy prodDatabase = new InMemoryDataAccess();
        ReceiptOutputStrategy receiptType = new PrinterReceiptOutput();
        String storeInfo = "Kohl's Store #123";
        PosRegister pos = new PosRegister(prodDatabase, receiptType);
        
        // Customer sales
        pos.startNewSale(storeInfo, "100");
        pos.addItem("A101", 2);
        pos.endSale();
        pos.startNewSale(storeInfo, "200");
        pos.addItem("C222", 2);
        pos.endSale();
        pos.startNewSale(storeInfo, "300");
        pos.addItem("B205", 1);
        pos.endSale();
    }
}
