/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 */
import java.util.ArrayList;
import java.util.EmptyStackException;

public class GenericStack<E>{
    private ArrayList<E> stack;
    
    public GenericStack(){
        this.stack = new ArrayList<>();
    }
    
    public void push(E e){
        this.stack.addLast(e);
    }
    
    public E peek(){
        if (isEmpty()) {
           throw new EmptyStackException(); 
        }
        return stack.get(stack.size()-1);
    }
    
    public E pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E temp = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return temp;
    }
    
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    
    public int size(){
        return stack.size();
    }
    
    @Override
    public String toString(){
        return stack.toString();
    }
}
