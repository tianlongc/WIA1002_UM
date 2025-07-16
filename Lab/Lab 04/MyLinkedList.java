/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L4;

import java.util.NoSuchElementException;

/**
 * 
 * @author tianlongc
 * @param <E> generic parameter type named element
 */
public class MyLinkedList<E>{
    private Node<E> head, tail;
    private int size;
    
    // Default constructor
    public MyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * Inserts the node at the beginning of the list
     * @param e the element to be added to the list
     */
    public void addFirst(E e){
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = this.head; // link the new node to the old head
        this.head = newNode; // head points to the new node
        this.size++;
        
        // If the list is empty, both head and tail will point to this new node
        if (this.tail == null) {
            this.tail = this.head;
        }
    }
    
    /**
     * Inserts the node at the end of the list
     * @param e the element to be added to the list
     */
    public void addLast(E e){
        Node<E> newNode = new Node<>(e); // Create a new node
        
        if (tail == null) {
            head = tail = newNode; // The only node in list
        } else {
            tail.next = newNode; // Link the new node with the last node
            tail = newNode;
        }
        size++; // Increase size by 1
    }
    
    /**
     * Inserts an element into the list at the specified index
     * @param index the specified index in the list
     * @param e the element to be added to the list
     */
    public void add(int index, E e){
        if (index == 0) {
            addFirst(e); // Use addFirst method 
        } else if (index >= size){
            addLast(e); // Use addLast method
        } else {
            Node<E> newNode = new Node<>(e);
            // Insert in the middle
            Node<E> current = this.head;
            
            for (int i = 0; i < index-1; i++) {
                current = current.next;
            }
            
            newNode.next = current.next;
            current.next = newNode;
            
            this.size++;
        }
    }
    
    /**
     * Removes the first element from the list
     * @return the removed first element from the list
     * @throws NoSuchElementException if there's no element
     */
    public E removeFirst(){
        if (size == 0) {
            throw new NoSuchElementException("No elements in the list!");
//            return null; // Nothing to delete
        } else {
            Node<E> temp = head; // Keep pointing the first node temporarily
            head = head.next; // Move head to point to the next node
            this.size--;
            // If list become empty
            if (head == null) {
                this.tail = null; // in case of head = tail
            }
            return temp.element; // Return the deleted element (debug purpose)
        }
    }
    
    /**
     * Removes the last element from the list
     * @return the removed last element from the list
     */
    public E removeLast(){
        if (size == 0 || size == 1) {
            return removeFirst();
        } else {
            Node<E> current = head;
            for (int i = 0; i < size-2; i++) {
                current = current.next;
            }
            E temp = tail.element;
            tail = current;
            tail.next = null;
            this.size--;
            return temp;
        }
    }
    
    /**
     * Remove the node at the specified index
     * @param index the specified index in the list
     * @throws IndexOutOfBoundsException if the index is invalid (index < 0 || index >= size)
     * @return the removed element from the list
     */
    
    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + "(size: " + size + ")");
