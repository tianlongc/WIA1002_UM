/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q41b;

/**
 *
 * @author tianlongc
 */
import java.util.Stack;

public class MyStack {
    private Stack<Customer> stack;
    
    public MyStack(){
        this.stack = new Stack<>();
    }
    
    public void push(Customer element){
        this.stack.push(element);
    }
    
    public Customer pop(){
        return stack.isEmpty() ? null : stack.pop();
    }
    
    public Customer peek(){
        return stack.isEmpty() ? null : stack.peek();
    }
    
    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
