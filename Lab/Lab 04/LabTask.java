/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L4;

/**
 *
 * @author tianlongc
 */
public class LabTask {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addLast("n1");
        list.addLast("n2");
        list.addLast("n3");
        
        System.out.println("Original:");
        list.print();
        
        System.out.println("Reversed:");
        list.reverseLinkedList();
        list.print();
    }
}
