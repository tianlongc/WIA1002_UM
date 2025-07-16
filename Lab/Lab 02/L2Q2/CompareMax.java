/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L2Q2;

/**
 *
 * @author tianlongc
 */
public class CompareMax {
    public static <T extends Comparable<T>> T maximum(T a, T b, T c){
        T max = a;
        
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(maximum(1, 2, 3));
        System.out.println(maximum("a", "b", "c"));
    }
}
