/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 * Basic Array Implementation of Stack
 */
public class Stack {
    private char[] stack;
    private int size, top;
    private static final int DEFAULT_CAPACITY = 25;
    
    public Stack(){
        this(DEFAULT_CAPACITY);
    }
    
    public Stack(int size){
        this.size = size;
        this.stack = new char[size];
        this.top = -1;
    }
    
    public void push(char c){
        if (isStackFull()) {
            throw new IllegalStateException("Stack overflow!");
        }
        stack[++top] = c;
    }
    
    public char pop(){
        if (isStackEmpty()) {
            throw new IllegalStateException("Stack underflow!");
        }
        return stack[top--];
    }
    
    public char peek(){
        if (isStackEmpty()) {
            throw new IllegalStateException("Stack underflow!");
        }
        return stack[top];
    }
    
    public boolean isStackEmpty(){
        return top == -1;
    }
    
    public boolean isStackFull(){
        return top == size-1;
    }
}
