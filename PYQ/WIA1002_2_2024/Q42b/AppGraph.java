/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q42b;

/**
 *
 * @author tianlongc
 */
public class AppGraph {
    public static void main(String[] args) {
        WeightedGraph<String, Integer> graph1 = new WeightedGraph<>();
        String[] cities = {"Alor Setar", "Kuching", "Langkawi", "Melaka", "Penang", "Tawau"};
        for (String i : cities)
           graph1.addVertex(i);

        graph1.addEdge("Alor Setar", "Kuching", 9);
        graph1.addEdge("Langkawi", "Penang", 1);
        graph1.addEdge("Melaka", "Penang", 4);
        graph1.addEdge("Kuching", "Tawau", 9);
        graph1.addEdge("Kuching", "Melaka", 8);
        
        int[][] adjMatrix = graph1.adjMatrix();
        displayAdjMatrix(adjMatrix);
        System.out.println("");
        graph1.traverseTree(graph1.getVertex(0));
    }
    
    public static void displayAdjMatrix(int[][] adjMatrix){
        System.out.println("Adjacency Matrix:");
        
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
