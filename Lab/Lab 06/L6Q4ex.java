/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L6;

/**
 *
 * @author tianlongc
 */
import java.util.Scanner;
import java.util.Stack;

public class L6Q4ex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = sc.nextLine().toLowerCase(); // Standardize the text input
        
        System.out.printf("%s %s a palindrome.\n", text, isPalindrome(text)? "is":"is not");
        
        sc.close();
    }
    
    public static boolean isPalindrome(String text){
        if (text.length() > 15) {
            throw new IllegalArgumentException("String exceeds 15 characters!");
        }
        
        Stack<Character> stack = new Stack<>();
        
        // Push first half only
        for (int i = 0; i < text.length()/2; i++) {
            stack.push(text.charAt(i));
        }
        
        // Start comparing from middle (skip middle char if odd length)
        int mid = (text.length() % 2 == 0) ? text.length()/2 :text.length()/2 + 1;
        
        for (int i = mid; i < text.length(); i++) {
            if (stack.pop() != text.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
