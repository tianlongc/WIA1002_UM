/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1a;

/**
 *
 * @author tianlongc
 */
public class SLL {
    Node head, tail;
    private int size;
    
    public SLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void addLast(int value){
        Node newNode = new Node(value);
        if (head == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
}
