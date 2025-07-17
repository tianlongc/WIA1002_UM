/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 * Basic Circular Array Implementation of Queue
 */
public class Queue {
    private String[] queue;
    private int capacity, front, rear, size;
    private final static int DEFAULT_CAPACITY = 25;
    
    public Queue(){
        this(DEFAULT_CAPACITY);
    }
    
    public Queue(int capacity){
        this.capacity = capacity;
        this.queue = new String[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public String peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        System.out.println("Peek(): " + queue[front]);
        return queue[front];
    }
    
    public void enqueue(String data){
        if (size == capacity-1) {
            throw new IllegalStateException("Queue overflow");
        }
        queue[rear] = data;
        rear = (rear + 1) % capacity;
        size++;
        System.out.println("Data " + data + " inserted");
    }
    
    public String dequeue(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        String temp = queue[front];
        queue[front] = null; // dereference
        front = (front + 1) % capacity;
        size--;
        System.out.println("Data " + temp + " has been removed");
        return temp;
    }
    
    public void display(){
        System.out.println("-".repeat(148));
        for (int i = 0; i < size; i++) {
            System.out.printf("|  %d   ", i);
        }
        System.out.println("|");
        System.out.println("-".repeat(148));
        for (int i = front, count = 0; count < size; i=(i+1)%capacity, count++) {
            System.out.printf("| %s   ", queue[i]);
        }
        System.out.println("|");
        System.out.println("-".repeat(148));
    }
}
