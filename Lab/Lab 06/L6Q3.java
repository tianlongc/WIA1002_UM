/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L6;

/**
 *
 * @author tianlongc
 */
public class L6Q3 {
    public static void main(String[] args) {
        MyStack<Integer> S = new MyStack<>();
        
        for (int i = 0; i < 10; i++) {
            S.push(i);
        }
        
        System.out.println("Sum of every element in S: " + sum(S));
        System.out.println(S);
    }
    
    public static int sum(MyStack<Integer> stack){
        int sum = 0;
        MyStack<Integer> temp = new MyStack<>();
        
        // Pop all elements from S, add to sum and push to temp
        while (!stack.isEmpty()) {
            int element = stack.pop();
            sum += element;
            temp.push(element);
        }
        
        // Restore the stack
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        
        return sum;
    }
}
