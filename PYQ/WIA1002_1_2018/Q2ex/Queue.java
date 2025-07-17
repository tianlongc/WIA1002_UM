/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2ex;

/**
 *
 * @author tianlongc
 * Queue Implementation using Linked List
 */
class Node{
    String data;
    Node next;
    
    public Node(){
        this(null);
    }
    
    public Node(String data){
        this.data = data;
        this.next = null;
    }
}

public class Queue {
    private Node front, rear;
    private int capacity, size;
    private final static int DEFAULT_CAPACITY = 25;
    
    public Queue(){
        this(DEFAULT_CAPACITY);
    }
    
    public Queue(int capacity){
        this.front = null;
        this.rear = null;
        this.capacity = capacity;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public String peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflows");
        }
        System.out.println("Peek(): " + front.data);
        return front.data;
    }
    
    public void enqueue(String data){
        Node newNode = new Node(data);
        if (front == null) {
            front = rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Data " + data + " inserted");
    }
    
    public String dequeue(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflows");
        }
        Node temp = front;
        front = front.next;
        size--;
        System.out.println("Data " + temp.data + " has been removed");
        return temp.data;
    }
}
