/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author tianlongc
 * Modified from L11
 */
public class TestBST {
    public static void main(String[] args) {
        Integer[] data = {45, 27, 13, 25, 18, 39, 30, 42, 28, 33, 41, 66, 82, 80};
        BST<Integer> bst = new BST<>(data);
        
        System.out.print("Input Data: ");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%s%s", data[i], i != data.length-1 ? ", ":"\n");
        }
        
        System.out.print("Inorder (sorted): ");
        bst.inorder(bst.root);
        System.out.println("");
        
        System.out.print("Postorder: ");
        bst.postorder(bst.root);
        System.out.println("");
        
        System.out.print("Preorder: ");
        bst.preorder(bst.root);
        System.out.println("");
    }
}
