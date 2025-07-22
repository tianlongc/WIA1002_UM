/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 */
import java.util.Stack;

public class StackApp {
    
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        Integer[] x = { 4, 5, 6, 2, 9, 5, 1, 4, 1, 3};
        for (int i = 0; i < x.length; i++) 
            st.push(x[i]);
        for (int j = 0; j < 3; j++)         // Question (a)
            System.out.print(st.pop());     // 314
        System.out.println();
        System.out.println(st.peek());      // Question (b)
        for (int k = 0; k < 3; k++)         // 1
            st.pop();
        System.out.println(st.pop());       // Question (c)
    }                                       // 2
}
