/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 */
public class Q4 {
    public static void main(String[] args) {
        LinkedList sl = new LinkedList();
        
        sl.add(10);
        sl.add(20);
        sl.add(30);
        sl.add(40);
        sl.add(50);
        sl.addAfter(11, 10);
        sl.addAfter(21, 20);
        sl.addAfter(31, 30);
        sl.addAfter(41, 40);
        sl.addAfter(51, 50);
        sl.traverse();
        sl.deleteFront();
        sl.deleteFront();
        sl.traverse();
        sl.deleteAfter(40);
        sl.deleteAfter(40);
        sl.deleteAfter(31);
        sl.deleteAfter(40);
        sl.traverse();
    }
}
