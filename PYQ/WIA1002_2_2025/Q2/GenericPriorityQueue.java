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
    Question (b): Create a custom Priority Queue using generic array 
                  circular queue based on (a).
*/
import java.util.Comparator;

public class GenericPriorityQueue<E> implements Comparator<E>{
    private E[] queue;
    private int front, rear, size, capacity;
    private final static int MAX_CAPACITY = 8;
    
    public GenericPriorityQueue(){
        this(MAX_CAPACITY);
    }
    
    public GenericPriorityQueue(int capacity){
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

    /*  Insertion flow
        1. Start from the rear index
        2. While traversing backwards, compare each existing elements with the inserted element `e`
           - If the existing element has higher priority
             shift it one position to the right
        3. Continue shifting until the correct insertion point is found
        4. Insert the new element at that position
        5. Update rear and size
    */
    public void enqueue(E e){
        if (isFull()) {
            System.out.println("The Priority Queue is full! Dequeue " + dequeue());
        }
        if (isEmpty()) {
            queue[rear] = e;
        }else{
            // insertion sort
            int i = rear;
            while (i != front && compare(queue[(i - 1 + capacity) % capacity], e) > 0) {
                queue[i] = queue[(i - 1 + capacity) % capacity]; // Shift right
                i = (i - 1 + capacity) % capacity;
            }
            queue[i] = e; // insert element
        }
        rear = (rear + 1) % capacity;
        size++;
    }

    public E peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflows");
        }
        return queue[front];
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
    
    /*
        Simulate while(!isEmpty()) dequeue() for all elements in Priority Order
    */
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
    
    @Override
    public int compare(E o1, E o2) {
        // Safe type casting
        String matricNumber1 = o1.toString();
        String matricNumber2 = o2.toString();
        
        char c1 = matricNumber1.charAt(0);
        char c2 = matricNumber2.charAt(0);
        // Compare first character
        if (c1 != c2) {
            return Character.compare(c1, c2); // sort alphabetically
        }
        // If alphabets same, compare numeric part
        int n1 = Integer.parseInt(matricNumber1.substring(1));
        int n2 = Integer.parseInt(matricNumber2.substring(1));
        // sort descending
        return Integer.compare(n2, n1);
    }
}
