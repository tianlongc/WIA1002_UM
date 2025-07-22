/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q43b;

/**
 *
 * @author tianlongc
 */
public class TreeNode<E>{
    E element;
    TreeNode<E> left;
    TreeNode<E> right;
    
    public TreeNode(E element){
        this.element = element;
        this.left = null;
        this.right = null;
    }
}
