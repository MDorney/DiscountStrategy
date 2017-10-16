/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.text.DecimalFormat;

/**
 *
 * @author L117student
 */
public class LineItem {
    
    private Product product;
    private int qty;
    private double extendedCost;
    private double discountAmt;
    private ReceiptDataAccessStrategy prodDatabase;
    
    public LineItem(String productId, int qty, ReceiptDataAccessStrategy prodDatabase) {
        setReceiptDataAccessStrategy(prodDatabase);
        lookUpProduct(productId);
        setQty(qty);
        calculateExtendedCost();
        calculateDiscountAmt();
    }
    @Override
    public final String toString() {
        DecimalFormat df2 = new DecimalFormat(".##");
        return product.getProductId() + '\t' + product.getProductName() + '\t' + qty + '\t' + product.getUnitCost() + '\t' + this.getExtendedCost() + '\t' + df2.format(this.getDiscountAmt()) + '\n';
    }
    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("A negative quantity is not allowed");
        } else {
            this.qty = qty;    
        }
        
    }
    public final double getDiscountAmt() {
        return discountAmt;
    }
    public final double getExtendedCost() {
        return extendedCost;
    }
    
    private final void calculateDiscountAmt() {
        this.discountAmt = product.getDiscountAmt(qty);
    }
    
    private final void calculateExtendedCost() {
        extendedCost = 0;
        extendedCost = qty * product.getUnitCost();
        this.extendedCost = extendedCost;
    }
    

    public final Product getProduct() {
        return product;
    }
    
    private final void lookUpProduct(String productId) {
        product = prodDatabase.findProduct(productId);
        
        if (product == null) {
            throw new IllegalArgumentException("This product does not exist");
        }
    }
    
    public final ReceiptDataAccessStrategy getReceiptDataAccessStrategy() {
        return this.prodDatabase;
    }
    
    private final void setReceiptDataAccessStrategy(ReceiptDataAccessStrategy prodDatabase) {
        this.prodDatabase = prodDatabase;
        if (prodDatabase == null) {
            throw new IllegalArgumentException("There must be a product database");
        }
    }
}
