/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q41b;

/**
 *
 * @author tianlongc
 */
import java.util.PriorityQueue;

public class MyPriorityQueue{
    private PriorityQueue<Customer> heap;
    
    // No-arg constructor
    public MyPriorityQueue(){
        this.heap = new PriorityQueue<>();
    }
    
    public void enqueue(int customerID, double depositAmount){
        this.heap.offer(new Customer(customerID, depositAmount));
    }
    
    public Customer dequeue(){
        return heap.poll();
    }
    
    public boolean isEmpty(){
        return heap.isEmpty();
    }
}
