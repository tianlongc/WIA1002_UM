/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2ex;

/**
 *
 * @author tianlongc
 */

/*
    Question (c): Reimplement (a) using a custom Priority Queue with a generic array 
                  circular queue
                  - Same capacity constraints
                  - Highest priority elements will be replaced when the queue is full
                  - Priority is determined as follows:
                    1. Alphabetical order of the first character (A highest, Z lowest)
                    2. If the first character is the same, compare the numeric part in descending order
                     (e.g., S12345678 has higher priority than S87654321)
*/
import java.util.Comparator;

/**
 * @param <E> the generic type parameter named element
 */
public class GenericPriorityQueue<E> {
    private E[] heap;
    private int size, capacity;
    private final static int MAX_CAPACITY = 8;
    private final Comparator<? super E> comparator;
    
    public GenericPriorityQueue(){
        this(MAX_CAPACITY, null);
    }

    public GenericPriorityQueue(Comparator<? super E> comparator) {
        this(MAX_CAPACITY, comparator);
    }
    
    public GenericPriorityQueue(int capacity, Comparator<? super E> comparator){
        // generic array creation with safe type cast using Bag concept
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[capacity];
        this.heap = temp;
        this.capacity = capacity;
        this.size = 0;
        this.comparator = comparator;
    }
    
    public boolean isFull(){
        return size >= capacity;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }

    public void offer(E e){
        if (isFull()) {
            System.out.println("PriorityQueue is full! Replaced " + poll());
        }
        int i = size++; // child index = current size
        siftUp(i, e);
    }

    // Helper method to maintain heap property while inserting
    private void siftUp(int i, E e) {
        if (comparator == null) {
            throw new IllegalStateException("Comparator is not defined");
        }
        while (i > 0) {
            int parent = (i - 1) >> 1; // Formula: (i-1)/2
            E p = heap[parent];
            if (comparator.compare(e, p) >= 0) 
                break;
            heap[i] = p; // move parent down
            i = parent; // move up to parent's index
        }
        heap[i] = e;
    }

    public E peek(){
        if (isEmpty()) {
            throw new IllegalStateException("PriorityQueue underflows");
        }
        return heap[0];
    }
    
    public E poll(){
        if (isEmpty()) {
            throw new IllegalStateException("PriorityQueue underflows");
        }
        E temp = heap[0];
        E e = heap[--size];
        heap[size] = null; // deference
        if (size > 0)
            siftDown(0, e);
        return temp;
    }

    // Helper method to maintain heap property while removing
    private void siftDown(int i, E e) {
        if (comparator == null) {
            throw new IllegalStateException("Comparator is not defined");
        }
        int half = size >> 1; // only nodes with children
        while (i < half) {
            int child = (i * 2) + 1; // left child
            E c = heap[child];
            int right = child + 1;
            if (right < size && comparator.compare(c, heap[right]) > 0) {
                c = heap[child = right]; // pick smaller child
            }
            if (comparator.compare(e, c) <= 0) 
                break;
            heap[i] = c; // move child up
            i = child; // move down to child's index
        }
        heap[i] = e;
    }
    
    /*
        Simulate while(!isEmpty()) poll() for all elements in Priority Order
    */
    @Override
    public String toString(){
        if (isEmpty()) {
            return ""; // early exit
        }
        StringBuilder sb = new StringBuilder();
        
        E[] temp = heap.clone();
        int tempSize = size;
        
        while(!isEmpty()){
            sb.append(poll()).append(' ');
        }
        // Restore heap and size (Preserve Heap)
        this.heap = temp;
        this.size = tempSize;
        return sb.toString();
    }
}