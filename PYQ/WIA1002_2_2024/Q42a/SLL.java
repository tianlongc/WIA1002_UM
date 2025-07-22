/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q42a;

/**
 *
 * @author tianlongc
 */
public class SLL<E>{
    protected Node<E> head, tail;
    private int size;
    
    public SLL(){
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
        size++;
    }
    
    public void printRecursive(Node<E> current){
        if (current == null) {
            return; // base case
        }
        System.out.print(current.element + " ");
        printRecursive(current.next);
    }
}
