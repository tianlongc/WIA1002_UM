/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author tianlongc
 */
public class TowerOfHanoi {
    static int step = 0; // global variable to track steps
    
    public static void main(String[] args) {
        move(2, "pole 1", "pole 3", "pole 2");
    }
    
    public static void move(int n, String fromRod, String toRod, String auxRod){
        if (n == 1) {
            System.out.printf("Step %d: Move disc %d from %s to %s\n", ++step, n, fromRod, toRod);
        }else{
            move(n-1, fromRod, auxRod, toRod);
            System.out.printf("Step %d: Move disc %d from %s to %s\n", ++step, n, fromRod, toRod);
            move(n-1, auxRod, toRod, fromRod);
        }
    }
}
