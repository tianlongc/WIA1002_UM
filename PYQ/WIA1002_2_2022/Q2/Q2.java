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
        // i)
        GenericStack<String> test1 = new GenericStack<>();
        String[] data1 = {"Switch", "Motherboard", "RAM", "SSD", "CPU", "GPU", "Router"};
        for (String data : data1) {
            test1.push(data);
        }
        System.out.println("Original stack: " + test1);
        reverseStack(test1);
        System.out.println("Reversed stack: " + test1);
        
        // ii)
        GenericStack<Integer> test2 = new GenericStack<>();
        Integer[] data2 = {17, 21, 45, 23, 1, 9, 16};
        for (Integer data : data2) {
            test2.push(data);
        }
        System.out.println("\nOriginal stack: " + test2);
        reverseStack(test2);
        System.out.println("Reversed stack: " + test2);
    }
    
    // recursive way to reverse a stack
    public static <E> void reverseStack(GenericStack<E> stack){
        // base case
        if (stack.isEmpty()) {
            return;
        }else{
            E temp = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, temp); // insert top element to bottom
        }
    }
    
    // Helper method to insert bottom
    private static <E> void insertAtBottom(GenericStack<E> stack, E temp){
        if (stack.isEmpty()) {
            stack.push(temp);
        }else{
            E top = stack.pop();
            insertAtBottom(stack, temp); // recursively insert bottom
            stack.push(top);
        }
    }
}
