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

public class TestIntMyStack {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter an integer value: ");
        int n = sc.nextInt();
        
        for (int i = 1; i <= n; i++) {
            stack.push(i);
        }
        
        System.out.println("Size of the stack: " + stack.getSize());
        
        System.out.println("Display the contents of the stack");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println("");
        
        /**
         * Example input = 5
         * Output: 5 4 3 2 1
         * 
         * Why This Order?
         * Stack follows Last In, First Out (LIFO) fashion
         * When we executed the pop() function, the topmost element is removed first
         * --> 5 is pushed last (at the top)and 1 is pushed first (at the bottom)
         * which is 5 first followed by 4 3 2 and until 1.
         */
        
        sc.close();
    }
}
