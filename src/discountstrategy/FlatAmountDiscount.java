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
public class FlatAmountDiscount implements DiscountStrategy {

    private double amountOff;
    
    public FlatAmountDiscount(double amountOff) {
        this.setAmountOff(amountOff);
    }
    
    @Override
    public final double calcDiscountAmt(int qty, double unitCost) {
        return qty * amountOff; //To change body of generated methods, choose Tools | Templates.
    }

    private final void setAmountOff(double amountOff) {
        if (amountOff <= 0) {
            throw new IllegalArgumentException("The discount must be greater than 0 per item");
        }
    }
    
    private final double getAmountOff() {
        return amountOff;
    }
    
}
