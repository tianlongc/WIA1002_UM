/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1a;

/**
 *
 * @author tianlongc
 */
public class Node {
    int value;
    Node next;
    
    public Node(){
        this(0);
    }
    
    public Node(int value){
        this.value = value;
        this.next = null;
    }
}
