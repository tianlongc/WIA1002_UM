/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q5ex;

/**
 *
 * @author tianlongc
 */

/*
    Uses File Writer to check the output since text encoding uses UTF-8
    and NetBeans Terminal cannot process some of the characters
*/

import java.util.Comparator;
import java.io.*;

public class Q5{
    public static void main(String[] args) {
        try{
            PrintWriter output = new PrintWriter(new FileWriter("outputQ5.txt"));
            
            String[] names = {
                "DAVID", "ELIZABETH", "JAMES", "JENNIFER", "JOHN",
                "LINDA", "MARIA", "MICHAEL", "PATRICIA", "ROBERT",
                "АНТОНОВ", "ВОЛКОВ", "ГУРИН", "ИВАНОВ", "КОММОГОРОВ",
                "МАРИА", "МАРКОВ", "ПЕТРОВ", "ПУТИН", "СТЕПАНОВ"
            };

            Comparator<String> comparator = new SpecialComparator<>();
            sort(names, comparator);
            output.print("# Sorted name list:\n - ");
            printArray(names, "\n - ", output);

            output.println("\n# Search");
            String[] namesToSearch = {"АНТОНОВ", "MARKOV", "МАРИА", "ВОЛКОВ"};

            for (String name : namesToSearch) {
                output.printf("    Index of %s: %d\n", name, search(names, name));
            }

            output.println("\n# Longest name");
            output.println(findMax(names, new Comparator<String>(){
                @Override
                public int compare(String s1, String s2){
                    return Integer.compare(s1.length(), s2.length());
                }
            }));
            
            output.close();
        }catch(IOException e){
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
    
    public static <E> void sort(E[] arr, Comparator<E> comparator){
        for (int i = 0; i < arr.length; i++) {
            E currentElement = arr[i];
            int k;
            
            for (k = i-1; k >= 0 && (comparator.compare(arr[k], currentElement) > 0); k--) {
                arr[k+1] = arr[k];
            }
            arr[k+1] = currentElement;
        }
    }
    
    // bubble sort
//    public static <E> void sort(E[] arr, Comparator<E> comparator){
//        for (int i = 0; i < arr.length; i++) {
//            boolean isSwap = false;
//            for (int j = 0; j < arr.length-i-1; j++) {
//                if (comparator.compare(arr[j], arr[j+1]) > 0) {
//                    isSwap = true;
//                    E temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//            if(!isSwap) break; // optimization
//        }
//    }
    
    public static <E> void printArray(E[] arr, String delimiter, PrintWriter output){
        for (int i = 0; i < arr.length; i++) {
            output.printf("%s%s", arr[i], i != arr.length-1 ? delimiter : "\n");
        }
    }
    
    public static <E> int search(E[] arr, E key){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(key)) return i;
        }
        return -1;
    }
    
    public static <E> E findMax(E[] arr, Comparator<E> comparator){
        E max = arr[0];
        // Skip the first element
        for (int i = 1; i < arr.length; i++) {
            if (comparator.compare(arr[i], max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }
}
