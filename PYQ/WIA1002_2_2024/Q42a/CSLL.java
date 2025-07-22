/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q42a;

/**
 *
 * @author tianlongc
 */
public class CSLL<E>{
    protected Node<E> head, tail;
    private int size;
    
    public CSLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        tail.next = head; // maintain circularity
        size++;
    }
    
    public void printRecursive(Node<E> current){
        // think Circular Linked List as a Do-while loop
        if (current == null) {
            return; // base case 1: empty list
        }
        System.out.print(current.element + " ");
        if (current.next == head) {
            return; // base case 2: return to starting node
        }
        printRecursive(current.next);
    }
}
