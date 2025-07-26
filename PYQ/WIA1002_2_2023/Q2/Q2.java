/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 */

/*
    Constraints: Single digit positive integers
    Output can be real numbers --> Use Double data type
    Assume the inputs from the users are always valid arithmetic expressions
    and users will not provide expressions that involve division by 0
*/

import Q1.ExamStack;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter expression to evaluate : ");
        String expression = sc.nextLine();
        
        System.out.println(expression + " = " + solve(expression));
        
        sc.close();
    }
    
    public static double solve(String expression){
        // wrap expression with parentheses to trigger full evaluation
        expression = "(" + expression + ")";
        
        ExamStack<Character> operators = new ExamStack<>();
        ExamStack<Double> operands = new ExamStack<>();
        
        for (char c: expression.toCharArray()) {
            if (c == '(') {
                operators.push(c);
            }else if (c == ')'){ // solve entire brace
                // Note: (operators.getSize()==0) means isEmpty() method
                while (!(operators.getSize()==0) && operators.peep() != '(') {
                    compute(operators, operands);
                }
                operators.pop();
            }else if(Character.isDigit(c)){
                operands.push((double)Character.getNumericValue(c));
            }else{ // operator case
                // operators.peep() != '(' to ensure operators inside parentheses are evaluated after the matching ')'
                while (!(operators.getSize()==0) && operators.peep() != '(' && (getPrecedence(operators.peep()) >= getPrecedence(c))) {
                    compute(operators, operands);
                }
                operators.push(c);
            }
        }
        // Apply remaining operators to remaining values after parsing entire expression
        // Ignore these if you wrap the entire expression with parentheses
//        while (operators.getSize() != 0) {
//            compute(operators, operands);
//        }
        return operands.pop(); // the last remaining is the result
    }
    
    // Helper method to compute the result
    private static void compute(ExamStack<Character> operators, ExamStack<Double> operands){
        double b = operands.pop(); 
        double a = operands.pop();
        char op = operators.pop();
        
        // first operand a get pushed first and popped second
        // second operand b get pushed last and popped first
        // follows LIFO
        // a op b = c
        double c;
        
        switch (op) {
            case '+' -> c = a + b;
            case '-' -> c = a - b;
            case '*' -> c = a * b;
            case '/' -> {if (b==0) throw new ArithmeticException("Division by zero"); // exception can ignore
                            else c = a/b;}
            default -> throw new IllegalArgumentException("Invalid operator: " + op);
        }
        operands.push(c); // push the result into the stack
    }
    
    // Helper method to determine precedence
    private static int getPrecedence(char op){
        return (op == '*' || op == '/') ? 2:1;
    }
}
