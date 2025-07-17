/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 */
class Entry{
    String key;
    String value;
    Entry next;
    
    public Entry(){
        this(null, null);
    }
    
    public Entry(String key, String value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
    
    public String getValue(){
        return value;
    }
}

public class MyHashMap {
    private Entry[] table;
    private int capacity;
    private final static int DEFAULT_CAPACITY = 16;
    
    public MyHashMap(){
        this(DEFAULT_CAPACITY);
    }
    
    public MyHashMap(int capacity){
        this.capacity = capacity;
        this.table = new Entry[capacity];
    }
    
    // Helper method to hash the key
    private int hash(String key){
        if (key == null) {
            return 0;
        }
        return key.hashCode() % capacity;
    }
    
    public Entry get(String key){
        int index = hash(key);
        Entry current = table[index];
        
        while (current != null) {
            if (current.key.equals(key)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    public void put(String key, String value){
        int index = hash(key);
        Entry current = table[index];
        
        if (current == null) {
            table[index] = new Entry(key, value);
        }else{
            while (current != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = new Entry(key, value);
        }
    }
    
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        
        myHashMap.put("BruceW", "011-8998990");
        myHashMap.put("DeanW", "017-2274000");
        myHashMap.put("TonyS", "019-4550800");
        myHashMap.put("LaraC", "014-6402009");
        
        Entry e1 = myHashMap.get("DeanW");
        System.out.println("Value: " + e1.getValue());
        Entry e2 = myHashMap.get("TonyS");
        System.out.println("Value: " + e2.getValue());
        
        myHashMap.put("BruceW", "011-5677900");
        Entry e3 = myHashMap.get("BruceW");
        System.out.println("Value: " + e3.getValue());
        
        myHashMap.put("JeanG", "019-9001123");
        Entry e4 = myHashMap.get("JeanG");
        System.out.println("Value: " + e4.getValue());
    }
}
