/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SList;

/**
 *
 * @author tianlongc
 */
public class TestSList {
    public static void main(String[] args) {
        SList<String> list = new SList<>();
        
        // Append the following values individually: “Linked list, is, easy.”
        list.appendEnd("Linked list");
        list.appendEnd("is");
        list.appendEnd("easy");
        
        // Display these values.
        list.display();
        
        System.out.println("\nRemove the word \"Linked list\" and display the removed value.");
        System.out.println(list.removeInitial());
        
        System.out.println("\nCheck if 'difficult' is in the list.");
        System.out.println(list.contains("difficult"));
        
        System.out.println("\nClear the list.");
        list.clear();
    }
}
