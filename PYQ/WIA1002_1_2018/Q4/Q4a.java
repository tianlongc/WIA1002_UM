/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 */
public class Q4a {
    public static void main(String[] args) {
        
        LList list = new LList();
        
        list.add("Computing Mathematics 1", 3);
        list.add("Principles of AI", 3);
        list.add("Programming 1", 5);
        list.add("Data Structure", 5);
        list.display();
        list.addAfter("Programming 1", "Software Architecture", 4);
        list.addAfter("Software Architecture", "Networking", 4);
        
        list.remove("Networking", 4);
        list.display();
        
        list.remove("Principles of AI", 3);
        list.display();
        
    }
}
