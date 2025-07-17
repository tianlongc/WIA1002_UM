/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2CLL;

/**
 *
 * @author tianlongc
 */
class Node<E>{
    E element;
    Node<E> next;
    
    public Node(){
        this(null);
    }
    
    public Node(E element){
        this.element = element;
        this.next = null;
    }
}

public class GenericQueue<E>{
    Node<E> front, rear; // head and tail
    private int capacity, size;
    private final static int DEFAULT_CAPACITY = 25;
    
    public GenericQueue(){
        this(DEFAULT_CAPACITY);
    }
    
    public GenericQueue(int capacity){
        this.front = null;
        this.rear = null;
        this.capacity = capacity;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean isFull(){
        return size >= capacity;
    }
    
    public void enqueue(E e){
        if (isFull()) {
            throw new IllegalStateException("Queue overflow");
        }
        Node<E> newNode = new Node<>(e);
        if (front == null) {
            front = rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        rear.next = front; // maintain circularity
        size++;
        System.out.println("Enqueue: " + e);
    }
    
    public void enqueueMany(String elements){
        String[] element = elements.split(",");
        for (String e : element) {
            enqueue((E)e);
        }
    }
    
    public E dequeue(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        E temp = front.element;
        if (front == rear) {
            front = rear = null;
        }else{
            front = front.next;
            rear.next = front; // maintain cirularity
        }
        size--;
        System.out.println("Dequeue: " + temp);
        return temp;
    }
    
    public void dequeueAll(){
        System.out.println("\nThere are " + size + " items in the queue. Removing them all ...");
        while (!isEmpty()) {
            dequeue();
        }
        System.out.println("");
    }
    
    public void changeOrder(int k){
        System.out.println("\nChange queue order...");
        for (int i = 0; i < k-1; i++) {
            // Dequeue first
            E temp = front.element;
            if (front == rear) {
                front = rear = null;
            }else{
                front = front.next;
                rear.next = front; // maintain circularity
            }
            // Enqueue back
            Node<E> newNode = new Node<>(temp);
            if (front == null) {
                front = rear = newNode;
            }else{
                rear.next = newNode;
                rear = newNode;
            }
            rear.next = front; // maintain circularity
        }
    }
    
    public void display(){
        if (isEmpty()) {
            System.out.println("Nothing to display");
        }else{
            System.out.println("\nThere are " + size + " items in the queue. Displaying...");
            Node<E> current = front;
            for (int i = 0; i < size; i++, current = current.next) {
                System.out.printf("%s | ", current.element);
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        
        GenericQueue<String> q = new GenericQueue<String>(10);
        q.enqueue("Dom T");
        q.enqueue("Rafa N");
        q.enqueueMany("Roger F,Daniil M,Novak D,Alex Z,Stef T,Karen K");
        q.display();
        q.dequeue();
        q.enqueue("Matt B");
        q.enqueue("Kei N");
        q.display();
        q.dequeueAll();
        q.display();
        System.out.println("---------------------------");
        
        GenericQueue<Integer> q2 = new GenericQueue<Integer>(10);
        q2.enqueue(10);
        q2.enqueue(20);
        q2.enqueueMany("30,40,50,60,70,80,90");
        q2.display();
        q2.changeOrder(5);
        q2.display();
    }
}
