/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L7;

/**
 *
 * @author tianlongc
 * @param <E> generic type parameter named element
 */
import java.util.LinkedList;

public class MyQueue<E>{
    private LinkedList<E> list;
    
    public MyQueue(E[] e){
        this.list = new LinkedList<>();
        for (E element:e) {
            this.list.addLast(element);
        }
    }
    
    public MyQueue(){
        this.list = new LinkedList<>();
    }
    
    /* Adds an element to this queue */
    public void enqueue(E e){
        list.addLast(e);
    }
    
    /* Removes an element from this queue */
    public E dequeue(){
        return list.removeFirst();
    }
    
    /* Return the specificied index element */
    public E getElement(int i){
        return this.list.get(i);
    }
    
    /**
     * Retrieves but does not remove the head of this queue
     * @return the head of this queue. Otherwise null if this queue is empty
     */
    public E peek(){
        if (list.isEmpty()) {
            return null;
        }
        return this.list.getFirst();
    }
    
    /* Returns the number of elements in this queue */
    public int getSize(){
        return list.size();
    }
    
    /* Returns true if the queue contains the specific element */
    public boolean contains(E e){
        return list.contains(e);
    }
    
    /* Returns true if the queue is empty */
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    @Override
    public String toString(){
        return "Queue: " + list.toString();
    }    
}
