/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L2Q5;

/**
 *
 * @author tianlongc
 */
class Circle implements Comparable<Circle>{
    private double radius;
    
    public Circle(double radius){
        this.radius = radius;
    }
    
    @Override
    public int compareTo(Circle other){
        return Double.compare(radius, other.radius);
    }
    
    @Override
    public String toString(){
        return "" + radius;
    }
}

public class FindMax {
    public static <E extends Comparable<E>> E max(E[] list){
        E max = list[0];
        for (E element: list) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        Integer[] a = {1,2,3};
        String[] b = {"red", "green", "blue"};
        Circle[] c = {new Circle(3), new Circle(2.9), new Circle(5.9)};
        
        System.out.println("Max in (a): " + max(a));
        System.out.println("Max in (b): " + max(b));
        System.out.println("Max in (c): " + max(c));
    }
}
