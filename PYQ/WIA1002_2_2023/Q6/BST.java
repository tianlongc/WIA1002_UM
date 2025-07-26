/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q6;

/**
 *
 * @author tianlongc
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
        return true;
    }
    
    public int getSize(){
        return size;
    }
    
    // Replaces `e` with leftmost node of its right subtree (in-order successor)
    public boolean deleteLeftMost(E e){
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        
        while (current != null) {
            if (e.compareTo(current.element) == 0) {
                break;
            }
            parent = current;
            current = (e.compareTo(current.element) < 0) ? current.left : current.right;
        }
        
        if (current == null) {
            return false; // element not found
        }
        
        // Case 1: current has no right child
        if (current.right == null) {
            if (parent == null) {
                root = current.left;
            }else{
                if (e.compareTo(parent.element) < 0) {
                    parent.left = current.left;
                }else{
                    parent.right = current.left;
                }
            }
        }else{
            // Case 2: The current node has a right child
            // Locate the leftmost node in the right subtree of
            // the current node and also its parent
            TreeNode<E> parentOfLeftMost = current;
            TreeNode<E> leftMost = current.right;
            
            while (leftMost.left != null) {
                parentOfLeftMost = leftMost;
                leftMost = leftMost.left; // Keep going to the left
            }
            // Replace the element in the current by the element in rightMost
            current.element = leftMost.element;
            
            // Eliminate leftmost node
            if (parentOfLeftMost.left == leftMost) {
                parentOfLeftMost.left = leftMost.right;
            }else{
                // Special case: parentOfRightMost == current
                parentOfLeftMost.right = leftMost.right;
            }
        }
        size--;
        return true; // element deleted successfully
    }
    
    // Replaces `e` with rightmost node of its left subtree (in-order predecessor)
    public boolean deleteRightMost(E e){
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
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
            }
        }
        size--;
        return true; // element deleted successfully
    }
    
    public void preorder(){
        preorder(root);
        System.out.println("");
    }
    
    private void preorder(TreeNode current){
        if (current == null) {
            return;
        }
        System.out.print(current.element + " ");
        preorder(current.left);
        preorder(current.right);
    }
    
    public void inorder(){
        inorder(root);
        System.out.println("");
    }
    
    private void inorder(TreeNode current){
        if (current == null) {
            return;
        }
        inorder(current.left);
        System.out.print(current.element + " ");
        inorder(current.right);
    }
    
    public void postorder(){
        postorder(root);
        System.out.println("");
    }
    
    private void postorder(TreeNode<E> current){
        if (current == null) {
            return;
        }
        postorder(current.left);
        postorder(current.right);
        System.out.print(current.element + " ");
    }
    
    public TreeNode<E> toCircularDoublyLinkedList(){
        return toCircularDoublyLinkedList(root);
    }
    
    private TreeNode<E> toCircularDoublyLinkedList(TreeNode<E> root){
        if (root == null) return null;
        
        TreeNode<E> left = toCircularDoublyLinkedList(root.left);
        TreeNode<E> right = toCircularDoublyLinkedList(root.right);
        
        // Make the current node into a 1-node circular doubly linked list
        // ready to be stitched with left and right CDLLs recursively
        root.left = root.right = root;
        
        return concatenate(concatenate(left, root), right);
    }
    
    private TreeNode<E> concatenate(TreeNode leftList, TreeNode rightList){
        if (leftList == null) return rightList;
        if (rightList == null) return leftList;
        
        // Store the last node
        TreeNode<E> leftLast = leftList.left;
        TreeNode<E> rightLast = rightList.left;
        
        // Connect left's last node to right's first node
        leftLast.right = rightList;
        rightList.left = leftLast;
        
        /* Maintain circularity by
           - Connect left's first node to right's last node
           - Connect right's first node to left's last node
        */
        leftList.left = rightLast;
        rightLast.right = leftList;
        
        // return the head of the list
        return leftList;
    }
    
    public void displayCDLL(TreeNode<E> root){
        if (root == null) return;
        
        TreeNode<E> current = root;
        do {
            System.out.print(current.element + " ");
            current = current.right;
        } while (current != root);
        System.out.println("");
    }
}
