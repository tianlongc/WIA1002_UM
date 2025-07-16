/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L7b;

/**
 *
 * @author tianlongc
 */
import java.util.PriorityQueue;
import java.util.Collections;

public class L7bQ1{
    public static void main(String[] args) {
        Integer[] arr = {4, 8, 1, 2, 9, 6, 3, 7};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (Integer integer : arr) {
            queue.offer(integer);
        }
        
        System.out.println("Display all the elements inside this priority queue");
        System.out.println(queue);
        
        System.out.println("\nRetrieve and remove the first element in this priority queue");
        System.out.println(queue.poll());
        
        System.out.println("\nAdd new element 5 into the priority queue");
        queue.add(5);
        
        System.out.println("\nConvert the priority queue into an array and display");
        for (Object element : queue.toArray()) {
            System.out.print(element + " ");
        }
        System.out.println("");
        
        System.out.println("\nRetrieve the first element in the priority queue");
        System.out.println(queue.peek());
        
        System.out.println("\nCheck if the priority queue consists of element \"1\"");
        System.out.println(queue.contains(1));
        
        System.out.println("\nGet the current size of the priority queue");
        System.out.println(queue.size());
        
        System.out.println("\nDisplay while removing the elements in the queue until it is empty");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println("");
        
        System.out.println("\nSort the priority queue in reversing order");
        PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (Integer integer : arr) {
            queue2.offer(integer);
        }
        System.out.println(queue2);
    }
}
