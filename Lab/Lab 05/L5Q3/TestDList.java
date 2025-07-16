/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L5Q3;

/**
 *
 * @author tianlongc
 */
public class TestDList {
    public static void main(String[] args) {
        DList<Integer> list = new DList<>();
        
        list.addFirst(1);
        list.addLast(10);
        list.addLast(100);
        list.add(2, 2);
        list.remove(3);
        
        System.out.println("");
        list.iterateForward();
        list.iterateBackward();
        System.out.println("size of current Doubly Linked List: " + list.getSize());
        list.clear();
        System.out.println("\nsize of current Doubly Linked List: " + list.getSize());
    }
}
