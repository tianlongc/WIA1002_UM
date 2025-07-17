/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3ex;

/**
 *
 * @author tianlongc
 * @param <E> generic type parameter named element
 */
import java.util.NoSuchElementException;

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

public class LinkedList<E>{
    private Node<E> head, tail;
    private int size;
    
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }
    
    public E getLast(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return tail.element;
    }
    
    public E removeLast(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> current = head;
        for (int i = 0; i < size-2; i++) {
            current = current.next;
        }
        E temp = tail.element;
        tail = current;
        tail.next = null;
        this.size--;
        return temp;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
}
