/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 * @param <Item> generic type parameter named element
 */
import java.util.LinkedList;

public class Queue<Item>{
    private LinkedList<Item> list;
    
    public Queue(){
        this.list = new LinkedList<>();
    }
    
    public Queue(Item[] items){
        this.list = new LinkedList<>();
        for (Item item : items) {
            this.list.addLast(item);
        }
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public int size(){
        return list.size();
    }
    
    public Item peek(){
        return list.getFirst();
    }
    
    public void enqueue(Item item){
        list.addLast(item);
    }
    
    public Item dequeue(){
        return list.removeFirst();
    }
    
    public String toString(){
        return list.toString();
    }
    
    public void ChangeOrder(int k){
        if (k - 1 >= size()) {
            throw new IllegalArgumentException("k cannot be greater than the queue size!");
        }
        for (int i = 0; i < k-1; i++) {
            enqueue(dequeue());
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        
        for (int i = 10; i <= 90; i+=10) {
            q.enqueue(i);
        }
        
        System.out.println("Before: " + q);
        q.ChangeOrder(4);
        System.out.println("After: " + q);
    }
}
