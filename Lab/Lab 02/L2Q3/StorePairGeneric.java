/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L2Q3;

/**
 *
 * @author tianlongc
 */
public class StorePairGeneric<T extends Comparable<T>> implements Comparable<StorePairGeneric<T>>{
    private T first, second;
    
    public StorePairGeneric(T first, T second){
        this.first = first;
        this.second = second;
    }
    
    public T getFirst(){
        return first;
    }
    
    public T getSecond(){
        return second;
    }
    
    public void setPair(T first, T second){
        this.first = first;
        this.second = second;
    }
    
    @Override
    public String toString(){
        return "first = " + first + " second = " + second;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true; // Check if the objects are the same instance
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        return this.first.equals(((StorePairGeneric<T>) obj).first);
    }
    
    @Override
    public int compareTo(StorePairGeneric<T> other){
        return this.first.compareTo(other.first);
    }
    
    public static void main(String[] args) {
        StorePairGeneric<Integer> a = new StorePairGeneric<>(6, 4);
        StorePairGeneric<Integer> b = new StorePairGeneric<>(2, 2);
        StorePairGeneric<Integer> c = new StorePairGeneric<>(6, 3);
         
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        
        // equals function
        System.out.println("a equals b? " + a.equals(b));
        System.out.println("a equals c? " + a.equals(c));
        System.out.println("b equals c? " + b.equals(c));
        
        // compareTo
        System.out.println("a compareTo b: " + a.compareTo(b));
        System.out.println("a compareTo c: " + a.compareTo(c));
        System.out.println("b compareTo c: " + b.compareTo(c));
    }
}
