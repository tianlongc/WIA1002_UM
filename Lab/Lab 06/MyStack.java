/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L6;

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
    
    /* Adds a new element to the top of this stack */
    public void push(E o){
        this.stack.add(o);
    }
    
    /* Returns and removes the top element in this stack */
    public E pop(){
        // Exception handling
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E o = this.stack.get(this.stack.size() - 1);
        this.stack.remove(this.stack.size() - 1);
        return o;
    }
    
    /* Returns the top element in this tack without removing it */
    public E peek(){
        // Exception handling
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stack.get(this.stack.size() - 1);
    }
    
    /* Returns the number of elements in this stack */
    public int getSize(){
        return this.stack.size();
    }
    
    /* Returns true if this stack is empty */
    public boolean isEmpty(){
        return this.stack.isEmpty();
    }
    
    @Override
    public String toString(){
        return this.stack.toString();
    }
    
    /* Returns true if this stack contains the specific element */
    public boolean search(E o){
        return this.stack.contains(o);
    }
    
    /* Returns zero if not found otherwise location number for the found element*/
//    public int indexOf(E o){
//        int index = -1;
//        if (stack.contains(o)) {
//            for (int i = 0; i < stack.size(); i++) {
//                if (stack.get(i).equals(o)) {
//                    return i;
//                }
//            }
//        }
//        return index;
//    }
//      OR
//    public int indexOf(E o){
//        return stack.indexOf(o);
//    }
}
