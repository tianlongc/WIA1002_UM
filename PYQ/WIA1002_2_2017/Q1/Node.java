/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author tianlongc
 */
public class Node{
    String brand;
    int sales;
    Node next;
    
    // Default constructor
    public Node(){
        this(null, 0);
    }
    
    // Argument constructor
    public Node(String brand, int sales){
        this.brand = brand;
        this.sales = sales;
        this.next = null;
    }
    
    @Override
    public String toString(){
        return String.format("%s: %,d Sold", brand, sales);
    }
}
