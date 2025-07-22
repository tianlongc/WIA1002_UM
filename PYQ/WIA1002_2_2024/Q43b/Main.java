/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q43b;

/**
 *
 * @author tianlongc
 */
public class Main {
    public static void main(String[] args) {
        Car[] cars = {
            new Car("Gotham Gray", "Toyota", "JWY854"),
            new Car("Goodwood Green", "Honda", "KFT9062"),
            new Car("Daybright Blue", "Proton", "DEX6980"),
            new Car("Polymimetic Gray", "Perodua", "VMG3054"),
            new Car("Gold Mercury", "BMW", "MDU6304"),
            new Car("Sepia Metallic", "Tesla", "CEW5309"),
            new Car("Cyber Yellow", "Audi", "PPRE4685"),
            new Car("Panther Black", "Mercedes", "RAU2461")
        };
        
        BST registry = new BST();
        
        // Construct the BST
        TreeNode<Car> root = registry.constructBST(cars);
        
        // Print the list of cars in alphabetical order
        System.out.println("List of the cars in alphabetical order:");
        registry.printInAlphabeticalOrder(root);
        
        // Search for a car by pplate number and print its colour and model
        String plateNumberToSearch = "DEX6980";
        String carInfo = registry.search(root, plateNumberToSearch);
        System.out.println("\nCar information for plate number " + plateNumberToSearch + ": " + carInfo);
    }
}
