/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L7;

/**
 *
 * @author tianlongc
 */
import java.util.Scanner;

public class L7Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a text: ");
        String text = sc.nextLine();
        
        System.out.printf("%s %s a palindrome.\n", text, isPalindrome(text)? "is":"is not");
        
        sc.close();
    }
    
    public static boolean isPalindrome(String text){
        MyQueue<Character> queue = new MyQueue<>();
        
        // Queue first half only
        for (int i = 0; i < text.length()/2; i++) {
            queue.enqueue(text.charAt(i));
        }
        
        // Start comparing from last to middle (skip middle char if odd length)
        int mid = (text.length() % 2 == 0) ? text.length()/2: text.length()/2 + 1;
        
        for (int i = text.length() - 1; i >= mid; i--) {
            if (queue.dequeue() != text.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
