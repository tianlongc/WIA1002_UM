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
    Question (c): Generate random combination of 1 Character + 8 Digit follow the format SNNNNNNNN
                  by stimulating the queue and priority queue
*/

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Put 1 for the random generated seed (same random output each time)
        Random rd = new Random(1);
        
        GenericCircularQueue<String> q = new GenericCircularQueue<>();
        GenericPriorityQueue<String> pq = new GenericPriorityQueue<>();
        
        for (int i = 0; i < 10; i++) {
            // ! Take note: Remember to add lower boundary of digits to prevent leading zero or insufficient digits
            String matricNumber = String.format("%c%d", (char)rd.nextInt(26)+65, rd.nextInt(90000000) + 10000000);
            System.out.println("Matric Number: " + matricNumber);
            q.enqueue(matricNumber);
            pq.enqueue(matricNumber);
        }
        System.out.println("Queue: " + q);
        System.out.println("Priority Queue: " + pq);
    }
}
