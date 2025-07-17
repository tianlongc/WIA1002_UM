/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 */
import java.util.NoSuchElementException;

class Node{
    String course;
    int creditHour;
    Node next;
    
    public Node(){
        this(null, 0);
    }
    
    public Node(String course, int creditHour){
        this.course = course;
        this.creditHour = creditHour;
        this.next = null;
    }
}

public class LinkedList {
    private Node head, tail;
    private int size;
    
    public LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void add(String course, int creditHour){
        Node newNode = new Node(course, creditHour);
        if (head == null) {
            head = tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    public boolean addAfter(String afterNode, String course, int creditHour){
        Node newNode = new Node(course, creditHour);
        for (Node current = head; current != null; current = current.next) {
            if (current.course.equalsIgnoreCase(afterNode)) {
                System.out.println("\nAdding " + course + " after " + afterNode);
                newNode.next = current.next;
                current.next = newNode;
                size++;
                return true;
            }
        }
        return false;
    }
    
    public boolean remove(String course, int creditHour){
        for (Node current = head; current != null; current = current.next) {
            if (current.next.course.equalsIgnoreCase(course) && current.next.creditHour == creditHour) {
                System.out.println("\nRemoving " + course + "..");
                current.next = current.next.next;
                size--;
                return true;
            }
        }
        System.out.println("Course " + course + " not found...");
        return false;
    }
    
    public void display(){
        System.out.println("\nDisplay the Linked List " + "-".repeat(60) + "\n");
        for (Node current = head; current != null; current = current.next) {
            System.out.printf("%s: %d hours\n", current.course, current.creditHour);
        }
    }
    
    public void totalCreditHours(){
        if (head == null) {
            throw new NoSuchElementException();
        }
        int totalCreditHours = 0;
        for (Node current = head; current != null; current = current.next) {
            totalCreditHours += current.creditHour;
        }
        System.out.println("\nTotal credit hours: " + totalCreditHours);
    }
    
    public static void main(String[] args) {
        
        LinkedList list = new LinkedList();
        
        list.add("Computing Mathematics", 3);
        list.add("Network Architecture", 3);
        list.add("Final Year Project", 5);
        list.add("Data Structure", 5);
        list.display();
        list.totalCreditHours();
        list.addAfter("Final Year Project", "Software Modelling", 4);
        list.addAfter("Software Modelling", "Intelligent Robot", 3);
        list.addAfter("Computing Mathematics", "Gamification", 4);
        list.totalCreditHours();
        list.remove("Network Architecture", 3);
        list.remove("Software Modelling", 4);
        list.display();
        list.totalCreditHours();
    }
}
