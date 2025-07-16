/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L5Q3;

/**
 *
 * @author tianlongc
 * @param <E> the generic type parameter
 */
import java.util.NoSuchElementException;

public class DList<E> {
    private DNode<E> head;
    private DNode<E> tail;
    private int size;
    
    // default constructor
    public DList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public void addFirst(E element){
        // create object temp and set pointer of the new node
        DNode<E> temp = new DNode(element, head, null);
        // set head.prev of current head to be linked to the new node
        if (head != null) {
            head.prev = temp;
        }
        head = temp;
        // if no tail, then temp set to be a tail, head = tail
        if (tail == null) {
            tail = temp;
        }
        size++;
        System.out.println("adding: " + element);
    }
    
    public void addLast(E element){
        // create object temp and set pointer of the previous node
        DNode<E> temp = new DNode(element, null, tail);
        // set tail.next of current tail to be linked to the new node, tmep
        if (tail != null) {
            tail.next = temp;
        }
        tail = temp;
        // if no head, then temp set to be a head, head = tail
        if (head == null) {
            head = temp;
        }
        size++;
        System.out.println("adding: " + element);
    }
    
    public void add(int index, E element){
        // Handles out of boundary index exception
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + "(size: " + size + ")");
        }
        if (index == 0) {
            addFirst(element);
        }else if(index == size){
            addLast(element);
        }else{
            /**
             * Set from head and begin traverse
             * stop on required position
             */
            DNode<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            /*
              create object insert and set pointer of the next pointer
              to the temp node and also set pointer of the prev pointer
              to the temp.prev node
             */
            DNode<E> insert = new DNode(element, temp, temp.prev);
            // set pointer 'next' of the node temp.prev to new node insert
            temp.prev.next = insert;
            // set pointer 'prev' of the node temp to new node insert
            temp.prev = insert;
            size++;
//            System.out.println("adding: " + element);
        }
    }
    
    public void iterateForward(){
        System.out.println("iterating forward..");
        DNode<E> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println("");
    }
    
    public void iterateBackward(){
        System.out.println("iterating backward..");
        DNode<E> current = tail;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.prev;
        }
        System.out.println("");
    }
    
    public E removeFirst(){
        if (size == 0) {
            throw new NoSuchElementException("There is no elements in the list!");
        }
        DNode<E> temp = head; // copy head to node
        head = head.next; // head.next becomes head
        head.prev = null; // set pointer of prev of new head to be null
        size--;
        System.out.println("deleted: " + temp.element);
        return temp.element;
    }
    
    public E removeLast(){
        if (size == 0) {
            throw new NoSuchElementException("There is no elements in the list!");
        }
        DNode<E> temp = tail; // copy tail to node
        tail = tail.prev; // tail.prev becomes tail
        tail.next = null; // set pointer of next of new tail to be null
        size--;
        System.out.println("deleted: " + temp.element);
        return temp.element;
    }
    
    public E remove(int index){
        E element = null;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + "(size: " + size + ")");
        }
        if (index == 0) {
            removeFirst();
        }else if (index == size-1){
            removeLast();
        }else{
            DNode<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            element = temp.element;
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            temp.next = null;
            temp.prev = null;
            size--;
        }
        return element;
    }
    
    public void clear(){
        DNode<E> temp = head;
        while (head != null) {
            temp = head.next;
            head.prev = head.next = null;
            head = temp;
        }
        temp = null;
        tail.prev = tail.next = null;
        System.out.printf("successfully clear %d node(s)\n", size);
        size = 0;
    }
    
    public int getSize(){
        return size;
    }
}
