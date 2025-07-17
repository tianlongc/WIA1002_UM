/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 * @param <T> the generic type parameter (data type)
 */
public class StackWithGeneric<T>{
    private T[] stack;
    private int size, top;
    private final static int DEFAULT_CAPACITY = 25;
    
    public StackWithGeneric(){
        this(DEFAULT_CAPACITY);
    }
    
    public StackWithGeneric(int size){
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[size];
        this.stack = temp;
        this.size = size;
        this.top = -1;
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public T peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        return stack[top];
    }
    
    public void push(T item){
        if (top == size-1) {
            throw new IllegalStateException("Stack overflow");
        }
        System.out.println("Push item into stack: " + item);
        stack[++top] = item;
    }
    
    public T pop(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        T temp = stack[top];
        stack[top--] = null;
        return temp;
    }
    
    public void popAll(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        System.out.println("Pop all item in stack:");
        while (!isEmpty()) {
            System.out.println("Removing " + pop() + " ..");
        }
    }
    
    public void display(){
        System.out.println("Display stack:");
        for (int i = 0; i < size; i++) {
            System.out.println(stack[i]);
        }
    }
    
    public void displayInReverse(){
        System.out.println("Display stack in reverse:");
        for (int i = size-1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
