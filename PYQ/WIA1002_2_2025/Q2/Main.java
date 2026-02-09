/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

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
        GenericPriorityQueue<String> pq = new GenericPriorityQueue<>();
        
        /* 
            SAMPLE INPUT 
            - Use the following matric numbers to test your implementation
        */ 
        // String[] matricNumbers = {"P74901557", "Z16435641", "F45975507", "W49879487", "J37378713", 
        //                           "L96353582","L80558031", "H67746522", "C90133794", "B35454922"}; 

        // for (String matricNumber : matricNumbers) {
        //     System.out.println("Random matric number: " + matricNumber);
        //     q.enqueue(matricNumber);
        //     pq.enqueue(matricNumber);
        // }

        for (int i = 0; i < 10; i++) {
            // ! Take note: Remember to add lower boundary of digits to prevent leading zero or insufficient digits
            String matricNumber = String.format("%c%d", (char)(rd.nextInt(26)+65), rd.nextInt(90000000) + 10000000);
            System.out.println("Random matric number: " + matricNumber);
            q.enqueue(matricNumber);
            pq.enqueue(matricNumber);
        }
        
        System.out.println("Queue: " + q);
        System.out.println("PriorityQueue: " + pq);
    }
}
