/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L10ex;

/**
 *
 * @author tianlongc
 */

/*
    Apply Generics into Sorting
*/
public class L10 {
    /**
     * Selection sort by smallest
     * @param <T> generic type parameter which represent data types
     * @param list the array
     */
    public static <T extends Comparable<T>> void selectionSortSmallest(T[] list){
        for (int i = 0; i < list.length-1; i++) {
            int minIndex = i;
            
            for (int j = i+1; j < list.length; j++) {
                if (list[j].compareTo(list[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(list, minIndex, i);
        }
    }
    
    /**
     * Selection sort by largest
     * @param <T> generic type parameter which represent data types
     * @param list the array
     */
    public static <T extends Comparable<T>> void selectionSortLargest(T[] list){
        for (int i = 0; i < list.length-1; i++) {
            int maxIndex = i;
            
            for (int j = i+1; j < list.length; j++) {
                if (list[j].compareTo(list[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swap(list, maxIndex, i);
        }
    }
    
    /**
     * Helper method to swap two elements in an array
     * @param <T> generic type parameter which represent data types
     * @param list the array
     * @param i first element to swap
     * @param j second element to swap
     */
    private static <T> void swap(T[] list, int i, int j){
        T temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    
    /**
     * 
     * @param <T> generic type parameter which represent data types
     * @param list the array
     */
    public static <T extends Comparable<T>> void insertionSort(T[] list){
        for (int i = 1; i < list.length; i++) {
            T currentElement = list[i];
            int k;
            
            for (k = i-1; (k >= 0) && (list[k].compareTo(currentElement) > 0); k--) {
                list[k+1] = list[k];
            }
            list[k+1] = currentElement;
        }
    }
    
    /**
     * Convert the array into String representation
     * @param <T> generic type parameter which represent data types
     * @param list the array 
     * @return string representation of array
     */
    public static <T> String toString(T[] list){
        if (list == null || list.length == 0) {
            return "[]"; // early exit for null
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]);
            if (i < list.length-1){
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
    
    // L10Q3 Test program
    public static void main(String[] args) {
        Integer[] arr = {45, 7, 2, 8, 19, 3};
        System.out.println("Selection Sort Smallest:\nBefore: " + toString(arr));
        selectionSortSmallest(arr);
        System.out.println("After: " + toString(arr));
        
        // re-initialize the arr elements after mutation in Q1
        arr = new Integer[]{45, 7, 2, 8, 19, 3};
        System.out.println("\nSelection Sort Largest:\nBefore: " + toString(arr));
        selectionSortLargest(arr);
        System.out.println("After: " + toString(arr));
        
        Integer[] list = {10, 34, 2, 56, 7, 67, 88, 42};
        System.out.println("\nInsertion Sort: \nBefore: " + toString(list));
        insertionSort(list);
        System.out.println("After: " + toString(list));
    }
}
