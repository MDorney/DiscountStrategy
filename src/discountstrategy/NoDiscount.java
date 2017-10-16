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
public class NoDiscount implements DiscountStrategy{

    @Override
    public final double calcDiscountAmt(int qty, double unitCost) {
        return 0;
    }
    
}
