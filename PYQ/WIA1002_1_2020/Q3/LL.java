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

public class LL {
    private Node head, tail;
    private int size;
    
    public LL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    static class Node{
        String bookName;
        int sales;
        Node next;
        
        public Node(){
            this(null, 0);
        }
        
        public Node(String bookName, int sales){
            this.bookName = bookName;
            this.sales = sales;
            this.next = null;
        }
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void add(String bookName, int sales){
        Node newNode = new Node(bookName, sales);
        if (head == null) {
            head = tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    public boolean addAfter(String afterNode, String bookName, int sales){
        System.out.println("Adding " + bookName + " after " + afterNode);
        Node newNode = new Node(bookName, sales);
        Node current = head;
        for (int i = 1; current != null; current = current.next,i++) {
            if (current.bookName.equalsIgnoreCase(afterNode)) {
                System.out.printf("Found %s which is book number %d in the linked list\n", afterNode, i);
                newNode.next = current.next;
                current.next = newNode;
                size++;
                return true;
            }
        }
        return false;
    }
    
    public boolean remove(String bookName){
        if (head == null) {
            throw new NoSuchElementException();
        }
        System.out.println("\nRemoving " + bookName + "..");
        Node current = head;
        if (current.bookName.equalsIgnoreCase(bookName)) {
            System.out.printf("%s is the first book. Removing %s from the linked list\n", bookName, bookName);
            head = head.next;
            size--;
            return true;
        } 
        for (int i = 0; current != null; current = current.next, i++) {
            if (current.next != null && current.next.bookName.equalsIgnoreCase(bookName)) {
                System.out.printf("Found %s which is book number %d. Removing %s from the linked list\n", bookName, ++i, bookName);
                current.next = current.next.next;
                size--;
                return true;
            }
        }
        System.out.println("Couldn't find bookname..");
        return false;
    }
    
    public void display(){
        System.out.println("\nDisplaying the Linked List " + "*".repeat(40) + "\n");
        for (Node current = head; current != null; current = current.next) {
            System.out.printf("%s: %,d Sold\n", current.bookName, current.sales);
        }
        System.out.println("");
    }
    
    public void totalSold(){
        
    }
    
    public static void main(String[] args) {
        LL myLL = new LL();
        
        myLL.add("Lord of The Rings", 500000000);
        myLL.add("Tale of the Body Thief", 1000000);
        myLL.add("Memnoch the Devil", 100000000);
        myLL.add("Heart of a Samurai", 10000000);
        myLL.display();
        myLL.addAfter("Memnoch the Devil", "White Crane", 10000000);
        myLL.display();
        myLL.addAfter("White Crane", "Memoirs of Geisha", 90000000);
        myLL.display();
        myLL.remove("Harry Potter");
        myLL.remove("Heart of a Samurai");
        myLL.display();
    }
}
