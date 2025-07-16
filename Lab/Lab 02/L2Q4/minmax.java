/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L2Q4;

/**
 *
 * @author tianlongc
 */
public class minmax {
    public <T extends Comparable<T>> String minmax(T[] array){
        T min = array[0];
        T max = array[0];
        
        for (T element: array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        
        return ("Min = " + min + "  Max = " + max);
    }
    
    public static void main(String[] args) {
        Integer[] intArray = {5,3,7,1,4,9,8,2};
        String[] strArray = {"red", "blue", "orange", "tan"};
        
        minmax m = new minmax();
        
        System.out.println(m.minmax(intArray));
        System.out.println(m.minmax(strArray));
    }
}
