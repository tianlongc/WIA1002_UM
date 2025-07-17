/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4ex;

/**
 *
 * @author tianlongc
 * @param <E> generic type parameter named element
 */
public class Node<E>{
    E element;
    Node<E> next;
    
    public Node(){
        this(null);
    }
    
    public Node(E element){
        this.element = element;
        this.next = null;
    }
}
