/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author L117student
 */
class Receipt {
    private Customer customer;
    //private LineItem[] lineItems;
    private ArrayList<LineItem> lineItems;
    private ReceiptDataAccessStrategy custDatabase;
    private String storeInfo;
    private LocalDateTime date;
    private double subTotal;
    private double totalDiscount;
    
    public Receipt(String storeInfo, ReceiptDataAccessStrategy custDatabase, String customerId) {
        setStoreInfo(storeInfo);
        date = LocalDateTime.now();
        setReceiptDataAccessStrategy(custDatabase);
        lookUpCustomer(customerId);
        lineItems = new ArrayList<LineItem>();
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        if(date == null) {
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
        lineItems.add(new LineItem(productId, qty, custDatabase));
    }
    public final String returnReceiptHeader() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return "Store: " + storeInfo + '\n' + "Date: " + date + "\n Customer: " + customer.getName();
    }
    public final String returnLineItems() {
        String lineItemString = "";
        double subTotal = 0;
        double totalDiscount = 0;
        for (int i = 0; i < lineItems.size(); i++) {
            LineItem current = lineItems.get(i);
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
