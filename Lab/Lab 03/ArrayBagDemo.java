/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L3;

/**
 *
 * @author tianlongc
 */
public class ArrayBagDemo {
    public static void main(String[] args) {
        BagInterface<String> bag1 = new ArrayBag<>();
        BagInterface<String> bag2 = new ArrayBag<>();
        
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};
        
        // Display the contents
        System.out.println("bag1:");
        testAdd(bag1, contentsOfBag1);
        displayBag(bag1);
        
        System.out.println("bag2:");
        testAdd(bag2, contentsOfBag2);
        displayBag(bag2);
        
        // Test the method union
        BagInterface<String> bag3 = bag1.union(bag2);
        System.out.println("bag3, test the method union of bag1 and bag2:");
        displayBag(bag3);
        
        // Test the method intersection
        BagInterface<String> bag4 = bag1.intersect(bag2);
        System.out.println("bag4, test the method intersection of bag1 and bag2:");
        displayBag(bag4);
        
        // Test the method difference
        BagInterface<String> bag5 = bag1.difference(bag2);
        System.out.println("bag5, test the method difference of bag1 and bag2");
        displayBag(bag5);
        
        // Test the method complement
        BagInterface<String> bag6 = bag1.complement(bag2);
        System.out.println("bag6, test the method complement of bag1 and bag2");
        displayBag(bag6);
        
    }
    
    private static void testAdd(BagInterface<String> aBag, String[] content){
        System.out.print("Adding ");
        for (String element : content) {
            aBag.add(element);
            System.out.print(element + " ");
        }
        System.out.println("");
    }
    
    private static void displayBag(BagInterface<String> aBag){
        System.out.printf("The bag contains %d string(s), as follows:\n", aBag.getCurrentSize());
        
        Object[] bag = aBag.toArray();
        
        for (Object object : bag) {
            System.out.print(object + " ");
        }
        System.out.println("\n");
    }
    
}
