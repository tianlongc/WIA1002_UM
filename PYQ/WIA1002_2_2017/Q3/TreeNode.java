/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 * @param <E> the generic type parameter named element
 */
public class TreeNode<E>{
    E item;
    TreeNode<E> left;
    TreeNode<E> right;
    
    public TreeNode(){
        this(null);
    }
    
    public TreeNode(E item){
        this.item = item;
        this.left = null;
        this.right = null;
    }
    
    
}
