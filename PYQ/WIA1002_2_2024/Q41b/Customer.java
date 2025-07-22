/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q41b;

/**
 *
 * @author tianlongc
 */
public class Customer implements Comparable<Customer>{
    private int customerID;
    private double depositAmount;
    
    public Customer(){
        this(0,0.0);
    }
    
    public Customer(int customerID, double depositAmount){
        this.customerID = customerID;
        this.depositAmount = depositAmount;
    }
    
    public double getDepositAmount(){
        return depositAmount;
    }
    
    @Override
    public String toString(){
        return String.format("Customer ID: %d   Deposit: RM%.2f", customerID, depositAmount);
    }
    
    @Override
    public int compareTo(Customer other){
        // Higher deposit amounts have higher priority
        return Double.compare(other.depositAmount, this.depositAmount);
        /*
        Explicit version
            if (this.depositAmount > other.depositAmount) return -1;
            else if (this.depositAmount < other.depositAmount) return 1;
            else return 0;
        */
    }
}
