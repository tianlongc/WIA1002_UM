/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 * @param <E> generic type parameter named element
 */
import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack<E>{
    private ArrayList<E> stack;
    
    public MyStack(){
        this.stack = new ArrayList<>();
    }
    
    public void push(E o){
        this.stack.add(o);
    }
    
    public E pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E o = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return o;
    }
    
    public E peek(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size()-1);
    }
    
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    
    public int getSize(){
        return stack.size();
    }
}
