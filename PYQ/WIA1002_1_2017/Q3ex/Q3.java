/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3ex;

/**
 *
 * @author tianlongc
 */
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        
        System.out.print("input: ");
        String text = sc.nextLine();
        
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }
        System.out.print("output: ");
        while (!stack.isStackEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println("");
        
        sc.close();
    }
}
