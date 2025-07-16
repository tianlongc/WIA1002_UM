/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SList;

import java.util.NoSuchElementException;

/**
 *
 * @author tianlongc
 * @param <E> generic parameter type named element
 */
public class SList<E>{
    private SNode<E> head, tail;
    private int size;
    
    // Default constructor
    public SList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * Append a new element at the end of the list
     * @param e the element to be added to the list
     */
    public void appendEnd(E e){
        SNode<E> newNode = new SNode<>(e); // Create a new node
        
        if (tail == null) {
            head = tail = newNode; // The only node in list
        }else{
            tail.next = newNode; // Link the new node with the last node
            tail = newNode; // tail points to last node
        }
        size++;
    }
    
    /**
     * Eliminate the first element in the list
     * @return the deleted first element
     * @throws NoSuchElementException if there's no element
     */
    public E removeInitial(){
        if (size == 0) {
            throw new NoSuchElementException("There is no elements in the list!");
        }
        SNode<E> temp = head;
        head = head.next;
        this.size--;
        if (head == null) {
            tail = null; // in case of head = tail
        }
        return temp.element;
    }
    
    /**
     * Search for an element and returns true if this list contains the searched element
     * @param e the searched element
     * @return true if the list contains the searched element otherwise false
     */
    public boolean contains(E e){
        SNode<E> current = head;
        
        while (current != null) {
            if (current.element.equals(e)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Empty all elements in the list and return a statement that reports that the list is empty.
     */
    public void clear(){
        // Unreferenced nodes will be garbage collected
        // Assumption: No other references to them exist.
        head = tail = null;
        size = 0;
//        while (size > 0) {
//            removeInitial();
//        }
        System.out.println("The list is empty.");
    }
    
    /**
     * Display all values from the list in a successive order.
     */
    public void display(){
        SNode<E> current = head;
        
        while (current != null) {
            System.out.printf(current.element + "%s", (current.next != null ? ", ":"\n"));
            current = current.next;
        }
    }
}
