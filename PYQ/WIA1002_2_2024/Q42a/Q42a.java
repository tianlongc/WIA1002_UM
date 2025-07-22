/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q42a;

/**
 *
 * @author tianlongc
 */
public class Q42a {
    public static void main(String[] args) {
        SLL<Integer> list1 = new SLL<>();
        CSLL<Integer> list2 = new CSLL<>();
        
        for (int i = 1; i <= 5; i++) {
            list1.addLast(i);
            list2.addLast(i);
        }
        
        System.out.print("Singly Linked List: ");
        list1.printRecursive(list1.head);
        System.out.println("");
        
        System.out.print("Circular Singly Linked List: ");
        list2.printRecursive(list2.head);
        System.out.println("");
    }
}
