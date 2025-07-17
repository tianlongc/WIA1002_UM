/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 * @param <Item> generic type parameter named Item
 */
import java.util.NoSuchElementException;

class Node<Item>{
    Item item;
    Node<Item> next;
    
    public Node(){
        this(null);
    }
    
    public Node(Item item){
        this.item = item;
        this.next = null;
    }
}

public class LinkedList<Item>{
    private Node<Item> head, tail;
    private int size;
    
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public int size(){
        return size;
    }
    
    public Item getFirst(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.item;
    }
    
    public void addLast(Item item){
        Node<Item> newNode = new Node<>(item);
        if (head == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }
    
    public Item removeFirst(){
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item temp = head.item;
        head = head.next;
        this.size--;
        if (head == null) {
            this.tail = null; // in case of head = tail when list is empty
        }
        return temp;
    }
    
    @Override
    public String toString(){
        Node<Item> current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(String.format("%s%s", current.item, current.next != null ? ", ": ""));
            current = current.next;
        }
        return sb.toString();
    }
}
