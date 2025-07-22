/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q43a;

/**
 *
 * @author tianlongc
 */
import java.util.*;

public class Q43a {
    public static void main(String[] args) {
        String[] arr = {"Alexa", "Alice", "Alan", "Alvin", "Alicia", "Aidan", "Ali", "Alicia"};
        String target = "Alicia";
        
        System.out.println("Target element is: " + target);
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        
        List<Integer> result = binarySearch(arr, target);
        
        if (!result.isEmpty()) {
            System.out.println("Element found at index: " + result);
        }else{
            System.out.println("Element not found.");
        }
    }
    
    public static List<Integer> binarySearch(String[] arr, String target){
        List<Integer> indices = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
           int mid = left + (right - left) / 2;
           int comparisonResult = target.compareTo(arr[mid]);
           if (comparisonResult == 0) {
               int firstOccurrence = mid;
               while (firstOccurrence > left && arr[firstOccurrence - 1].equals(target)) {
                   firstOccurrence--;
               }
               int current = firstOccurrence;
               while (current < arr.length && arr[current].equals(target)) {
                   indices.add(current);
                   current++;
               }
               return indices;
               // errata: should be > 0
           } else if (comparisonResult > 0){ // target is larger than arr[mid]
               left = mid + 1; // search right half
           } else { // comparisonResult < 0 means target is less than arr[mid]
               right = mid - 1; // search left half
           }
        }
        return indices;
    }
}
