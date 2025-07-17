/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 */
public class Q2 {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();
        
        for (int i = 10; i <= 90; i+=10) {
            q.enqueue(i);
        }
        
        System.out.println("Before: " + q);
        q.ChangeOrder(4);
        System.out.println("After: " + q);
    }
}
