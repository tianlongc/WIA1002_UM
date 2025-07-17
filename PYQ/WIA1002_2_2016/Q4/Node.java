/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 */
public class Node{
    int value;
    Node next; // a reference to the next node (pointer)
    
    // No-argument constructor
    public Node(){
        this.value = 0;
        this.next = null;
    }
    
    // Argument constructor
    public Node(int value){
        this.value = value;
        this.next = null; // default value
    }
}
