/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L5Q3;

/**
 *
 * @author tianlongc
 * @param <E> generic type parameter named element
 */
public class DNode<E>{
    E element;
    DNode<E> next;
    DNode<E> prev;
    
    public DNode(E element, DNode next, DNode prev){
        this.element = element;
        this.next = next;
        this.prev = prev;
    }
    
    public DNode(E element){
        this(element, null, null); // calls 3 argument constructor
    }
}
