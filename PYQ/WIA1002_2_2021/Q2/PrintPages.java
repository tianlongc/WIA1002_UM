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
import java.util.ArrayList;

public class PrintPages {
    public static void main(String[] args) {
        SpecialLL<Integer> bookPage = new SpecialLL<>();
        ArrayList<Integer> selectedList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the starting page: ");
        int start = input.nextInt();
        System.out.print("Enter number of pages: ");
        int page = input.nextInt();
        // add 2 lines of code here to
        //     insert values to bookPage
        for (int i = start; i < start+page; i++) 
            bookPage.addLast(i);
        selectedList=bookPage.getEven();
        
        // insert multiple lines of code here
        bookPage.printOdd();
        
        for (int i = selectedList.size()-1; i >= 0; i--) {
            System.out.print(" " + selectedList.get(i));
        }
        System.out.println("");
    }
}
