/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L1Q4;

/**
 *
 * @author tianlongc
 */
import java.util.ArrayList;

public class Account1 extends Account{
    private String name;
    private ArrayList<Transaction> transactions;
    
    public Account1(int id, double balance, String name){
        super(id, balance);
        this.name = name;
        transactions = new ArrayList<>();
    }
    
    public void withdraw(double amount, String description){
        super.withdraw(amount);
        transactions.add(new Transaction('W', amount, super.getBalance(), description));
    }
    
    public void deposit(double amount, String description){
        super.deposit(amount);
        transactions.add(new Transaction('D', amount, super.getBalance(), description));
    }
    
    @Override
    public String toString(){
        String history = "";
        for (Transaction transaction: transactions) {
            history += transaction + "\n";
        }
        
        return String.format("=== Account Summary ==="
                + "\nAccount Holder Name: %s\n"
                + "Annual Interest Rate: %.1f\n"
                + "Balance: $%.2f\n\n=== Transaction History ===\n%s"
                , name, super.getAnnualInterestRate(), super.getBalance(), history);
    }
}
