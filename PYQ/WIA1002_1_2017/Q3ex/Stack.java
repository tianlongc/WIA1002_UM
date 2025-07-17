/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3ex;

/**
 *
 * @author tianlongc
 * @param <E> generic type parameter named element
 */
public class Stack<E>{
    private LinkedList<E> list;
    private int capacity;
    private final static int DEFAULT_CAPACITY = 25;
    
    public Stack(){
        this(DEFAULT_CAPACITY);
    }
    
    public Stack(int capacity){
        this.capacity = capacity;
        this.list = new LinkedList<>();
    }
    
    public void push(E e){
        if (isStackFull()) {
            throw new IllegalStateException("Stack overflow");
        }
        list.addLast(e);
    }
    
    public E peek(){
        if (isStackEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        return list.getLast();
    }
    
    public E pop(){
        if (isStackEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        return list.removeLast();
    }
    
    public int size(){
        return list.size();
    }
    
    public boolean isStackEmpty(){
        return list.isEmpty();
    }
    
    public boolean isStackFull(){
        return list.size() == capacity;
    }
}
