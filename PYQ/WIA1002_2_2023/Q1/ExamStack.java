/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author tianlongc
 * @param <E> the generic type parameter named element
 */
import java.util.LinkedList;

public class ExamStack<E>{
    private LinkedList<E> list;
    
    public ExamStack(){
        this.list = new LinkedList<>();
    }
    
    public E peep(){
        return list.getLast();
    }
    
    public E pop(){
        return list.removeLast();
    }
    
    public void push(E e){
        this.list.addLast(e);
    }
    
    public int getSize(){
        return list.size();
    }
}
