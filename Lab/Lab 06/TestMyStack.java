/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L6;

/**
 *
 * @author tianlongc
 */
public class TestMyStack {
    public static void main(String[] args) {
        MyStack<Character> stack = new MyStack<>();
        
        stack.push('a');
        stack.push('b');
        stack.push('c');
        
        System.out.println(stack);
        
        System.out.println("\nCheck if element 'b' is in the stack: " + stack.search('b'));
        System.out.println("\nCheck if element 'k' is in the stack: " + stack.search('k'));
        
        MyStack<Integer> stack2 = new MyStack<>();
        
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        
        System.out.println("\n" + stack2);
        
        System.out.println("\nCheck if element '6' is in the stack: " + stack2.search(6));
    }
}
