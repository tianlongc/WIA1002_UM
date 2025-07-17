/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 * @param <E> the generic type parameter named element
 */
public class GenericQueue<E>{
    private E[] queue;
    private int size, capacity, rear, front;
    private final static int DEFAULT_CAPACITY = 25;
    
    public GenericQueue(){
        this(DEFAULT_CAPACITY);
    }
    
    public GenericQueue(int capacity){
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[capacity];
        this.queue = temp;
        this.capacity = capacity;
        this.size = 0;
        this.front = 0;
        this.rear = 0;
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
            throw new IllegalStateException("Queue overflow");
        }
        queue[rear] = e;
        rear = (rear + 1) % capacity;
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
        E temp = queue[front];
        queue[front] = null; // dereference
        front = (front + 1) % capacity;
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
            queue[rear] = queue[front];
            queue[front] = null;
            rear = (rear+1)%capacity;
            front = (front+1)%capacity;
        }
    }
    
    public void display(){
        if (isEmpty()) {
            System.out.println("Nothing to display");
        }else{
            System.out.println("\nThere are " + size + " items in the queue. Displaying...");
            for (int i = front, count = 0; count < size; i=(i+1)%capacity, count++) {
                System.out.printf("%s | ", queue[i]);
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
