/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L8Q3Q4;

/**
 *
 * @author tianlongc
 */
public class TestUnweightedGraph {
    public static void main(String[] args) {
        Graph<String> graph1 = new Graph<>();
        String[] cities = {"Alor Setar", "Kuching", "Langkawi", "Melaka", "Penang", "Tawau"};
        for (String city : cities) {
            graph1.addVertex(city);
        }
        System.out.println("The number of vertices in graph1: " + graph1.getSize());
        
        System.out.println("Cities and their vertices ");
        for (int i = 0; i < graph1.getSize(); i++) {
            System.out.printf("%d : %s\t", i, graph1.getVertex(i));
        }
        System.out.println("");
        
        System.out.println("Is Melaka in the Graph? " + graph1.hasVertex("Melaka"));
        System.out.println("Is Ipoh in the Graph? " + graph1.hasVertex("Ipoh"));
        System.out.println("");
        
        System.out.println("Kuching at index: " + graph1.getIndex("Kuching"));
        System.out.println("Ipoh at index: " + graph1.getIndex("Ipoh"));
        System.out.println("");
        
        System.out.println("add edge Kuching - Melaka: " + graph1.addUndirectedEdge("Kuching", "Melaka"));
        System.out.println("add edge Langkawi - Penang : " + graph1.addUndirectedEdge("Langkawi", "Penang"));
        System.out.println("add edge Melaka - Penang : " + graph1.addUndirectedEdge("Melaka", "Penang"));
        System.out.println("add edge Alor Setar - Kuching : " + graph1.addUndirectedEdge("Alor Setar", "Kuching"));
        System.out.println("add edge Tawau - Alor Setar : " + graph1.addUndirectedEdge("Tawau", "Alor Setar"));
        System.out.println("add edge Kuching - Tawau : " + graph1.addUndirectedEdge("Kuching", "Tawau"));
        System.out.println("add edge Langkawi - Ipoh : " + graph1.addUndirectedEdge("Langkawi", "Ipoh"));
        System.out.println("");
        
        System.out.println("has edge from Kuching to Melaka? " + graph1.hasEdge("Kuching", "Melaka"));
        System.out.println("has edge from Melaka to Langkawi? " + graph1.hasEdge("Melaka", "Langkawi"));
        System.out.println("has edge from Ipoh to Langkawi? " + graph1.hasEdge("Ipoh", "Langkawi"));
        System.out.println("");
        
        System.out.printf("In and out degree for Kuching is %d and %d\n", graph1.getIndeg("Kuching"), graph1.getOutdeg("Kuching"));
        System.out.printf("In and out degree for Penang is %d and %d\n", graph1.getIndeg("Penang"), graph1.getOutdeg("Penang"));
        System.out.printf("In and out degree for Ipoh is %d and %d\n", graph1.getIndeg("Ipoh"), graph1.getOutdeg("Ipoh"));
        System.out.println("");
        
        System.out.println("Neighbours of Kuching : " + graph1.getNeighbours("Kuching"));
        System.out.println("\nPrint Edges : ");
        graph1.printEdges();
    }
}
