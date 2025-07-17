/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 */
import java.util.NoSuchElementException;

public class LinkedList {
    private Node head, tail;
    private int size;
    
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void add(int value){
        System.out.println("Adding: " + value);
        
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public boolean addAfter(int value, int afterNode){
        System.out.println("Adding " + value + " after " + afterNode);
        
        Node newNode = new Node(value);
        Node current = head;
        
        while (current != null) {
            if (current.value == afterNode) {
                newNode.next = current.next;
                current.next = newNode;
                size++;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public void deleteFront(){
        if (head == null) {
            throw new NoSuchElementException();
        }
        System.out.println("\nDeleting front: " + head.value);
        head = head.next;
        size--;
        if (head == null) {
            tail = null; // in case of head = tail
        }
    }
    
    public boolean deleteAfter(int x){
        if (head == null) {
            throw new NoSuchElementException();
        }
        System.out.println("\nTesting deleteAfter:");
        
        Node current = head;
        
        while (current != null) {
            if (current.value == x) {
                System.out.println("After " + x + " is " + current.next.value + ". Deleting " + current.next.value);
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        System.out.printf("Element (%d) not found...\n", x);
        return false;
    }
    
    public void traverse(){
        System.out.println("\nShowing content of my linked list:");
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.value + " ");
        }
        System.out.println("");
    }
}
