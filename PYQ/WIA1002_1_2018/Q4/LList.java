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

class Node{
    String course;
    int hour;
    Node next;
    
    public Node(){
        this(null, 0);
    }
    
    public Node(String course, int hour){
        this.course = course;
        this.hour = hour;
        this.next = null;
    }
}

public class LList {
    private Node head, tail;
    private int size;
    
    public LList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void add(String course, int hour){
        Node newNode = new Node(course, hour);
        if (head == null) {
            head = tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    public boolean addAfter(String afterNode, String course, int hour){
        if (head == null) {
            throw new NoSuchElementException();
        }
        System.out.println("\nAdding " + course + " after " + afterNode);
        Node newNode = new Node(course, hour);
        
        Node current = head;
        for (int i = 1; current != null; current = current.next, i++) {
            if (current.course.equalsIgnoreCase(afterNode)) {
                System.out.println("Found " + afterNode + " which is book number " + i + " in the linked list");
                newNode.next = current.next;
                current.next = newNode;
                size++;
                return true;
            }
        }
        System.out.println("Course " + course + "not found...");
        return false;
    }
    
    public boolean remove(String course, int hour){
        if (head == null) {
            throw new NoSuchElementException();
        }
        System.out.println("\nRemoving " + course + "..");
        
        Node current = head;
        for (int i = 1; current != null; current = current.next, i++) {
            if (current.next.course.equalsIgnoreCase(course) && current.next.hour == hour) {
                System.out.println("Found a match.. " + course + " is book number " + ++i + " in the linked list");
                current.next = current.next.next;
                size--;
                return true;
            }
        }
        System.out.println("Course" + course + "not found...");
        return false;
    }
    
    public void display(){
        System.out.println("\nDisplay the Linked List " + "*".repeat(60) + "\n");
        for (Node current = head; current != null; current = current.next) {
            System.out.printf("%s: %d hours\n", current.course, current.hour);
        }
    }
    
    public void totalCreditHours(){
        if (head == null) {
            throw new NoSuchElementException();
        }
        int totalCreditHours = 0;
        for(Node current = head; current != null; current = current.next){
            totalCreditHours += current.hour;
        }
        System.out.println("Total credit hours taken: " + totalCreditHours);
    }
}
