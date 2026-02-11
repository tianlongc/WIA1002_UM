/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2ex;

/**
 *
 * @author tianlongc
 */

/*
    Question (b): Generate random 10 matric numbers using `String` that consists of 1 Character + 8 Digit 
                  following the format SNNNNNNNN by simulating the queue and priority queue
*/

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Put 1 for the random generated seed (same random output each time)
        Random rd = new Random(1);
        
        GenericCircularQueue<String> q = new GenericCircularQueue<>();
        // Method 1: Use lambda comparator (simplified)
        GenericPriorityQueue<String> pq = new GenericPriorityQueue<>((s1, s2) -> {
            char c1 = s1.charAt(0);
            char c2 = s2.charAt(0);
            // Compare first character
            if (c1 != c2) {
                return Character.compare(c1, c2); // sort alphabetically
            }
            // If alphabets same, compare numeric part
            int n1 = Integer.parseInt(s1.substring(1));
            int n2 = Integer.parseInt(s2.substring(1));
            // sort descending
            return Integer.compare(n2, n1);
        });

        // Method 2: Use anonymous comparator class (traditional)
        // GenericPriorityQueue<String> pq = new GenericPriorityQueue<>(new java.util.Comparator<String>() {
        //     @Override
        //     public int compare(String s1, String s2) {
        //         char c1 = s1.charAt(0);
        //         char c2 = s2.charAt(0);
        //         // Compare first character
        //         if (c1 != c2) {
        //             return Character.compare(c1, c2); // sort alphabetically
        //         }
        //         // If alphabets same, compare numeric part
        //         int n1 = Integer.parseInt(s1.substring(1));
        //         int n2 = Integer.parseInt(s2.substring(1));
        //         // sort descending
        //         return Integer.compare(n2, n1);
        //     }
        // });
        
        /* 
            SAMPLE INPUT 
            - Use the following matric numbers to test your implementation
        */ 
        // String[] matricNumbers = {"P74901557", "Z16435641", "F45975507", "W49879487", "J37378713", 
        //                           "L96353582","L80558031", "H67746522", "C90133794", "B35454922"}; 

        // for (String matricNumber : matricNumbers) {
        //     System.out.println("Random matric number: " + matricNumber);
        //     q.enqueue(matricNumber);
        //     pq.offer(matricNumber);
        // }

        for (int i = 0; i < 10; i++) {
            // ! Take note: Remember to add lower boundary of digits to prevent leading zero or insufficient digits
            String matricNumber = String.format("%c%d", (char)(rd.nextInt(26)+65), rd.nextInt(90000000) + 10000000);
            System.out.println("Random matric number: " + matricNumber);
            q.enqueue(matricNumber);
            pq.offer(matricNumber);
        }
        
        System.out.println("Queue: " + q);
        System.out.println("PriorityQueue: " + pq);
    }
}