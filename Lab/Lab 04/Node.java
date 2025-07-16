/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L4;

/**
 *
 * @author tianlongc
 */
public class Node<E> {
    E element;      // contains the element
    Node<E> next;   // a reference to the next node (pointer)
    
    // No-argument constructor
    public Node(){
        this.element = null;
        this.next = null;
    }
    
    // Argument constructor
    public Node(E element){
        this.element = element;
        this.next = null; // default value
    }
}
