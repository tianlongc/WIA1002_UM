/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 * @param <Item> generic type parameter named Item
 */
public class Queue<Item>{
    private LinkedList<Item> list;
    
    public Queue(){
        this.list = new LinkedList<>();
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
        this.list.addLast(item);
    }
    
    public Item dequeue(){
        return list.removeFirst();
    }
    
    @Override
    public String toString(){
        return list.toString();
    }
    
    public void ChangeOrder(int k){
        if (k-1 >= size()) {
            throw new IllegalArgumentException("k cannot be greater than the queue size!");
        }
        for (int i = 0; i < k-1; i++) {
            enqueue(dequeue());
        }
    }
}
