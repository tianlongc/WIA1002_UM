/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L8;

/**
 *
 * @author tianlongc
 */
public class TestGraph {
    public static void main(String[] args) {
        Graph<String, Integer> graph1 = new Graph<>();
        String[] cities = {"Alor Setar", "Kuching", "Langkawi", "Melaka", "Penang", "Tawau"};
        for (String i : cities)
           graph1.addVertex(i);

        System.out.println("The number of vertices in graph1: " + graph1.getSize());

        System.out.println("Cities and their vertices ");
        for (int i = 0; i<=graph1.getSize()-1; i++)
           System.out.print( i + ": " + graph1.getVertex(i) + "\t");
        System.out.println();

        System.out.println("Is Melaka in the Graph? " + graph1.hasVertex("Melaka"));
        System.out.println("Is Ipoh in the Graph? " + graph1.hasVertex("Ipoh"));
        System.out.println();

        System.out.println("Kuching at index:  " + graph1.getIndex("Kuching"));
        System.out.println("Ipoh at index:  " + graph1.getIndex("Ipoh"));
        System.out.println();

        System.out.println("add edge Kuching - Melaka: " + graph1.addEdge("Kuching", "Melaka"));
        System.out.println("add edge Langkawi - Penang : " + graph1.addEdge("Langkawi", "Penang")); 
        System.out.println("add edge Melaka - Penang : " + graph1.addEdge("Melaka", "Penang"));
        System.out.println("add edge Alor Setar - Kuching : " + graph1.addEdge("Alor Setar", "Kuching"));
        System.out.println("add edge Tawau - Alor Setar : " + graph1.addEdge("Tawau", "Alor Setar"));
        System.out.println("add edge Kuching - Tawau : " + graph1.addEdge("Kuching", "Tawau"));
        System.out.println("add edge Langkawi - Ipoh : " + graph1.addEdge("Langkawi", "Ipoh"));
        System.out.println();

        System.out.println("has edge from Kuching to Melaka?  " + graph1.hasEdge("Kuching", "Melaka") );
        System.out.println("has edge from Melaka to Langkawi?  " + graph1.hasEdge("Melaka", "Kuching") );
        System.out.println("has edge from Ipoh to Langkawi?  " + graph1.hasEdge("Ipoh", "Langkawi") );
        System.out.println();

        System.out.println("In and out degree for Kuching is " + graph1.getIndeg("Kuching") + " and " + graph1.getOutdeg("Kuching") );
        System.out.println("In and out degree for Penang is " + graph1.getIndeg("Penang") + " and " + graph1.getOutdeg("Penang") );
        System.out.println("In and out degree for Ipoh is " + graph1.getIndeg("Ipoh") + " and " + graph1.getOutdeg("Ipoh") );
        System.out.println();

        System.out.println("Neighbours of Kuching : " + graph1.getNeighbours("Kuching"));
        
   }
}
