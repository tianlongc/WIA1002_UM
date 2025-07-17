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
import java.util.NoSuchElementException;

public class LinkedList<E>{
    Node<E> head, tail;
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
    
    public E removeFirst(){
        if (size == 0) {
            throw new NoSuchElementException();
        }else{
            Node<E> temp = head;
            head = head.next;
            this.size--;
            if (head == null) {
                this.tail = null; // in case of head = tail when list is empty
            }
            return temp.element;
        }
    }
    
    public E get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index " + index + "(size: " + size + ")");
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }
    
//    public E getFirst(){
//        if (size == 0) {
//            throw new NoSuchElementException();
//        }
//        return head.element;
//    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        sb.append("[");
        while (current != null) {
            sb.append(String.format("%s%s", current.element, current.next != null ? ", ": ""));
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
