/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author tianlongc
 */
public class Q1 {
    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        MyLinkedList<Integer> newList = new MyLinkedList<>();
        
        Integer[] arr1 = {2, 10, 38, 41, 51};
        Integer[] arr2 = {5, 12, 18, 21, 35, 41, 56};
        
        // Test addFirst method
        for (int i = arr1.length-1; i >= 0 ; i--) {
            list1.addFirst(arr1[i]);
        }
        System.out.println(list1);
        for (int i = arr2.length-1; i >= 0 ; i--) {
            list2.addFirst(arr2[i]);
        }
        System.out.println(list2);
        
        System.out.println("The newList is:");
        newList = combine(list1, list2);
        System.out.println(newList);
    }
    
    public static <E extends Comparable<E>> MyLinkedList<E> combine(MyLinkedList<E> list1, MyLinkedList<E> list2){
        MyLinkedList<E> newList = new MyLinkedList<>();
        E element1 = list1.removeFirst();
        E element2 = list2.removeFirst();
        
        // Since both of the list are sorted
        while (element1 != null && element2 != null) {
            if (element1.compareTo(element2) < 0) {
                newList.addLast(element1);
                element1 = list1.removeFirst();
            }else{
                newList.addLast(element2);
                element2 = list2.removeFirst();
            }
        }
        
        // Handle two list with different length or size of linked list
        // (Handles remaining elements)
        while (element1 != null) {
            newList.addLast(element1);
            element1 = list1.removeFirst();
        }
        while (element2 != null) {
            newList.addLast(element2);
            element2 = list2.removeFirst();
        }
        return newList;
    } 
}
