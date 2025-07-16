/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L10;

/**
 *
 * @author tianlongc
 */
//import java.util.Arrays; // to simplify array toString

public class L10 {
    
    // L10Q1
    public void selectionSortSmallest(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            // Track the minimum index in the list
            int minIndex = i;
            
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap arr[i] with arr[minIndex] if necessary
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    
    // L10Q2
    public void selectionSortLargest(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            // Track the maximum index in the list
            int maxIndex = i;
            
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Swap arr[i] with arr[maxIndex] if necessary
            if (maxIndex != i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }
    
    // L10Q4
    public void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int currentElement = arr[i], k;
            
            for (k = i-1; (k >= 0) && (arr[k] > currentElement); k--) {
                arr[k+1] = arr[k];
            }
            arr[k+1] = currentElement;
        }
    }
    
    public String toString(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(String.format("%d%s", arr[i], i != arr.length-1 ? ", ": "]"));
        }
        return sb.toString();
    }
    
    // L10Q3 Test program
    public static void main(String[] args) {
        L10 sort = new L10();
        
        int[] arr = {45, 7, 2, 8, 19, 3};
        System.out.println("Selection Sort Smallest:\nBefore: " + sort.toString(arr));
        sort.selectionSortSmallest(arr);
        System.out.println("After: " + sort.toString(arr));
        
        // re-initialize the arr elements after mutation in Q1
        arr = new int[]{45, 7, 2, 8, 19, 3};
        System.out.println("\nSelection Sort Largest:\nBefore: " + sort.toString(arr));
        sort.selectionSortLargest(arr);
        System.out.println("After: " + sort.toString(arr));
        
        int[] list = {10, 34, 2, 56, 7, 67, 88, 42};
        System.out.println("\nInsertion Sort: \nBefore: " + sort.toString(list));
        sort.insertionSort(list);
        System.out.println("After: " + sort.toString(list));
    }
}
