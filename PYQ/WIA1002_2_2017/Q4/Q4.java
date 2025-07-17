/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 */
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Character[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Queue<Character> alphabetsQ = new Queue<>(alphabets.length);
        
        for (Character alphabet : alphabets) {
            alphabetsQ.enqueue(alphabet);
        }
        System.out.println("Queue: " + alphabetsQ);
        
        System.out.print("Index: [");
        for (int i = 0; i < alphabetsQ.getSize(); i++) {
            System.out.printf("%d%s", i, i != alphabetsQ.getSize()-1 ? ", " : "]\n\n");
        }
        
        System.out.print("How many times will you enter a number: ");
        int times = sc.nextInt();
        System.out.println("(Please enter your number(s) between 0-26.)");
        
        Queue<Integer> numbersQ = new Queue<>();
        for (int i = 1; i <= times; i++) {
            System.out.print("Enter number " + i + " >> ");
            numbersQ.enqueue(sc.nextInt());
        }
        System.out.println("The entered numbers are " + numbersQ);
        
        System.out.print("The deciphered values are ");
        if (!numbersQ.isEmpty()) {
            while (!numbersQ.isEmpty()) {
                System.out.print(alphabetsQ.getElement(numbersQ.dequeue()));
            }
            System.out.println("");
        }else{
            System.out.println("-Cannot decipher. No value was entered.-");
        }
        sc.close();
    }
}
