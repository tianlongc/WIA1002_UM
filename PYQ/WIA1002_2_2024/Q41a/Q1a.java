/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q41a;

/**
 *
 * @author tianlongc
 */
class Node{
    int data;
    Node prev;
    Node next;
    
    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList{
    Node head;
    Node tail;
    
    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }
    
    void append(int data){
        // append method adds a new node with the given data to the end of the doubly linked list.
        // Your implementation here
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    
    void removeThreeElements(Node startNode){
        /**
         * Removes three consecutive elements starting from the given node
         * If fewer than three elements remain, removes all remaining elements.
         * @param startNode The starting node from which to remove elements.
         */
        // Your implementation here
        Node current = startNode;
        for (int i = 0; i < 3 && current != null; i++) {
            Node nextNode = current.next; // save next node before modifying
            // Case 1: current is head
            if (current.prev == null) {
                head = current.next;
                if (head != null) {
                    head.prev = null;
                }
            }else{
                current.prev.next = current.next;
            }
            // Case 2: current is tail
            if (current.next == null) {
                tail = current.prev;
            }else{
                current.next.prev = current.prev;
            }
            // dereference
            current.prev = null;
            current.next = null;
            
            current = nextNode;
        }
    }
    
    void display(){
        // Your implementation here
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.data + " ");
        }
        System.out.println("");
    }
}

public class Q1a {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        
        dll.append(1);
        dll.append(2);
        dll.append(3);
        dll.append(4);
        dll.append(5);
        dll.append(6);
        dll.append(7);
        dll.append(8);
        dll.append(9);
        
        dll.display(); // Output: 1 2 3 4 5 6 7 8 9
        dll.removeThreeElements(dll.head.next); // Remove elements starting from the second node
        dll.display(); // Output: 1 5 6 7 8 9
    }
}
