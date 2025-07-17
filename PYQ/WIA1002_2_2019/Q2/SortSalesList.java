/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 */
// Comparable --> compareTo

public class SortSalesList{
    
    public static void selectionSort(SalesList[] list){
        for (int i = 0; i < list.length-1; i++) {
            // Track the minimum index in the list
            int minIndex = i;
            for (int j = i+1; j < list.length; j++) {
                if (list[j].getRegion().compareTo(list[minIndex].getRegion()) > 0) {
                    minIndex = j;
                }
            }
            // Swap list[i] with list[minIndex] if necessary
            if (minIndex != i) {
                SalesList temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }
        }
    }
    
    public static void insertionSort(SalesList[] list){
        for (int i = 1; i < list.length; i++) {
            SalesList currentElement = list[i];
            int k;
            
            for (k = i-1; (k >= 0) && (list[k].getSalesAmount().compareTo(currentElement.getSalesAmount()) > 0); k--) {
                list[k+1] = list[k];
            }
            list[k+1] = currentElement;
        }
    }
    
    public static void bubbleSort(SalesList[] list){
        for (int i = 0; i < list.length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < list.length-i-1; j++) {
                if (list[j].getSalesRepresentativeName().compareTo(list[j+1].getSalesRepresentativeName()) > 0) {
                    isSwap = true;
                    SalesList temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
            if (!isSwap) break; // optimization
        }
    }
    
    
    public static void main(String[] args) {
        SalesList[] list = {
            new SalesList("Asia", "Ahmad", 450),
            new SalesList("Europe", "Hemish", 518),
            new SalesList("Europe", "Banny", 650),
            new SalesList("Greenland", "Ain", 200),
            new SalesList("Asia", "Ali", 390),
            new SalesList("Greenland", "Ben", 670),
            new SalesList("Asia", "Lee", 790)
        };
        
        System.out.println("Original Data:");
        for (SalesList salesList : list) {
            System.out.println(salesList);
        }
        
        System.out.println("\nSorting Result on Region using SelectionSort:");
        selectionSort(list);
        for (SalesList salesList : list) {
            System.out.println(salesList);
        }
        
        System.out.println("\nSorting Result on Sales using InsertionSort:");
        insertionSort(list);
        for (SalesList salesList : list) {
            System.out.println(salesList);
        }
        
        System.out.println("\nSorting Result on SalesRep using BubbleSort:");
        bubbleSort(list);
        for (SalesList salesList : list) {
            System.out.println(salesList);
        }
    }
}
