/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1a;

/**
 *
 * @author tianlongc
 */

/*
    Question: Merge two Singly Linked List by ordering the value in ascending order
              using O(n) time complexity and O(1) space
              - Create a method that return the head of the node L3
                by modifying existing linked list without creating new node
*/
public class Main {
    public static void main(String[] args) {
        SLL L1 = new SLL();
        SLL L2 = new SLL();
        
        L1.addLast(1);
        L1.addLast(20);
        L1.addLast(30);
        
        L2.addLast(10);
        L2.addLast(25);
        L2.addLast(35);
        
        Node headL3 = merge(L1, L2);
        print(headL3);
    }
    
    public static Node merge(SLL L1, SLL L2){
        Node node1 = L1.head;
        Node node2 = L2.head;
        
        Node head;
        // Set head for node3
        if (node1.value <= node2.value) {
            head = node1;
            node1 = node1.next;
        }else{
            head = node2;
            node2 = node2.next;
        }
        Node node3 = head;
        
        while (node1 != null && node2 != null) {
            if (node1.value <= node2.value) {
                node3.next = node1;
                node1 = node1.next;
            }else{
                node3.next = node2;
                node2 = node2.next;
            }
            node3 = node3.next;
        }
        /*
            links the remaining part of the other list directly to the merged list 
            without needing to iterate further
        Assumption: Two sorted list are given
        */
        node3.next = (node1 != null) ? node1 : node2;
        
        return head;
    }
    
    public static void print(Node head){
        for (Node current = head; current != null; current = current.next) {
            System.out.print(current.value + " -> ");
        }
        System.out.println("null");
    }
}
