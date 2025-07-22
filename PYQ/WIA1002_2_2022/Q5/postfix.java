/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q5;

/**
 *
 * @author tianlongc
 */
import java.util.Stack;

public class postfix {
    public static void main(String[] args) {
        
        String[] expressions = {"a+b-c*(d/e)", "a/b-c*(d+e)", "a*b+c*d/e-f+(g-h)"};
        
        for (String expression : expressions) {
            System.out.println(solve(expression));
        }
    }
    
    public static String solve(String expression){
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        
        for (char token : expression.toCharArray()) {
            if (token == '(') {
                stack.push(token);
            }else if (token == ')'){
                while (!stack.isEmpty() && !(stack.peek() == '(')) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop();
            }else if (Character.isLetter(token)) {
                postfix.append(token).append(" ");
            }else{ // operator case
                while (!stack.isEmpty() && !(stack.peek() == '(') && getPrecedence(stack.peek()) >= getPrecedence(token)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }
        // Handle remaining operators from stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }
        return postfix.toString();
    }
    
    private static int getPrecedence(char op){
        return (op == '*' || op == '/') ? 2:1;
    }
}
