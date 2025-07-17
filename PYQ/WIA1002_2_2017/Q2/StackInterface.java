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
public interface StackInterface<E>{
    
    /**
     * A method that returns the number of elements in this stack
     * @return the number of elements in this stack
     */
    public int size();
    
    /**
     * A method that returns the top element in this stack
     * @return the top element in this stack
     */
    public E peek();
    
    /**
     * A method that returns and removes the top element in this stack
     * @return and removes the top element in this stack
     */
    public E pop();
    
    /**
     * A method that adds a new element to the top of this stack
     * @param e the new element to be added
     */
    public void push(E e);
    
    /**
     * A method that returns true if the stack is empty
     * @return true if the stack is empty otherwise false
     */
    public boolean isEmpty();
    
}
