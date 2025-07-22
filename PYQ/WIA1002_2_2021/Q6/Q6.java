/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q6;

/**
 *
 * @author tianlongc
 */

/*
    c) The linear search is more efficient for a single search in a 50%-full warehouse
       because the time taken to sort the parcels (O (n log n)) outweighs the O(log n) of binary search.
       Linear search is faster as no sorting is neeeded. Binary search requires merge sort (O (n log n)) which is
       much more slower for one-time use. (or bubble sort implementation)
*/

import java.util.Random;

public class Q6 {
    static double sortTime = 0.0; // time to track mergeSort
    
    public static void main(String[] args) {
        Random rd = new Random();
        
        int[] parcels = new int[1000];
        
        for (int i = 0; i < parcels.length; i++) {
            parcels[i] = i;
        }
        
        // Shuffle the array using Fisher-Yates shuffle
        for (int i = parcels.length-1; i > 0; i--) {
            int j = rd.nextInt(i+1); // Random index between 0 and i
            
            int temp = parcels[i];
            parcels[i] = parcels[j];
            parcels[j] = temp;
        }
        double linearSearchTime = linearSearch(parcels, 120);
        printParcels(parcels);
        System.out.println("The amount of time (in minutes) for Linear Search : " + linearSearchTime + "\n");
        
        double bubbleSortTime = bubbleSort(parcels.clone());
        mergeSort(parcels);
        double binarySearchTime = binarySearch(parcels, 120);
        printParcels(parcels);
        System.out.println("The amount of time (in minutes) to sort using Merge Sort : " + sortTime/60.0);
        System.out.println("The amount of time (in minutes) to sort using Bubble Sort : " + bubbleSortTime);
        System.out.println("The amount of time (in minutes) for Binary Search : " + binarySearchTime);
        
        if (linearSearchTime < (binarySearchTime + sortTime)) {
            System.out.println("\nLinear Search is more faster for one-time searching");
        }else{
            System.out.println("\nBinary Search is more faster after sorting");
        }
    }
    
    public static void printParcels(int[] parcels){
        for (int parcel : parcels) {
            System.out.print(parcel + " ");
        }
        System.out.println("");
    }
    
    public static double linearSearch(int[] parcels, int key){
        double time = 0.0;
        for (int i = 0; i < parcels.length; i++) {
            time += 15;
            if (parcels[i] == key) {
                System.out.println(parcels[i] + " is found at position " + i);
                return time/60.0;
            }
        }
        return time/60.0;
    }
    
    public static double binarySearch(int[] parcels, int key){
        double time = 0.0;
        int low = 0;
        int high = parcels.length-1;
        
        while (high >= low) {
            time += 15;
            int mid = (low + high)/2;
            if (key < parcels[mid]) {
                high = mid - 1;
            }else if(key == parcels[mid]){
                System.out.println(parcels[mid] + " is found at position " + mid);
                return time/60.0;
            }else{
                low = mid + 1;
            }
        }
        return time/60.0;
    }
    
    // Two possible sorting algorithms - Merge Sort + Bubble sort
    public static void mergeSort(int[] parcels){
        // base case
        if (parcels.length <= 1) {
            return;
        }else{
            // Merge sort the first half
            int[] firstHalf = new int[parcels.length/2];
            System.arraycopy(parcels, 0, firstHalf, 0, parcels.length/2);
            mergeSort(firstHalf);
            
            // Merge sort the second half
            int secondHalfLength = parcels.length - (parcels.length/2);
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(parcels, parcels.length/2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);
            
            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, parcels);
        }
    }
    
    // Helper method to merge
    private static void merge(int[] list1, int[] list2, int[] temp){
        int current1 = 0, current2 = 0, current3 = 0;
        
        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                temp[current3++] = list1[current1++];
            }else{
                temp[current3++] = list2[current2++];
            }
            sortTime += 6;
        }
        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
            sortTime += 6;
        }
        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
            sortTime += 6;
        }
    }
    
    public static double bubbleSort(int[] parcels){
        double time = 0;
        
        for (int i = 0; i < parcels.length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < parcels.length-i-1; j++) {
                if (parcels[j] > parcels[j+1]) {
                    isSwap = true;
                    int temp = parcels[j];
                    parcels[j] = parcels[j+1];
                    parcels[j+1] = temp;
                    time += 6;
                }
            }
            if(!isSwap) break;
        }
        return time/60.0;
    }
}
