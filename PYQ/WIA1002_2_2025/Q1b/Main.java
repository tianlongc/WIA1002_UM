/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1b;

/**
 *
 * @author tianlongc
 */
/*
    Question: Use Doubly Linked List to determine whether 
              the input text is palindrome or not
    Sample Input  1: rotator
    Sample Output 1: Is Palindrome? true
    Sample Input  2: racecar
    Sample Output 2: Is Palindrome? true
    Sample Input  3: book
    Sample Output 3: Is Palindrome? false
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL list = new DLL();
        
        System.out.print("Enter input string: ");
        String text = sc.nextLine();
        
        for (int i = 0; i < text.length(); i++) {
            list.addLast(text.charAt(i));
        }
        
        System.out.println("Is Palindrome? " + list.isPalindrome());
        
        sc.close();
    }
}
