/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BST;

/**
 *
 * @author tianlongc
 * @param <E> generic type parameter named element
 */
public class BST<E extends Comparable<E>>{
    protected TreeNode<E> root;
    protected int size;
    
    public BST(){
        this.root = null;
        this.size = 0;
    }
    
    public BST(E[] objects){
        for (E object : objects) {
            insert(object);
        }
    }
    
    /* Returns true if the element is in the tree */
    public boolean search(E e){
        TreeNode<E> current = root; // Start from the root
        while (current != null) {
            if (e.compareTo(current.element) == 0) {
                return true;
            }
            current = e.compareTo(current.element) < 0 ? current.left: current.right;
        }
        return false;
    }
    
    /* Insert element o into the binary tree and
       return true if the element is inserted successfully */
    public boolean insert(E e){
        if (root == null) {
            root = new TreeNode<>(e);
        }else{
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) == 0) {
                    return false; // Duplicate node not inserted
                }
                parent = current;
                current = (e.compareTo(current.element) < 0) ? current.left : current.right;
            }
            
            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<>(e);
            }else{
                parent.right = new TreeNode<>(e);
            }
        }
        size++;
        return true; // Element inserted successfully
    }
    
    /* Get the number of nodes in the tree */
    public int getSize(){
        return size;
    }
    
    /* Return the height of the BST */
    public int height(){
        return height(root);
    }
    
    /* Return the height of the BST */
    private int height(TreeNode<E> node){
        if (node == null) {
            return -1; // Base case: empty subtree has height -1
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    /* Return the root of the BST */
    public E getRoot(){
        return this.root.element;
    }
    
    /* Return the minimum value of the BST */
    public E minValue(){
        // minimum is always the leftmost node
        TreeNode<E> current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.element;
    }
    
    /* Return the maximum value of the BST */
    public E maxValue(){
        // maximum is always the rightmost node
        TreeNode<E> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.element;
    }
    
    /* Return a path from the root leading to the specified element */
    public java.util.ArrayList<TreeNode<E>> path(E e){
//        if (root == null || !search(e)) {
//            return null; // early exit for non-existence element
//        }
        java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
        TreeNode<E> current = root; // Start from the root
        
        while (current != null) {
            list.add(current);
            if (e.compareTo(current.element) == 0) {
                return list; // Found: return the path
            }
            current = e.compareTo(current.element) < 0 ? current.left : current.right;
        }
        return null; // without the need to traverse the second time
    }
    
    /*
        Delete an element from the binary tree.
        Return true if the element is deleted successfully,
        and return false if the element is not in the tree
    */
    public boolean delete(E e){
//        if (root == null || !search(e)) {
//            return false; // early termination for non-existence element
//        }
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        
        while (current != null) {
            if (e.compareTo(current.element) == 0) {
                break;
            }
            parent = current;
            current = e.compareTo(current.element) < 0 ? current.left : current.right;
        }
        // Can be checked using search function for early termination
        if (current == null) {
            return false; // element is not in the tree
        }
        
        // Case 1: current has no left child
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            }else{
                if (e.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                }else{
                    parent.right = current.right;
                }
            }
        }else{
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;
            
            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }
            
            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;
            
            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost) {
                parentOfRightMost.right = rightMost.left;
            }else{
                // Special case: parentOfRightMost == curent
                parentOfRightMost.left = rightMost.left;
            }
        }
        size--;
        return true; // element deleted successfully
    }
    
    /* Remove all elements from the tree */
    public boolean clear(){
        this.root = null;
        this.size = 0;
        return true;
    }
    
    /* Display inorder traversal from a subtree */
    protected void inorder(TreeNode<E> root){
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }
    
    /* Display postorder traversal from a subtree */
    protected void postorder(TreeNode<E> root){
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }
    
    /* Display preorder traversal from a subtree */
    protected void preorder(TreeNode<E> root){
        if (root == null) {
            return;
        }
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
