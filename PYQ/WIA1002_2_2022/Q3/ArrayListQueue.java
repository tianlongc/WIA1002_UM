/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 */
import java.util.ArrayList;

public class ArrayListQueue<E> {
    private int size = 10;
    private int front = 0;
    private int end = -1;               // subquestion (a)
    private ArrayList<E> list = new ArrayList<E>(size);
    
    public boolean enqueue(E o){
        boolean success = false;
        if (end < size) {
            success = list.add(o);
            end = (end + 1) % size;     // subquestion (b)
        }
        return success;
    }
    
    public E dequeue(){                 // subquestion (c)
        if (front > end) { // isEmpty()
            return null;
        }
        E temp = list.get(front);
        // no need to dereference
        front = (front + 1) % size;
        return temp;
    }
    
    public String queueToString(){      // subquestion (d)
        StringBuilder sb = new StringBuilder();
        for (int i = front, count = 0; i <= end; i=(i+1)%size) {
            if (count > 0) {
                sb.append(", ");
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }
    
    public String allToString(){
        return "ALL : " + list.toString();
    }
}
