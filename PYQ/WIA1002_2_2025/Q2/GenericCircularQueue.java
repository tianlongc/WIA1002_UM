/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 */

/*
    Question (a): Generic Array Implementation of Circular Queue
*/

public class GenericCircularQueue<E>{
    private E[] queue;
    private int front, rear, size, capacity;
    private final static int MAX_CAPACITY = 8;
    
    public GenericCircularQueue(){
        this(MAX_CAPACITY);
    }
    
    public GenericCircularQueue(int capacity){
        // generic array creation with safe type cast using Bag concept
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[capacity];
        this.queue = temp;
        this.capacity = capacity;
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }
    
    public boolean isFull(){
        return size >= capacity;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void enqueue(E e){
        if (isFull()) {
            System.out.println("The Queue is full! Dequeue " + dequeue());
        }
        queue[rear] = e;
        rear = (rear + 1) % capacity;
        size++;
    }
    
    public E dequeue(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflows");
        }
        E temp = queue[front];
        queue[front] = null; // dereference
        front = (front + 1) % capacity;
        size--;
        return temp;
    }
    
    @Override
    public String toString(){
        if (isEmpty()) {
            return ""; // early exit
        }
        StringBuilder sb = new StringBuilder();
        for (int i = front, count = 0; count < size; i = (i + 1) % capacity, count++) {
            sb.append(queue[i]).append(" ");
        }
        return sb.toString();
    }
}
