/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L5Q2;

/**
 *
 * @author tianlongc
 * @param <E> generic parameter type named element
 */
import java.util.NoSuchElementException;

public class SList<E>{
    private SNode<E> head, tail;
    private int size;
    
    public SList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void add(E e){
        SNode<E> newNode = new SNode<>(e); // Create a new node
        
        if (tail == null) {
            head = tail = newNode; // The only node in list
        }else{
            tail.next = newNode; // Link the new node with the last node
            tail = newNode; // tail points to last node
        }
        size++;
    }
    
    public void removeElement(E e){
        if (size == 0) {
            throw new NoSuchElementException("No elements in the list!");
        }else{
            // Case 1: Remove head
            if (head.element.equals(e)) {
                head = head.next;
                size--;
                return;
            }
            
            // Case 2: Remove middle or end
            SNode<E> current = head;
            
            while (current != null) {
                if (current.next.element.equals(e)) {
                    // Remove current.next by linking current to current.next.next 
                    // (garbage collection handles the deleted node)  
                    current.next = current.next.next;
                    size--;
                    return;
                }
                current = current.next;
            }
            throw new NoSuchElementException(e + "is not found in the list!");
        }
    }
    
    public void printList(){
        SNode<E> current = head;
        
        while (current != null) {
            System.out.printf("%s%s", current.element, (current.next != null) ? ", ":".\n");
            current = current.next;
        }
    }
    
    public int getSize(){
        return size;
    }
    
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
    
    public void replace(E e, E newE){
        SNode<E> current = head;
        
        while (current != null) {
            if (current.element.equals(e)) {
                current.element = newE;
                return;
            }
            current = current.next;
        }
        throw new NoSuchElementException(e + "is not found in the list!");
    }
}
