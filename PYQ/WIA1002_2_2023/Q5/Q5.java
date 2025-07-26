/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q5;

/**
 *
 * @author tianlongc
 */
import java.util.Comparator;

public class Q5{
    public static void main(String[] args) {
        String[] names = {
                "DAVID", "ELIZABETH", "JAMES", "JENNIFER", "JOHN",
                "LINDA", "MARIA", "MICHAEL", "PATRICIA", "ROBERT",
                "АНТОНОВ", "ВОЛКОВ", "ГУРИН", "ИВАНОВ", "КОММОГОРОВ",
                "МАРИА", "МАРКОВ", "ПЕТРОВ", "ПУТИН", "СТЕПАНОВ"
        };

        Comparator<String> comparator = new SpecialComparator<>();
        sort(names, comparator);
        System.out.print("# Sorted name list:\n - ");
        printArray(names, "\n - ");
        
        System.out.println("\n# Search");
        String[] namesToSearch = {"АНТОНОВ", "MARKOV", "МАРИА", "ВОЛКОВ"};
        
        for (String name : namesToSearch) {
            System.out.printf("    Index of %s: %d\n", name, search(names, name));
        }
        
        System.out.println("\n# Longest name");
        System.out.println(findMax(names, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return Integer.compare(s1.length(), s2.length());
            }
        }));
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
    
    public static <E> void printArray(E[] arr, String delimiter){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s%s", arr[i], i != arr.length-1 ? delimiter : "\n");
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
