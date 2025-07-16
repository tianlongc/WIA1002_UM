/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L9;

/**
 *
 * @author tianlongc
 */
public class L9Q1 {
    public static void main(String[] args) {
        String s1 = "flabbergasted";
        String s2 = "Astronaut";
        
        System.out.println(s1 + " --> " + substituteAI(s1));
        System.out.println(s2 + " --> " + substituteAI(s2));
    }
    
    public static String substituteAI(String s){
        // Base case: empty string
        if (s.isEmpty()) {
            return ""; // early exit
        }
        /* 
        Check the first character and process the rest of the strings
        - substring(1) to exclude the first character
        */
//        if (s.charAt(0) == 'a') {
//            return 'i' + substituteAI(s.substring(1));
//        }else{
//            return s.charAt(0) + substituteAI(s.substring(1));
//        }
        return (s.charAt(0) == 'a' ? 'i': s.charAt(0)) + substituteAI(s.substring(1));
    }
}
