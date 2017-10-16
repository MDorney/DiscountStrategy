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
public interface ReceiptDataAccessStrategy {
    
    public abstract Product findProduct(String productID);
    
    public abstract Customer findCustomer(String customerID);
    
}
