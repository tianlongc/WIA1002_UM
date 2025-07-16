/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L9;

/**
 *
 * @author tianlongc
 */
public class L9Q3 {
    public static void main(String[] args) {
        System.out.println("10^3 = " + exponent(10,3));
    }
    
    public static long exponent(int x, int m){
        // Base case: Handles x^0 = 1
        if (m == 0) {
            return 1;
        }
        // Recursive case: multiply x by the result of x^(m-1)
        return x * exponent(x, m-1);
    }
}
