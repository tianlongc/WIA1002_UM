/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q6;

/**
 *
 * @author tianlongc
 */
public class Q6 {
    public static void main(String[] args) {
        Integer[] numbers = {34, 27, 12, 18, 31, 29, 33, 56, 36, 40, 38, 66, 64, 100, 99};
        
        BST<Integer> bst = new BST<>(numbers);
        
        // (a)
        System.out.print("Inorder: ");
        bst.inorder();
        
        System.out.print("Preorder: ");
        bst.preorder();
        
        System.out.print("Postorder: ");
        bst.postorder();
        
        /*
            Inorder: 12 18 27 29 31 33 34 36 38 40 56 64 66 99 100 
            Preorder: 34 27 12 18 31 29 33 56 36 40 38 66 64 100 99 
            Postorder: 18 12 29 33 31 27 38 40 36 64 99 100 66 56 34
        */
        
        // (b) node deletion
        Integer[] deleteNumbers = {12, 34, 66};
         
        for (Integer deleteNumber : deleteNumbers) {
            BST<Integer> bstRemove = new BST<>(numbers); // resets each time for each delete number
            // Test original implementation
            System.out.println("\nDelete rightmost: " + deleteNumber);
            bstRemove.deleteRightMost(deleteNumber);

            System.out.print("Preorder: ");
            bstRemove.preorder();

            System.out.print("Postorder: ");
            bstRemove.postorder();
            
            bstRemove = new BST<>(numbers); // resets each time for each delete number
            
            // Test reimplemented solution
            System.out.println("\nDelete leftmost: " + deleteNumber);
            bstRemove.deleteLeftMost(deleteNumber);

            System.out.print("Preorder: ");
            bstRemove.preorder();

            System.out.print("Postorder: ");
            bstRemove.postorder();
        }
        
        /*  ️<!> To compare the result of different deletion strategies in a BST, 
                focus on preorder and postorder traversals
        
            Node deletion: 12
            
            Original: Delete rightmost of left subtree
            Preorder: 34 27 18 31 29 33 56 36 40 38 66 64 100 99 
            Postorder: 18 29 33 31 27 38 40 36 64 99 100 66 56 34 
            
            Reimplemented: Delete leftmost of right subtree
            Preorder: 34 27 18 31 29 33 56 36 40 38 66 64 100 99 
            Postorder: 18 29 33 31 27 38 40 36 64 99 100 66 56 34
        
            Both methods give same result since 12 has only one child (unique replacement)
        
            Node deletion: 34
        
            Original: Delete rightmost of left subtree
            Preorder: 33 27 12 18 31 29 56 36 40 38 66 64 100 99 
            Postorder: 18 12 29 31 27 38 40 36 64 99 100 66 56 33  
            
            Reimplemented: Delete leftmost of right subtree
            Preorder: 36 27 12 18 31 29 33 56 40 38 66 64 100 99 
            Postorder: 18 12 29 33 31 27 38 40 64 99 100 66 56 36
            
            In original solution, Node 34 is replaced by Node 33
            In the reimplemented solution, Node 34 is replaced by node 36
        
            Node deletion: 66
            
            Original: Delete rightmost of left subtree
            Preorder: 34 27 12 18 31 29 33 56 36 40 38 64 100 99 
            Postorder: 18 12 29 33 31 27 38 40 36 99 100 64 56 34 

            Reimplemented: Delete leftmost of right subtree
            Preorder: 34 27 12 18 31 29 33 56 36 40 38 99 64 100 
            Postorder: 18 12 29 33 31 27 38 40 36 64 100 99 56 34 
        
            In original solution, Node 66 is replaced by Node 64
            In the reimplemented solution, Node 66 is replaced by node 99
        */
        
        // (c) Binary Search Tree to Circular Doubly Linked List
        TreeNode<Integer> head = bst.toCircularDoublyLinkedList();
        
        System.out.println("\nBinary Search Tree to Circular Doubly Linked List:");
        bst.displayCDLL(head); // should be in order
    }
}
