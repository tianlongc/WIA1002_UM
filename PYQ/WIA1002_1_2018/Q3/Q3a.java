/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 */
public class Q3a {
    public static void main(String[] args) {
        
        StackTest stack1 = new StackTest(4);
        stack1.push("one");
        stack1.push("two");
        stack1.push("three");
        stack1.push("four");
        stack1.displayInReverse();
        stack1.popAll();
        stack1.displayInReverse();
    }
}
