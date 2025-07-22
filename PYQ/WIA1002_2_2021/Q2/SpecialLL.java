/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author tianlongc
 */
import java.util.ArrayList;

public class SpecialLL<E>{
    Node<E> head, tail;
    int size = 0;
    
    public SpecialLL(){
        
    }
    
    public int getSize(){
        return size;
    }
    
    public void addFirst(E e){
        Node<E> newNode = new Node<E>(e);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail == null) {
            tail = head;
        }
    }
    
    public void addLast(E e){
        Node<E> newNode = new Node<E>(e);
        if (tail == null) {
            head = tail = newNode;
        }
        else{
            tail.next= newNode;
            tail = tail.next;
        }
        size++;
    }
    
    public void print(){
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public void printOdd(){
        Node<E> current = head;
        for (int i = 1; i <= size; i++) {
            if (i % 2 == 1) {
                System.out.print(current.element + " ");
            }
            current = current.next;
        }
        System.out.println("");
    }
    
    public ArrayList<E> getEven(){
        ArrayList<E> evenNodes = new ArrayList<>();
        String elements = "";
        
        Node<E> current = head;
        for (int i = 1; i <= size; i++) {
            if (i % 2 == 0) {
                elements += String.format("%s%s", current.element, i != size ? " " : "");
            }
            current = current.next;
        }
        String[] element = elements.split(" ");
        // insert in reverse
        for (int i = element.length-1; i >= 0; i--) {
            evenNodes.add((E)element[i]);
        }
        return evenNodes;
    }
}
