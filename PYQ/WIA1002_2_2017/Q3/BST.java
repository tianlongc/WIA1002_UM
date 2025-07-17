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
import java.util.Stack;

public class BST<E extends Comparable<E>>{
    protected TreeNode<E> root;
    protected int size;
    
    public BST(){
        this.root = null;
        this.size = 0;
    }
    
    public boolean add(TreeNode<E> node, E item){
        TreeNode<E> newNode = new TreeNode<>(item);
        
        if (root == null) {
            root = node;
            size++;
        }
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (item.compareTo(current.item) == 0) {
                return false; // Duplicate element not inserted
            }
            parent = current;
            current = (item.compareTo(current.item) < 0) ? current.left: current.right;
        }
        
        // Create the new node and attach it to the parent node
        if (item.compareTo(parent.item) < 0) {
            parent.left = newNode;
        }else{
            parent.right = newNode;
        }
        size++;
        return true;
    }
    
    public void printTreeInOrder(){
        if (root == null) {
            System.out.println("The tree is empty!");
            return;
        }
        Stack<TreeNode<E>> stack = new Stack<>();
        TreeNode<E> current = root;
        
        // explore left subtree || nodes in the stack to backtrack
        while (current != null || !stack.isEmpty()) {
            if (current != null) { 
                stack.push(current); // revisit later
                current = current.left; // reach until the leftmost
            }else{
                current = stack.pop(); // backtrack
                System.out.print(current.item + " ");
                current = current.right; // explore right subtree
            }
        }  
    }
    
    public boolean contains(E item){
        TreeNode<E> current = root;
        while (current != null) {
            if (item.compareTo(current.item) == 0) {
                return true;
            }
            current = (item.compareTo(current.item) < 0) ? current.left: current.right;
        }
        return false;
    }
    
    
}
