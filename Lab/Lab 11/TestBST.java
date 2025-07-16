/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BST;

/**
 *
 * @author tianlongc
 */
public class TestBST {
    public static void main(String[] args) {
        Integer[] data = {45, 88, 54, 76, 98, 1, 2, 20, 6, 53, 42, 100, 86, 32, 28, 65, 14};
        BST<Integer> bst = new BST<>(data);
        
        System.out.print("Input Data: ");
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d%s", data[i], i != data.length-1 ? ", ":"\n");
        }
        
        System.out.print("Inorder (sorted): "); // Inorder always give ascending order of a list
        bst.inorder(bst.root);
        System.out.println("");
        
        System.out.print("Postorder: ");
        bst.postorder(bst.root);
        System.out.println("");
        
        System.out.print("Preorder: ");
        bst.preorder(bst.root);
        System.out.println("");
        
        System.out.println("Height of BST: " + bst.height());
        System.out.println("Root for BST is: " + bst.getRoot());
        System.out.println("Check whether 10 is in the tree? " + bst.search(10));
        System.out.printf("%s\n", bst.delete(53) ? "Delete 53": "");
        
        System.out.print("Updated Inorder data (sorted): ");
        bst.inorder(bst.root);
        System.out.println("");
        
        System.out.println("Min Value:" + bst.minValue());
        System.out.println("Max Value:" + bst.maxValue());
        System.out.print("A path from the root to 6 is: ");
        for (TreeNode<Integer> node : bst.path(6)) {
            System.out.print(node.element + " ");
        }
        System.out.println("");
    }
}
