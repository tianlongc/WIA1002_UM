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
        this.next = next;
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
    
    private int hash(String key){
        if (key == null) {
            return 0;
        }
        return key.hashCode() % capacity;
    }
    
    public Entry get(String key){
        int index = hash(key);
        
        for (Entry current = table[index]; current != null; current = current.next) {
            if (current.key.equals(key)) {
                return current;
            }
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
        
        System.out.println("New directory entry:");
        myHashMap.put("BruceW", "011-8998990");
        myHashMap.put("DeanW", "017-2274000");
        myHashMap.put("TonyS", "019-4550800");
        myHashMap.put("LaraC", "014-6402009");
        System.out.println("");
        
        System.out.println("Get directory: ");
        Entry e1 = myHashMap.get("DeanW");
        System.out.println("DeanW: " + e1.getValue());
        Entry e2 = myHashMap.get("BruceW");
        System.out.println("BruceW: " + e2.getValue());
        System.out.println("");
        
        System.out.println("Update directory: ");
        myHashMap.put("BruceW", "011-5677900");
        myHashMap.put("JeanG", "019-9001123");
        
        // Get directory
        Entry e3 = myHashMap.get("BruceW");
        System.out.println("BruceW: " + e3.getValue());
        Entry e4 = myHashMap.get("JeanG");
        System.out.println("JeanG: " + e4.getValue());
        System.out.println("");
    }
}
