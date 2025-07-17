/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4ex;

/**
 *
 * @author tianlongc
 * @param <E> generic type parameter named element
 */
public class Queue<E>{
    private LinkedList<E> list;
    
    public Queue(E[] items){
        this.list = new LinkedList<>();
        for (E item : items) {
            enqueue(item);
        }
    }
    
    public Queue(){
        this.list = new LinkedList<>();
    }
    
    public void enqueue(E e){
        this.list.addLast(e);
    }
    
    public E dequeue(){
        return list.removeFirst();
    }
    
    public E getElement(int i){
        return list.get(i);
    }
    
    public int getSize(){
        return list.size();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    @Override
    public String toString(){
        return list.toString();
    }
}
