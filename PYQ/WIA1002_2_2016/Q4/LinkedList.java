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

public class LinkedList{
    private Node head, tail;
    private int size;
    
    // Default constructor
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * Insert a new element into the linked list
     * @param e the element
     */
    public void add(int value){
        System.out.println("Adding: " + value);
        Node newNode = new Node(value);    // Create a new node
        
        if (head == null) {
            // If the list is empty, both head and tail will point to this new node
            head = tail = newNode;
        }else{
            // add to the end and update tail
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;
    }
    
    public boolean addAfter(int value, int afterValue){
        System.out.println("Adding: " + value + " after " + afterValue);
        Node newNode = new Node(value);
        Node current = head;

        while (current != null) {
            if (current.value == afterValue) {
                newNode.next = current.next;
                current.next = newNode;
                this.size++;
                return true;
            }
            current = current.next;
        }
        return false; // element not found
    }
    
    public void deleteFront(){
        if (head == null) {
            throw new NoSuchElementException();
        }
        System.out.println("\nDeleting front: " + head.value);
        head = head.next;
        this.size--;
        // If list become empty
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
                System.out.printf("After %d is %d. Deleting %d\n", current.value, current.next.value, current.next.value);
                current.next = current.next.next;
                this.size--;
                return true;
            }
            current = current.next;
        }
        System.out.printf("Element (%d) not found...\n", x);
        return false;
    }
    
    public void traverse(){
        System.out.println("\nShowing content of my linked list:");
        Node current = head;
        
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println("");
    }
}
