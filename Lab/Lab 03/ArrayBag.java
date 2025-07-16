/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L3;

/**
 *
 * @author tianlongc
 */
public class ArrayBag<T> implements BagInterface<T>{
    
    private T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;
    
    /** Creates an empty bag whose initial capacity is 25. */
    public ArrayBag(){
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * Creates an empty bag having a given capacity.
     * @param capacity  the capacity desired
     * @throws IllegalArgumentException if capacity <= 0
     */
    public ArrayBag(int capacity){
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];
        this.bag = tempBag;
//        this.bag = (T[]) new Object[capacity];
    // This unchecked cast is necessary because Java doesn't allow generic array creation.
    // It is safe because:
    // 1. We never expose the raw Object[] array to clients
    // 2. All elements will be of type T when added to the bag
    // 3. The array is used internally and types are maintained by the class
    }
    
    /** Gets the current number of entries in this bag.
        @return the integer number of entries currently in the bag */
    @Override
    public int getCurrentSize(){
        return numberOfEntries;
    }
    
    /** Sees whether this bag is full.
        @return true if the bag is full, or false if not */
    @Override
    public boolean isFull(){
        return getCurrentSize() >= bag.length;
    }
    
    /** Sees whether this bag is empty.
        @return true if the bag is full, or false if not */
    @Override
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }
    
    /** Adds a new entry to this bag.
        @param newEntry the object to be added as a new entry
        @return true if the addition is successful, or false if not */
    @Override
    public boolean add(T newEntry){
        if (isFull()) {
            return false;
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }
    
    /** Removes one unspecified entry from this bag, if possible.
        @return either the removed entry, if the removal was successful,
                or null */
    @Override
    public T remove(){
        T result = null;
        if (!isEmpty()) {
            result = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
        }
        return result;
    }
    
    /** Removes one occurrence of a given entry from this bag.
        @param anEntry the entry to be removed
        @return true if the removal was successful, or false if not */
    @Override
    public boolean remove(T anEntry){
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                // shift all subsequent elements to the left
                for (int j = i; j < numberOfEntries-1; j++) {
                    bag[j] = bag[j+1];
                }
                // Clear the last element to avoid duplication
                bag[numberOfEntries - 1] = null;
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }
    
    /** Removes all entries from this bag. */
    @Override
    public void clear(){
        while (!isEmpty()) {
            remove();
        }
        // Garbage collection
//        this.bag = (T[]) new Object[this.bag.length];
//        this.numberOfEntries = 0;
    }
    
    /** Counts the number of times a given entry appears in this bag.
        @param anEntry  the entry to be counted
        @return the number of times anEntry appears in the bag */
    @Override
    public int getFrequencyOf(T anEntry){
        int counter = 0;
        // Must use numberOfEntries boundary - enhanced for-loop would scan full capacity
        // including null slots beyond our actual data
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                counter++;
            }
        }
        return counter;
    }
    
    /** Tests whether this bag contains a given entry.
        @param anEntry  the entry to locate
        @return true if this bag contains anEntry, or false otherwise */
    @Override
    public boolean contains(T anEntry){
        // NOTE: Cannot use enhanced for-loop here because it would check the ENTIRE array,
        // including unused capacity slots (null values). Must use numberOfEntries boundary.
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }
    
    /** Retrieves all entries that are in this bag.
        @return a newly allocated array of all the entries in the bag */
    // Why dont return this.bag directly?
    // Returning 'bag' directly would break encapsulation by exposing internal data.
    @Override
    public T[] toArray(){
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        // manual copy through for loop
//        for (int i = 0; i < result.length; i++) {
//            result[i] = bag[i];
//        }
        System.arraycopy(bag, 0, result, 0, numberOfEntries);
        // Returns a defensive copy to avoid exposing internal array.
        return result; 
    }
    
    // L3Q2
    /**
     * Return the union of two collections
     * @param other the bag that union with
     * @return the union of the current bag and the parameter bag
     */
    @Override
    public BagInterface<T> union(BagInterface<T> other){
        if (this.isEmpty() || other.isEmpty()) {
            throw new NullPointerException("The bag can not be empty!");
        }
        
        T[] bag1 = this.toArray();
        T[] bag2 = other.toArray();
        
        ArrayBag<T> unionBag = new ArrayBag<>(bag1.length + bag2.length);
        
        for (T item : bag1) {
            unionBag.add(item);
        }
        
        for (T item : bag2) {
            unionBag.add(item);
        }
        
        return unionBag;
    }
    
    // L3Q3
    /**
     * Return the intersection of two collections
     * @param other the bag that intersects with
     * @return the intersection of the current bag and the parameter bag
     */
    @Override
    public BagInterface<T> intersect(BagInterface<T> other){
        if (this.isEmpty() || other.isEmpty()) {
            throw new NullPointerException("The bag can not be empty!");
        }
        
        T[] bag1 = this.toArray();
        T[] bag2 = other.toArray();
        
        ArrayBag<T> intersectionBag = new ArrayBag<>(Math.min(bag1.length, bag2.length));
        
        for (T item : bag1) {
            // avoid duplicate processing using contains
            // ensures each unique item is processed only once
            if (item == null || intersectionBag.contains(item)) {
                continue;
            }
            
            int thisCount = this.getFrequencyOf(item);
            int otherCount = other.getFrequencyOf(item);
            int minCount = Math.min(thisCount, otherCount);
            
            for (int i = 0; i < minCount; i++) {
                intersectionBag.add(item);
            }
        }
        
        return intersectionBag;
    }
    
    // L3Q4
    /**
     * Return the difference of two collections
     * @param other the bag that subtracts with
     * @return the subtraction of the current bag and the parameter bag
     */
    @Override
    public BagInterface<T> difference(BagInterface<T> other){
        if (this.isEmpty() || other.isEmpty()) {
            throw new NullPointerException("The bag can not be empty!");
        }
        
        T[] bag1 = this.toArray();
        T[] bag2 = other.toArray();
        
        ArrayBag<T> differenceBag = new ArrayBag<>(bag1.length);
        
        // Take full elements from the set first
        for (T item : bag1) {
            differenceBag.add(item);
        }
        
        // Subtract common items in Set 1 and Set 2
        for (T item : bag2) {
            if (differenceBag.contains(item)) {
                differenceBag.remove(item);
            }
        }
        
        return differenceBag;
    }
    
    // extra implement the NOT complement function
    // all the elements outside nothing = 0? which elements or let say the element is apart from this
    /**
     * Return the complement of A in two collections A and B
     * @param other the bag that complement with
     * @return the complement of the current bag
     */
    @Override
    public BagInterface<T> complement(BagInterface<T> other){
        if (other == null) {
            throw new NullPointerException("The other bag can not be empty!");
        }
        
        T[] bag1 = this.toArray();
        T[] bag2 = other.toArray();
        
        // Capacity optimization: complement size ≤ other bag's size
        // because we only keep items from 'other' with excess counts
        ArrayBag<T> complementBag = new ArrayBag<>(bag2.length);
        
        // Method 1:
        // Complement means Union - Bag A where union is ignored in this case
        // so we can know it means Bag B - Bag A
//        for (T item: bag2) {
//            complementBag.add(item);
//        }
//        for (T item1: bag1) {
//            if (complementBag.contains(item1)) {
//                complementBag.remove(item1);
//            }
//        }

        // Method 2: Utilize frequency of each element
        // More effiency in time complexity
        for (T item : bag2) {
            // avoid duplicate processing using contains
            // ensures each unique item is processed only once
            if (item == null || complementBag.contains(item)) {
                continue;
            }
            
            int thisCount = this.getFrequencyOf(item);
            int otherCount = other.getFrequencyOf(item);
            int diff = otherCount - thisCount;
            
            if (diff > 0) {
                for (int i = 0; i < diff; i++) {
                    complementBag.add(item);
                }
            }
        }
        
        return complementBag;
    }
}
