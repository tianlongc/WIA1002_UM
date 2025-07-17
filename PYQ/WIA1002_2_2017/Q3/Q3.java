/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 */
public class Q3 {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        
        System.out.println("Adding elements to the binary tree...");
        TreeNode<Integer> root = new TreeNode<>(60);
        bst.add(root, 55);
        bst.add(root, 45);
        bst.add(root, 100);
        bst.add(root, 67);
        bst.add(root, 107);
        bst.add(root, 57);
        bst.add(root, 59);
        bst.add(root, 101);
        
        System.out.println("\nPrinting binary tree in order:");
        bst.printTreeInOrder();
        
        System.out.println("\n\nChecking if tree contains certain elements...");
        System.out.println("Check whether 10 is in the tree? " + bst.contains(10));
        System.out.println("Check whether 67 is in the tree? " + bst.contains(67));
        System.out.println("Check whether 100 is in the tree? " + bst.contains(100));
    }
}
