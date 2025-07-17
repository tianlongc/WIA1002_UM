/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 */
public class Q3b {
    public static void main(String[] args) {
        
        StackWithGeneric<String> stack1 = new StackWithGeneric<String>(4);
        stack1.push("one");
        stack1.push("two");
        stack1.push("three");
        stack1.push("four");
        System.out.println(stack1.peek());
        stack1.display();
        stack1.displayInReverse();
        stack1.popAll();
        
        StackWithGeneric<Integer> stack2 = new StackWithGeneric<Integer>(4);
        stack2.push(100);
        stack2.push(200);
        stack2.push(300);
        stack2.push(400);
        System.out.println(stack2.peek());
        stack2.display();
        stack2.displayInReverse();
        stack2.popAll();
    }
}
