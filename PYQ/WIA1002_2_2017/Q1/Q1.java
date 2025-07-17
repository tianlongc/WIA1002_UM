/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author tianlongc
 */
public class Q1 {
    public static void main(String[] args) {
        LinkedList s = new LinkedList();
        
        s.insertFirstLink("Louis Vuitton", 10000000);
        s.insertFirstLink("Chanel", 100000000);
        s.insertFirstLink("Prada", 1000000);
        s.insertFirstLink("Tods", 500000000);
        s.display();
        
        s.addAfter("Chanel", "Coach", 10000000);
        s.display();
        
        s.addAfter("Coach", "Mulberry", 90000000);
        s.display();
        
        s.removeLink("Chanel");
        s.display();
        
        s.removeLink("Coach");
        s.display();
    }
}
