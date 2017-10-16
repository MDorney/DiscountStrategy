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
public class QtyDiscount implements DiscountStrategy {
    private double percentOff;
    private int minQty;
    
    @Override
    public final double calcDiscountAmt(int qty, double unitCost) {
        double discountAmt = 0;
        if( qty >= minQty) {
            discountAmt = qty * unitCost * percentOff;
        }
        return discountAmt;
    }

    public QtyDiscount(double percentOff, int minQty) {
        this.setPercentOff(percentOff);
        this.setMinQty(minQty);
    }

    public final int getMinQty() {
        return minQty;
    }

    public final void setMinQty(int minQty) {
        //Validator needed
        this.minQty = minQty;
    }
    
    public final double getPercentOff() {
        return percentOff;
    }

    public final void setPercentOff(double percentOff) {
        //Validator needed
        if(percentOff < 0 || percentOff > 1) {
            throw new IllegalArgumentException("This is an invalid percent off");
        }
        else
            this.percentOff = percentOff;
    }
    
    
}
