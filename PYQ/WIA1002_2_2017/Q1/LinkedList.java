/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

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
    
    public void insertFirstLink(String brand, int sales){
        Node newNode = new Node(brand, sales);
        
        if (head == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }
    
    public boolean addAfter(String afterNode, String brand, int sales){
        System.out.println("\nAdding " + brand + " after " + afterNode);
        Node newNode = new Node(brand, sales);
        Node current = head;
        
        for (int i = 1; current != null; i++) {
            if (current.brand.equalsIgnoreCase(afterNode)) {
                System.out.println("Found " + afterNode + " which is handbag number " + i + " in the linked list");
                newNode.next = current.next;
                current.next = newNode;
                this.size++;
                return true;
            }
            current = current.next;   
        }
        return false;
    }
    
    public boolean removeLink(String brand){
        if (head == null) {
            throw new NoSuchElementException();
        }
        System.out.println("\nRemoving " + brand + "..");
        Node current = head;
        
        for (int i = 1; current != null; i++) {
            if (current.next.brand.equalsIgnoreCase(brand)) {
                System.out.println("Found a match.. " + brand + " is handbag number " + (i+1) + " in the linked list");
                current.next = current.next.next;
                this.size--;
                return true;
            }
            current = current.next;   
        }
        return false;
    }
    
    public void display(){
        System.out.println("\nDisplaying the Linked List " + "*".repeat(40));
        Node current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}
