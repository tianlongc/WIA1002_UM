/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L1Q3;

/**
 *
 * @author tianlongc
 */
import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    
    // no-arg constructor (default)
    public Account(){
        this.id = 0;
        this.balance = 0;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }
    
    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = 0;
        this.dateCreated = new Date();
    }
    
    // Accessor
    public int getId(){
        return id;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    
    public Date getDateCreated(){
        return dateCreated;
    }
    
    // Mutator
    public void setId(int id){
        this.id = id;
    }
    
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    
    public double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }
    
    public double getMonthlyInterest(){
        return balance * getMonthlyInterestRate()/100.0;
    }
    
    // Methods
    public void withdraw(double amount){
        if (amount <= balance) {
            this.balance -= amount;
            System.out.printf("Withdrew $%.2f\n", amount);
        }else{
            System.out.println("The withdraw amount cannot exceed the balance!");
        }
    }
    
    public void deposit(double amount){
        if (amount > 0) {
            this.balance += amount;
            System.out.printf("Deposited $%.2f\n", amount);
        }else{
            System.out.println("The deposit amount cannot be zero or negative!");
        }
    }
    // N = number of months
    public double calculateInterest(int N){
        return (annualInterestRate/100.0 * balance * N);
    }
    
    // Test program (Main)
    public static void main(String[] args) {
        Account a = new Account(1122, 20000);
        
        a.setAnnualInterestRate(4.5);
        a.withdraw(2500);
        a.deposit(3000);
        
        System.out.printf("Balance: $%.2f\n", a.getBalance());
        System.out.printf("Monthly interest: $%.2f\n", a.getMonthlyInterest());
        System.out.println("Date created: " + a.getDateCreated());
        
        // Task: Add method to calculate interest after N number of months
        int N = 3;
        System.out.printf("Total amount of interest after %d years: $%.2f\n", N, a.calculateInterest(N));
    }
}
