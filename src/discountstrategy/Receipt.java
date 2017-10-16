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
class Receipt {
    private Customer customer;
    private LineItem[] lineItems;
    private ReceiptDataAccessStrategy custDatabase;
    private String storeInfo;
    private String date;
    private double subTotal;
    private double totalDiscount;
    
    public Receipt(String storeInfo, String date, ReceiptDataAccessStrategy custDatabase, String customerId) {
        setStoreInfo(storeInfo);
        setDate(date);
        setReceiptDataAccessStrategy(custDatabase);
        lookUpCustomer(customerId);
        lineItems = new LineItem[0];
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        if(storeInfo == null || storeInfo.length() < 1) {
            throw new IllegalArgumentException("A store # must be provided");
        }
        this.storeInfo = storeInfo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if(date == null || date.length() < 1) {
            throw new IllegalArgumentException("A date Must be provided");
        }
        this.date = date;
    }
    
    private final void setReceiptDataAccessStrategy(ReceiptDataAccessStrategy custDatabase) {
        this.custDatabase = custDatabase;
        if (custDatabase == null) {
            throw new IllegalArgumentException("There must be a customer database");
        }
    }
    
    private final void lookUpCustomer(String customerId) {
        customer = custDatabase.findCustomer(customerId);
        //Ask about default/unregistered
        if (customer == null) {
            throw new IllegalArgumentException("There is no customer for that ID");
        }
    }
    public final void generateLineItem(String productId, int qty) {
        // needs validation
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = new LineItem(productId, qty, custDatabase);
        lineItems = tempItems;
    }
    public final String returnReceiptHeader() {
        return "Store: " + storeInfo + '\n' + "Date: " + date + "\n Customer: " + customer.getName();
    }
    public final String returnLineItems() {
        String lineItemString = "";
        double subTotal = 0;
        double totalDiscount = 0;
        for (int i = 0; i < lineItems.length; i++) {
            LineItem current = lineItems[i];
            lineItemString += current.toString();
            totalDiscount += current.getDiscountAmt();
            subTotal += current.getExtendedCost();
        }
        this.setSubTotal(subTotal);
        this.setTotalDiscount(totalDiscount);
        return lineItemString;
    }

    public final String returnReceiptFooter() {
        DecimalFormat df2 = new DecimalFormat(".##");
        double grandTotal = (subTotal - totalDiscount);
        String receiptFooter = "Subtotal before discounts: " + df2.format(subTotal) + '\n'
                + "Total discounts: " + df2.format(totalDiscount) + '\n' + "Grand Total: "
                + df2.format(grandTotal);
        return receiptFooter;
    }
    
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }
}
