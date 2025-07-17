/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 * @param <E> the generic type parameter named element
 */

public class Queue<E>{
    private E[] queue;
    private int capacity, front, rear, size;
    private final static int DEFAULT_CAPACITY = 25;
    
    public Queue(){
        this(DEFAULT_CAPACITY);
    }
    
    public Queue(int capacity){
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[capacity];
        this.queue = temp;
        this.capacity = capacity;
        this.front = 0;
        this.rear = 0;
    }
    
    public E peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        return queue[front];
    }
    
    public void enqueue(E item){
        if (size == capacity) {
            throw new IllegalStateException("Queue overflow");
        }
        queue[rear] = item;
        rear = (rear + 1) % capacity;
        size++;
    }
    
    public E dequeue(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        E temp = queue[front];
        queue[front] = null; // clear the reference
        front = (front + 1) % capacity;
        size--;
        return temp;
    }
    
    public E getElement(int i){
        if (i < 0 || i >= capacity) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        return queue[i];
    }
    
    public int getSize(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    @Override
    public String toString(){
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = front, count = 0; count < size; i=(i+1)%capacity, count++) {
            if (count > 0) {
                sb.append(", ");
            }
            sb.append(queue[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
