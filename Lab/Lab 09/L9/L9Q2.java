/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L9;

/**
 *
 * @author tianlongc
 */

public class L9Q2 {
    public static void main(String[] args) {
        permuteString("ABC", "");
    }
    
    public static void permuteString(String s, String result){
        // Base Case: If no characters left to permute, print the result
        if (s.isEmpty()) {
            System.out.println(result);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            // Remaining characters after removing s.charAt(i), Update the result with current char
            String remaining = s.substring(0,i) + s.substring(i+1);
            permuteString(remaining, result + s.charAt(i));
        }
    }
}
