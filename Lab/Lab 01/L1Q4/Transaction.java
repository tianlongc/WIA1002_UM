/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L1Q4;

/**
 *
 * @author tianlongc
 */
import java.util.Date;

public class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;
    
    public Transaction(char type, double amount, double balance, String description){
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        this.date = new Date();
    }
    
    public char getType(){
        return type;
    }
    
    public double getAmount(){
        return amount;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public String getDescription(){
        return description;
    }
    
    public Date getDate(){
        return date;
    }
    
    @Override
    public String toString(){
        return String.format("Transaction on %s\nType: %c\nAmount: $%.2f\nBalance: $%.2f\nDescription: %s\n", date, type, amount, balance, description);
    }
}
