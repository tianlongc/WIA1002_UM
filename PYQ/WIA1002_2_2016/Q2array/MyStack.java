/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2array;

/**
 * Array Implementation consumes more time than ArrayList
 * For efficiency uses linked list or array list
 * @author tianlongc
 * @param <E> generic type parameter named element
 */
import java.util.EmptyStackException;

public class MyStack<E>{
    private E[] stack;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    
    public MyStack(){
        this(DEFAULT_CAPACITY);
    }
    
    public MyStack(int capacity){
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        E[] temp = (E[]) new Object[capacity];
        this.stack = temp;
        this.size = 0;
    }
    
    public void push(E o){
        if (size >= stack.length) {
            E[] temp = (E[]) new Object[stack.length * 2];
            System.arraycopy(stack, 0, temp, 0, stack.length);
            stack = temp;
        }
        stack[size++] = o;
    }
    
    public E pop(){
        if (isEmpty()) {
            throw new EmptyStackException(); // Stack underflows
        }
        E o = stack[size-1];
        stack[--size] = null; // Clear element (Garbage Collection)
        return o;
    }
    
    public E peek(){
        if (isEmpty()) {
            throw new EmptyStackException(); // Stack underflows
        }
        return stack[size-1];
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public int getSize(){
        return size;
    }
}
