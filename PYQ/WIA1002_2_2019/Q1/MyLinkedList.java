/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author tianlongc
 * @param <E> the generic type parameter named element
 */
public class MyLinkedList<E>{
    private Node<E> head, tail;
    private int size;
    
    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public int getSize(){
        return size;
    }
    
    public void addFirst(E e){
        Node<E> newNode = new Node(e);
        if (head == null) {
            head = tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    public void addLast(E e){
        Node<E> newNode = new Node(e);
        if (tail == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public E removeFirst(){
        if (head == null) {
            return null;
        }
        Node<E> temp = head;
        head = head.next;
        size--;
        return temp.element;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Node<E> current = head; current != null; current = current.next) {
            sb.append(String.format("%s%s", current.element, current.next != null ? " >> ": ""));
        }
        return String.format("[size=%d] >> %s", size, sb.toString());
    }
}
