/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L1Q4;

/**
 *
 * @author tianlongc
 */
public class Tester {
    public static void main(String[] args) {
        Account1 a = new Account1(1122, 1000, "George");
        a.setAnnualInterestRate(1.5);
        
        a.deposit(30, "Saving");
        a.deposit(40, "Salary");
        a.deposit(50, "Angpao");
        
        a.withdraw(5, "Living Expense");
        a.withdraw(4, "Groceries");
        a.withdraw(2, "Shopping");
        
        System.out.println("\n" + a);
    }
}
