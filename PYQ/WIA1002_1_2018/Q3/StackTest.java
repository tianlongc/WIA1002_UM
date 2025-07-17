/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 */

import java.util.LinkedList;
public class StackTest {
    private String[] stack;
    private int top, size;
    private final static int DEFAULT_CAPACITY = 25;
    
    public StackTest(){
        this(DEFAULT_CAPACITY);
    }
    
    public StackTest(int size){
        this.size = size;
        this.stack = new String[size];
        this.top = -1;
    }
    
    public boolean isEmpty(){
        return top == -1;
    }
    
    public String peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        return stack[top];
    }
    
    public void push(String item){
        if (top == size-1) {
            throw new IllegalStateException("Stack overflow");
        }
        System.out.println("Push item into stack: " + item);
        stack[++top] = item;
    }
    
    public String pop(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        String temp = stack[top];
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
    
    // Supposedly use top instead of size in proper implementation
    // in conditional part of for loop
    
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
