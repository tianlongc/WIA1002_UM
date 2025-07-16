/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L2Q1;

/**
 *
 * @author tianlongc
 */
public class MyGeneric <E>{
    private E e;
    
    public MyGeneric(){
        
    }
    
    public MyGeneric(E e){
        this.e = e;
    }
    
    public void setE(E e){
        this.e = e;
    } 
    
    public E getE(){
        return e;
    }
    
    public static void main(String[] args) {
        // arg constructor
//        MyGeneric<String> strObj = new MyGeneric<>("Zero");
//        MyGeneric<Integer> intObj = new MyGeneric<>(0);
        
        // Invoke no-arg constructor
        MyGeneric<String> strObj = new MyGeneric<>();
        MyGeneric<Integer> intObj = new MyGeneric<>();
        
        strObj.setE("Zero");
        intObj.setE(0);
        
        System.out.println(strObj.getE());
        System.out.println(intObj.getE());
    }
}
