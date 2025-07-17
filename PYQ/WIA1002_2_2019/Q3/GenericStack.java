/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 * @param <E> the generic type parameter named element
 * Use Linked list generic stack since no size limitation
 */
class Node<E>{
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

public class GenericStack<E>{
    private Node<E> top; // actually no need head or tail node
    private int size;
    
    public GenericStack(){
        this.top = null;
        this.size = 0;
    }
    
    public void push(E e){
        Node<E> newNode = new Node<>(e);
        newNode.next = top;
        top = newNode;
        size++;
    }
    
    public E pop(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        E temp = top.element;
        top = top.next;
        size--;
        return temp;
    }
    
    public E peek(){
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow");
        }
        return top.element;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public int size(){
        return size;
    }
}
