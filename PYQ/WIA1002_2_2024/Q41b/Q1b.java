/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q41b;

/**
 *
 * @author tianlongc
 */
import java.util.Random;

public class Q1b {
    public static void main(String[] args) {
        MyPriorityQueue pq = new MyPriorityQueue();
        MyStack stack = new MyStack();
        
        Random rd = new Random();
        for (int i = 1; i <= 10; i++) {
            pq.enqueue(i, rd.nextDouble(9501)+500);
        }
        
        System.out.println("Customers served:");
        while (!pq.isEmpty()) {
            Customer c = pq.dequeue();
            if (c.getDepositAmount() < 4000) {
                stack.push(c);
            }else{
                System.out.println(c);
            }
        }
        
        System.out.println("\nCustomers in stack (deposits < RM4000):");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
