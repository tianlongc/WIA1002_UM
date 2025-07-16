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
import java.util.Arrays;

public class L7bQ2 {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        PriorityQueue<String> queue2 = new PriorityQueue<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));
        
        System.out.println("Priority Queue 1: " + queue);
        System.out.println("Priority Queue 2: " + queue2);
        
        PriorityQueue<String> union = new PriorityQueue<>(queue);
        union.addAll(queue2);
        System.out.println("\nUnion between Priority Queue 1 and Priority Queue 2\n" + union);
        
        PriorityQueue<String> difference = new PriorityQueue<>(queue);
        difference.removeAll(queue2);
        System.out.println("\nDifference between Priority Queue 1 and Priority Queue 2\n" + difference);
        
        PriorityQueue<String> intersection = new PriorityQueue<>(queue);
        intersection.retainAll(queue2);
        System.out.println("\nIntersection between Priority Queue 1 and Priority Queue 2\n" + intersection);
    }
}
