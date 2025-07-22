/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q43b;

/**
 *
 * @author tianlongc
 */
public class BST {
    protected TreeNode<Car> root;
    protected int size;
    
    public BST(){
        this.root = null;
        this.size = 0;
    }
    
    public TreeNode<Car> constructBST(Car[] cars){
        for (Car car : cars) {
            insert(car);
        }
        return root;
    }
    
    public boolean insert(Car car){
        if (root == null) {
            root = new TreeNode<>(car);
        }else{
            // Locate the parent node
            TreeNode<Car> parent = null;
            TreeNode<Car> current = root;
            while (current != null) {
                if (car.compareTo(current.element) == 0) {
                    return false; // Duplicate node not inserted
                }
                parent = current;
                current = (car.compareTo(current.element) < 0) ? current.left : current.right;
            }
            
            // Create the new node and attach it to the parent node
            if (car.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<>(car);
            }else{
                parent.right = new TreeNode<>(car);
            }
        }
        size++;
        return true;
    }
    
    // inorder recursive calls
    public void printInAlphabeticalOrder(TreeNode<Car> root){ 
        if (root == null) { // Base case
            return;
        }
        printInAlphabeticalOrder(root.left);
        System.out.println(root.element);
        printInAlphabeticalOrder(root.right);
    }
    
    public String search(TreeNode<Car> root, String plateNumberToSearch){
        TreeNode<Car> current = root;
        while (current != null) {
            if (plateNumberToSearch.compareTo(current.element.getPlateNumber()) == 0) {
                return String.format("Colour: %s,, Manufacturer: %s", current.element.getColour(), current.element.getModel());
            }
            current = plateNumberToSearch.compareTo(current.element.getPlateNumber()) < 0 ? current.left : current.right;
        }
        return "Car not found";
    }
}
