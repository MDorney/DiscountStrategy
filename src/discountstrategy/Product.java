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
class Product {

    private String productId;
    private String productName;
    private double unitCost;
    private DiscountStrategy discount;
    
    Product(String productId, String productName, double d, DiscountStrategy discount) {
        this.setProductId(productId);
        this.setDiscount(discount);
        this.setProductName(productName);
        this.setUnitCost(d);
    }

    public final double getDiscountAmt(int qty) {
        return discount.calcDiscountAmt(qty, unitCost);
    }
    
    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String productId) {
        if(productId == null || productId.length() == 0) {
            throw new IllegalArgumentException("The Product ID must exist");
        }
        else this.productId = productId;
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        if(productName == null || productName.length() == 0) {
            throw new IllegalArgumentException("The product must have a name");
        }
        else this.productName = productName;
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) {
        if (unitCost <= 0) {
            throw new IllegalArgumentException("An item cannot be less than $0.00");
        }
        else this.unitCost = unitCost;
    }

    public final DiscountStrategy getDiscount() {
        return discount;
    }

    public final void setDiscount(DiscountStrategy discount) {
        if (discount == null) {
            throw new IllegalArgumentException("You must add a discount even if it is no discount");
        } 
        else this.discount = discount;
    }
    
}
