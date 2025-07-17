/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4b;

/**
 *
 * @author tianlongc
 * @param <E> generic type parameter named element
 */
public class TreeNode<E>{
    E element;
    TreeNode<E> left;
    TreeNode<E> right;
    
    public TreeNode(E o){
        this.element = o;
        this.left = null;
        this.right = null;
    }
}
