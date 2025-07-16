/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L4;

/**
 *
 * @author tianlongc
 */
public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();
        
        char[] letters = {'a','b','c','d','e'};
        // a
        for (char letter : letters) {
            list.addLast(letter);
        }
        // b
        System.out.println("Print all the elements in the list:");
        list.print();
        // c
        System.out.println("\nReverse all the elements in the list:");
        list.reverse();
        // d
        System.out.println("\nRetrieve the number of elements in the list:");
        System.out.println(list.size());
        // e
        System.out.println("\nRetrieve the first and last value:");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        // f
        System.out.println("\nDelete the third value:");
        System.out.println(list.remove(2));
        list.print();
        // g
        System.out.println("\nRetrieve the index location for the second and third value:");
        System.out.println(list.indexOf('b'));
        System.out.println(list.indexOf('c'));
        // h
        System.out.println("\nChecks if the list has the value 'c':");
        System.out.println(list.contains('c'));
        // i
        System.out.println("\nReplace the items individually with the following: j,a,v,a:");
        list.set(0, 'j');
        list.set(1, 'a');
        list.set(2, 'v');
        list.set(3, 'a');
        list.print();
        
        System.out.println("\nMiddle value: " + list.getMiddleValue());
    }
}
