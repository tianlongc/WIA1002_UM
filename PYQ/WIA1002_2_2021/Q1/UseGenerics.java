/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author tianlongc
 */
public class UseGenerics<T extends Comparable<T>>{ // question (a)
    private T a;
    
    public UseGenerics(T p, T q){   // question (b)
        if (p.compareTo(q) > 0) 
            a = p;
        else
            a = q;
    }
    
    public T getA(){
        return a;
    }
    
    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        UseGenerics<Integer> run1 = new UseGenerics<>(x, y); // question (c)
        System.out.println("Max is " + run1.getA());
        
        // Automatically calls the UseGenerics object's toString() method
        // which is the default toString() that returns class name + "@" + memory address
        System.out.println(new UseGenerics("Hello", "World"));
    }
}
