/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L7;

/**
 *
 * @author tianlongc
 */
public class TestMyQueue {
    public static void main(String[] args) {
        MyQueue<String> fruitQ = new MyQueue<>(new String[]{"Durian", "Blueberry"});
        
        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");
        
        System.out.println("Display the queue.");
        System.out.println(fruitQ);
        
        System.out.println("\nShow the top item.");
        System.out.println(fruitQ.peek());
        
        System.out.println("\nGet the queue size.");
        System.out.println(fruitQ.getSize());
        
        System.out.println("\nDelete Durian.");
        System.out.println(fruitQ.dequeue());
        
        System.out.println("\nGet item in index position of 2.");
        System.out.println(fruitQ.getElement(2));
        
        System.out.println("\nCheck whether the queue consists of Cherry.");
        System.out.println(fruitQ.contains("Cherry"));
        
        System.out.println("\nCheck whether the queue consists of Durian.");
        System.out.println(fruitQ.contains("Durian"));
        
        System.out.println("\nDisplay the queue using the isEmpty() condition.");
        while (!fruitQ.isEmpty()) {
            System.out.print(fruitQ.dequeue() + " ");
        }
        System.out.println("");
    }
}
