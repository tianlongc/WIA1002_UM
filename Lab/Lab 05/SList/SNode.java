/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SList;

/**
 *
 * @author tianlongc
 * @param <E> generic parameter type named element
 */
public class SNode<E>{
    E element;
    SNode<E> next; // pointer
    
    // default constructor
    public SNode(){
        this.element = null;
        this.next = null;
    }
    
    // Argument constructor
    public SNode(E element){
        this.element = element;
        this.next = null;        
    }
}
