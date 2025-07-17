/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 * Uses circular array concept to implement queue
 * @param <E> the generic type parameter named element
 */
public class GenericQueue<E>{
    private E[] queue;
    private int capacity, size, front, rear;
    private final static int DEFAULT_CAPACITY = 25;
    
    public GenericQueue(){
        this(DEFAULT_CAPACITY);
    }
    
    public GenericQueue(int capacity){
        this.capacity = capacity;
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[capacity];
        this.queue = temp;
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean isFull(){
        return size >= capacity;
    }
    
    public E peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow");
        }
        return queue[front];
    }
    
    public void enqueue(E e){
        if (isFull()) {
            System.out.println("Queue is full");
        }else{
            queue[rear] = e;
            rear = (rear + 1) % capacity;
            size++;
            System.out.println("Enqueue: " + e);
        }
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
        E temp = queue[front];
        queue[front] = null; // dereference
        front = (front + 1) % capacity;
        size--;
        System.out.println("Dequeue: " + temp);
        return temp;
    }
    
    public void dequeueAll(){
        System.out.println("\nThere are " + size + " items in the queue. Removing them all...");
        while (!isEmpty()) {
            dequeue();
        }
        System.out.println("");
    }
    
    public void display(){
        if (isEmpty()) {
            System.out.println("Nothing to display");
        }else{
            System.out.println("\nThere are " + size + " items in the queue. Display...");
            for (int i = front, count = 0; count < size; i=(i+1)%capacity, count++) {
                System.out.println(queue[i]); 
            }
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        
        GenericQueue<String> q = new GenericQueue<String>(6);
        q.enqueue("Hello");
        q.enqueueMany("all,who,wants,ice cream,or cookies");
        q.display();
        q.dequeue();
        q.dequeueAll();
        q.display();
        System.out.println("-------------------------");
        GenericQueue<Integer> q2 = new GenericQueue<Integer>(6);
        q2.enqueue(1000);
        q2.enqueue(2000);
        q2.enqueueMany("3000,4000 5000,6000,7000,8000 9000");
        q2.display();
        q2.dequeue();
        q2.dequeue();
        q2.enqueue(8000);
        q2.dequeueAll();
        q2.display();
    }
}
