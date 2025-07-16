/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L7b;

/**
 *
 * @author tianlongc
 */
import java.util.Queue;
public class TestComparableBook {
    public static void main(String[] args) {
        Queue<ComparableBook> BookQueue = new java.util.PriorityQueue<>();
        BookQueue.add(new ComparableBook(1065, "Effective Java: Third Edition"));
        BookQueue.add(new ComparableBook(3012, "Java: A Beginner Guide Seventh Edition"));
        BookQueue.add(new ComparableBook(1097, "Learn Java in One Day and Learn It Well"));
        BookQueue.add(new ComparableBook(7063, "Beginning Programming with Java (Dummies)"));
        BookQueue.add(new ComparableBook(6481, "Java: Programming Basic for Absolute Beginner"));
        
        System.out.println(BookQueue);
        
        while (BookQueue.peek() != null) {
            // .peek() retrieves the head (smallest or first) element based on the ordering defined by compareTo
            System.out.println("Head Element: " + BookQueue.peek()); 
            BookQueue.remove();
            System.out.println("Priority queue: " + BookQueue);
        }
    }
}

class ComparableBook implements Comparable<ComparableBook> {
    private String name;
    private int id;
    
    public ComparableBook(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    @Override
    public int compareTo(ComparableBook other){
        return Integer.compare(this.id, other.id);
    }
    
    @Override
    public String toString(){
        return String.format("(id=%d bookName=%s)", id, name);
    }
}
