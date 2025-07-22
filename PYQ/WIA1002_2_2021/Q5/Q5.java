/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q5;

/**
 *
 * @author tianlongc
 */
public class Q5 {
    public static void main(String[] args) {
        System.out.println(permut(5, 5)); // 5!/5! = 5
    }
    
    // This method receives n and r as positive integers
    public static int permut(int n, int r){
        if (n < r)                          // question (a)
            return -1;
        if (n-1>r) 
            return n * permut(n-1, r);      // question (b)
        else
            return n;                       // question (c)
    }
}