//            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            
            Node<E> current = previous.next;
            previous.next = current.next;
            this.size--;
            
            return current.element;
        }
    }
    
    /**
     * Checks whether this list contains a given element
     * @param e the element to locate
     * @return true if the list contains the element, e otherwise false
     */
    public boolean contains(E e){
        return indexOf(e) >= 0;
    }
    
    /**
     * Gets the specified index element
     * @param index the specified index
     * @throws IndexOutOfBoundsException if the index is invalid (index < 0 || index >= size)
     * @return element at the specified index
     */
    public E get(int index){
        // Handles out of boundary index exception
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + "(size: " + size + ")");
//            return null;
        }
        
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }
    
    /**
     * Gets the value of the first item (head element) from the list
     * @return the head element
     */
    public E getFirst(){
        return this.head.element;
    }
    
    /**
     * Gets the value of the last item (tail element) from the list
     * @return the tail element
     */
    public E getLast(){
        return this.tail.element;
    }
    
    /**
     * Gets the index of the head matching element in this list. 
     * @param e the given element 
     * @return the index of the given element otherwise -1
     */
    public int indexOf(E e){
        Node<E> current = head;
        int index = 0;
       
        while (current != null) {
            // ❌ Never use == for generics (unless you intentionally want reference equality)
            if (current.element.equals(e)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    
    /**
     * Gets the index of the last matching element in this list
     * @param e the given element
     * @return the last index of the given element otherwise -1
     */
    public int lastIndexOf(E e){
        boolean found = false;
        Node<E> current = head;
        int index = 0, maxIndex = 0;
       
        while (current != null) {
            // ❌ Never use == for generics (unless you intentionally want reference equality)
            if (current.element.equals(e)) {
                maxIndex = index;
                found = true;
            }
            current = current.next;
            index++;
        }
        
//        if (found) {
//            return maxIndex;
//        }
        return (found ? maxIndex : -1);
    }
    
    /**
     * Replace the element at the specified position in this list with the specified element
     * @param index the specified index
     * @param e the given element
     * @throws IndexOutOfBoundsException if the index is invalid (index < 0 || index >= size)
     * @return the replaced element
     */
    public E set(int index, E e){
        // Handles out of boundary index exception
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + "(size: " + size + ")");
//            return null;
        }
        Node<E> current = head;
        
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        // Replace the element
        current.element = e;
        
        return current.element;
    }
    
    /**
     * Clears the list
     */
    public void clear(){
//        Node<E> current = head;
//        
//        // Extra safety by using iterative cleanup to guarantee
//        // Garbage Collector eligibility
//        while (current != null) {
//            Node<E> next = current.next;
//            current.next = null; // Break forward link
//            current.element = null;
//            current = next;
//        }
//        this.head = this.tail = null;
//        this.size = 0;
        while (size > 0) {
            removeLast();
        }
    }
    
    /**
     * Print all the elements in the list
     */
    public void print(){
        Node<E> current = head;
        
        while (current != null) {
            System.out.printf(current.element + "%s", (current.next != null ? ", ":"\n"));
            current = current.next;
        }
    }
    
    /**
     * Print all the elements in reverse order
     * @throws NoSuchElementException if there's no element
     */
    public void reverse(){
        if (head == null) {
            throw new NoSuchElementException("No elements in the list!");
//            return; // early exit for null
        }
        
        Node<E> current = head.next;
        String output = "" + head.element;
//        Node<E> last = null;
//        
//        while (last != head) {
//            while (current.next != last) {
//                current = current.next;
//            }
//            last = current;
//            System.out.print(last.element + ", ");
//            current = head;
//        }
//        System.out.println("");
        while (current != null) {
            output = current.element + ", " + output;
            current = current.next;
        }
        System.out.println(output);
    }
    
    /**
     * @throws NoSuchElementException if the index is out of bounds (index < 0 or index >= size)
     * @return the middle value of the element from linked list
     */
    public E getMiddleValue(){
        if (size == 0) {
            throw new NoSuchElementException("No elements in the list!");
//            return null;
        }
        
        Node<E> current = head;
        for (int i = 0; i < (size-1)/2; i++) {
            current = current.next;
        }
        return current.element;
    }
    
    /**
     * 
     * @return the size of the linked list
     */
    public int size(){
        return size;
    }
    
    /**
     * Make a new linked list of three nodes has n1 n2 n3
     * Make a linked list which is the reverse of the old one
     * (Mutable Linked List)
     */
    public void reverseLinkedList(){
        if (head == null) {
            return; // early exit for null
        }
        Node<E> prev = null;
        Node<E> next = null;
        Node<E> current = head;
        tail = head; // points to the old head
        
        // Tranversing the nodes O(1)
        while (current != null) {
            next = current.next;    // Save the next node
            current.next = prev;    // Reverse the link
            prev = current;         // Move pointers forward
            current = next;
        }
        head = prev; // points to previous
    }
}
