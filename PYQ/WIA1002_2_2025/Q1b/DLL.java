/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1b;

/**
 *
 * @author tianlongc
 */
public class DLL {
    private Node head, tail;
    private int size;
    
    public DLL(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void addLast(char letter){
        Node newNode = new Node(letter);
        
        if (head == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    public boolean isPalindrome(){
        // Without modifying the head and tail
        Node left = head;
        Node right = tail;
        
        for (int i = 0; i < size/2; i++) {
            if (left.letter != right.letter) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }
        return true;
    }
}
