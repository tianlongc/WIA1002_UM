/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L5Q2;

/**
 *
 * @author tianlongc
 */

/**
 * 
 * 1. Admin staff shall be able to interact with the program. 
 *    The admin staff should enter a list of student’s names.
 * 2. Display the list of the entered student’s names.
 * 3. Calculate the number of students in the list.
 * 4. Rename existing student’s name in the list with the new one specified by the admin staff.
 * 5. Delete a student name as specified by the admin staff.
 * 
 */
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SList<String> list = new SList<>();
        
        System.out.println("Enter your student name list. Enter 'n' to end.....");
        while (true) {
            String name = sc.nextLine();
            if (name.equals("n")) {
                break;
            }
            list.add(name);
        }
        
        System.out.println("\nYou have entered the following students' name :");
        list.printList();
        
        System.out.println("\nThe number of students entered is : " + list.getSize());
        
        System.out.println("\nAll the names entered are correct? Enter 'r' to rename the student name, 'n' to proceed.");
        char input = sc.nextLine().charAt(0); // use nextLine instead of next to clear input buffer
        // input validation
        while (input != 'r' && input != 'n') {
            System.out.print("Enter 'r' or 'n' : ");
            input = sc.nextLine().charAt(0); 
        }
        if (input == 'r') {
           System.out.println("\nEnter the existing student name that u want to rename :");
           String name = sc.nextLine();
           while (!list.contains(name)) {
                System.out.println("Name not found. Please enter an existing student name:");
                name = sc.nextLine();
            }
           
           System.out.println("\nEnter the new name :");
           String newName = sc.nextLine();
           
           list.replace(name, newName);
           System.out.println("\nThe new student list is :");
           list.printList();
        }
        
        System.out.println("\nDo you want to remove any of your student name? Enter 'y' for yes, 'n' to proceed.");
        input = sc.nextLine().charAt(0);
        while (input != 'y' && input != 'n') {
            System.out.print("Enter 'y' or 'n' : ");
            input = sc.nextLine().charAt(0);
        }
        
        if (input == 'y') {
            System.out.println("\nEnter a student name to remove :");
            String name = sc.nextLine();
            while (!list.contains(name)) {
                System.out.println("Name not found. Please enter an existing student name:");
                name = sc.nextLine();
            }
            list.removeElement(name);
            
            System.out.println("\nThe number of updated student is :" + list.getSize());
            System.out.println("The updated students list is :");
            list.printList();
        }
        
        System.out.println("\nAll student data captured complete. Thank you!");
        
        sc.close();
    }
}
