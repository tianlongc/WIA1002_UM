/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 */
import java.util.Scanner;

public class TestPileStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Create a new stack: an empty pile of books");
        StackInterface<String> bookPile = new GenericStack<>();
        
        System.out.println("isEmpty() returns " + bookPile.isEmpty());
        
        System.out.println("\nPush 3 books to the pile:");
        for (int i = 1; i <= 3; i++) {
            System.out.printf("Enter book title %d: ", i);
            String title = sc.nextLine();
            bookPile.push(title);
        }
        
        System.out.println("\nThe new books that you added are: " + bookPile);
        
        System.out.println("\nThe pile should not be empty:");
        System.out.println("isEmpty() returns " + bookPile.isEmpty());
        System.out.println("The pile has " + bookPile.size() + " books.");
        
        System.out.println("\nGet the top book and remove the top book:");
        
        while (!bookPile.isEmpty()) {
            System.out.printf("\n%s is at the top of the pile.\n", bookPile.peek());
            System.out.printf("%s is removed from the pile.\n", bookPile.pop());
        }
        
        System.out.println("\nThe pile should be empty:");
        System.out.println("isEmpty() returns " + bookPile.isEmpty());
        
        sc.close();
    }
}
