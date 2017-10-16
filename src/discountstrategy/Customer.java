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
class Customer {

    private String custId;
    private String name;
    
    Customer(String custId, String name) {
        this.setCustID(custId);
        this.setName(name);
    }

    public final String getCustId() {
        return custId;
    }

    public final void setCustID(String custId) {
        if(custId == null || custId.length() == 0) {
            throw new IllegalArgumentException("The customer ID must exist");
        }
        else this.custId = custId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        if(name == null || name.length() == 0) {
            throw new IllegalArgumentException("The customer name must exist");
        }
        else this.name = name;
    }
    
}
