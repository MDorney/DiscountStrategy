package discountstrategy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author L117student
 */
public class PercentOffDiscount implements DiscountStrategy {
    private double percentOff;
    
    @Override
    public final double calcDiscountAmt(int qty, double unitCost) {
        return qty * unitCost * percentOff;
    }

    public PercentOffDiscount(double percentOff) {
        this.setPercentOff(percentOff);
    }
    
    public final double getPercentOff() {
        return percentOff;
    }

    public final void setPercentOff(double percentOff) {
        if(percentOff < 0 || percentOff > 1) {
            throw new IllegalArgumentException("This is an invalid percent off");
        }
        this.percentOff = percentOff;
    }
    
    
}
