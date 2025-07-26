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

public class SpecialComparator<E extends CharSequence> implements Comparator<E>{
    // The RU can be obtained using the following code:
    //     for (char ch = '\u0410'; ch < '\u0434'; ch++) {
    //        System.out.print(ch);
    //     }
    
    private static final String EN = "ABC.DE..FGHIJ..KLMNOPQRS..TUVWXY.Z..";
    private static final String RU = "АБЧЧДЕЁЭФГХИЙЯЮКЛМНОП.РСШЩТУВ..ЫЖЗЬЪ";
    
    public SpecialComparator(){
        
    }
    
    @Override
    public int compare(E o1, E o2){
        int n = Math.min(o1.length(), o2.length());
        for (int i = 0; i < n; i++) {
            int rank1 = getPrecendence(o1.charAt(i));
            int rank2 = getPrecendence(o2.charAt(i));
            if (rank1 != rank2) { // Search until encountering a different letter
                return Integer.compare(rank1, rank2);
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
    
    // Helper method to determine precendence
    private int getPrecendence(char c){
        // Check EN first then RU
        if (EN.indexOf(c) != -1) {
            return EN.indexOf(c);
        }
        return RU.indexOf(c);
    }
}
