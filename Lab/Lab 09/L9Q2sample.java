/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L9;

/**
 *
 * @author tianlongc
 */
public class L9Q2sample {
    public static void main(String[] args) {
        permuteString("abc");
    }
    
    public static void permuteString(String s){
        permuteString("", s);
    }
    
    public static void permuteString(String s1, String s2){
        // Base case
        if (s2.isEmpty()) {
            System.out.println(s1);
        }else{
            for (int i = 0; i < s2.length(); i++) {
                String shuffle1 = s1 + s2.charAt(i);
                String shuffle2 = s2.substring(0, i) + s2.substring(i+1);
                permuteString(shuffle1, shuffle2);
            }
        }
    }
}
