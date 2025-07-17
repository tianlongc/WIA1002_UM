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
import java.util.ArrayList;
import java.util.EmptyStackException;

public class GenericStack<E> implements StackInterface<E>{
    // An attribute that is an ArrayList to store the elements in this stack
    private ArrayList<E> stack;
    
    /**
     * A constructor that creates an empty stack
     */
    public GenericStack(){
        this.stack = new ArrayList<>();
    }
    
    /**
     * A method that returns the number of elements in this stack
     * @return the number of elements in this stack
     */
    @Override
    public int size(){
        return stack.size();
    }
    
    /**
     * A method that returns the top element in this stack
     * @return the top element in this stack
     */
    @Override
    public E peek(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size()-1);
    }
    
    /**
     * A method that returns and removes the top element in this stack
     * @return and removes the top element in this stack
     */
    @Override
    public E pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E o = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return o;
    }
    
    /**
     * A method that adds a new element to the top of this stack
     * @param e the new element to be added
     */
    @Override
    public void push(E e){
        stack.add(e);
    }
    
    /**
     * A method that returns true if the stack is empty
     * @return true if the stack is empty otherwise false
     */
    @Override
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    
    @Override
    public String toString(){
        return stack.toString();
    }
}
