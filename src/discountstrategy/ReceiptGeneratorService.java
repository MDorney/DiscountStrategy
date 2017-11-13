/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.time.LocalDateTime;

/**
 *
 * @author L117student
 */
public class ReceiptGeneratorService {
    
    private Receipt receipt;
    private ReceiptOutputStrategy receiptType;
    
    
    public ReceiptGeneratorService(String storeInfo, ReceiptOutputStrategy receiptType, ReceiptDataAccessStrategy database, String customerID){
        this.receipt = new Receipt(storeInfo, database, customerID);
        this.setReceiptType(receiptType);
    }

    public final void addItem(String productID, int qty) {
        receipt.generateLineItem(productID, qty);
    }
    
    public final void generateReceipt(Receipt receipt) {
        receiptType.outputReceipt(receipt);
    }
    
    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt) {
        if (receipt == null) {
            throw new IllegalArgumentException("The receipt cannot be null");
        }
        this.receipt = receipt;
    }

    public final ReceiptOutputStrategy getReceiptType() {
        return receiptType;
    }

    public final void setReceiptType(ReceiptOutputStrategy receiptType) {
        if (receiptType == null) {
            throw new IllegalArgumentException("There must be a way to output the receipt");
        }
        this.receiptType = receiptType;
    }
    
    
}
