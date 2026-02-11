/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 */

public class TestGraph {
    public static void main(String[] args) {
        // (a) Create the graph
        RoutingGraph<String, Double> graph = new RoutingGraph<>(1.5); // Sample output use x = 1.0
        
        graph.addVertex("Jericho", "Residential Area");
        graph.addVertex("Grandpoint Park", "Residential Area"); // assume Residential Area
        graph.addVertex("Summertown", "Residential Area");
        graph.addVertex("Botley Market", "Commercial Centre");
        graph.addVertex("Cowley Road", "Commercial Centre");
        graph.addVertex("Sunnymeade Food Street", "Commercial Centre");
        graph.addVertex("OxCity Grocer", "Commercial Centre");
        graph.addVertex("The Folly", "Commercial Centre");
        graph.addVertex("Little Clarendon", "School Area");
        graph.addVertex("The UniOx", "School Area");
        
        System.out.println("The number of vertices in MyCityGraph: " + graph.getSize());

        System.out.println("List all vertices:");
        for (int i = 0; i < graph.getSize(); i++)
           System.out.print(i+ ": " + graph.getVertex(i) + " \t");
        System.out.println();

        graph.addBidirectedEdge("Jericho", "Botley Market", 3.1); // diagram uses 3.7 sample output use 3.1
        graph.addEdge("Jericho", "Sunnymeade Food Street", 5.3);
        graph.addBidirectedEdge("Jericho", "OxCity Grocer", 6.0);
        graph.addEdge("Jericho", "Grandpoint Park", 4.7);
        graph.addBidirectedEdge("Grandpoint Park", "Summertown", 3.5);
        graph.addBidirectedEdge("Summertown", "Little Clarendon", 5.5);
        graph.addEdge("Botley Market", "Sunnymeade Food Street", 2.3);
        graph.addEdge("Botley Market", "Cowley Road", 8.1);
        graph.addEdge("Cowley Road", "The UniOx", 2.1);
        graph.addBidirectedEdge("OxCity Grocer", "Little Clarendon", 1.9);
        graph.addEdge("OxCity Grocer", "The Folly", 4.2);
        graph.addBidirectedEdge("Sunnymeade Food Street", "OxCity Grocer", 2.6);
        graph.addEdge("Sunnymeade Food Street", "Cowley Road", 3.0);
        graph.addEdge("The UniOx", "The Folly", 3.3);
        graph.addBidirectedEdge("Sunnymeade Food Street", "The UniOx", 3.8);
        graph.addEdge("The Folly", "Sunnymeade Food Street", 2.7);
        graph.addEdge("Little Clarendon", "The UniOx", 7.8);
        // ignore The UniOx to Cowley Road edge as not in diagram

        System.out.println("Has edge from Little Clarendon to Summertown?  " + graph.hasEdge("Little Clarendon", "Summertown"));
        System.out.println("Has edge from Summertown to The UniOx?  " + graph.hasEdge("Summertown", "The UniOx"));

        System.out.println("\nFind all neighbours of OxCity Grocer : " + graph.getNeighbours("OxCity Grocer"));

        graph.printEdges();

        /* (b) 
            - List 2 possible paths from Jericho to The UniOx
            - List 2 possible paths from Summertown to The UniOx
            - For each path, calculate the total distance and total time taken using two methods
              * calculateDistance()
              * calculateDuration()
            - Each vertex can be visited only once in a path
        */
        // Hardcoded solution
        String[][] paths = {
            {"Jericho", "Botley Market", "Cowley Road", "The UniOx"},
            {"Jericho", "OxCity Grocer", "Little Clarendon", "The UniOx"},
            {"Summertown", "Little Clarendon", "OxCity Grocer", "Sunnymeade Food Street", "The UniOx"},
            {"Summertown", "Little Clarendon", "The UniOx"}
        };

        double[] distance = new double[paths.length];
        double[] duration = new double[paths.length];

        System.out.println("\nFrom Jericho To The UniOx:");
        for (int i = 0; i < 2; i++) {
            distance[i] = calculateDistance(graph, paths[i]);
            duration[i] = calculateDuration(graph, paths[i]);
            System.out.print("Path " + (i+1) + ": [");
            for (int j = 0; j < paths[i].length; j++) {
                System.out.printf("%s%s", paths[i][j], (j != paths[i].length - 1) ? ", " : "]\n");
            }
            System.out.printf("Distance=%.1fkm, Duration=%.2fmin\n", distance[i], duration[i]);
        }
        System.out.println("From Summertown To The UniOx:");
        for (int i = 2; i < 4; i++) {
            distance[i] = calculateDistance(graph, paths[i]);
            duration[i] = calculateDuration(graph, paths[i]);
            System.out.print("Path " + (i+1) + ": [");
            for (int j = 0; j < paths[i].length; j++) {
                System.out.printf("%s%s", paths[i][j], (j != paths[i].length - 1) ? ", " : "]\n");
            }
            System.out.printf("Distance=%.1fkm, Duration=%.2fmin\n", distance[i], duration[i]);
        }

        // (c) Indicate the shortest distance and shortest time based on all selected paths in (b)
        System.out.println("\nShortest Distance (km):");
        int minDistanceIndex = findIndexOfMin(distance);
        System.out.printf("Path %d (%.1fkm)\n", (minDistanceIndex+1), distance[minDistanceIndex]);
        
        System.out.println("\nShortest Time (min):");
        int minDurationIndex = findIndexOfMin(duration);
        System.out.printf("Path %d (%.2fmin)\n", (minDurationIndex+1), duration[minDurationIndex]);

        // My Recommendation: Choose the shortest time path for the fastest commute
        System.out.printf("\nYou are recommended to stay in [%s].\n", paths[minDurationIndex][0]);
    }

    public static double calculateDistance(RoutingGraph<String, Double> graph, String[] vertices) {
        double distance = 0.0;
        for (int i = 0; i < vertices.length - 1; i++) {
            distance += graph.getDistance(vertices[i], vertices[i+1]);
        }
        return distance;
    }

    public static double calculateDuration(RoutingGraph<String, Double> graph, String[] vertices) {
        double duration = 0.0;
        for (int i = 0; i < vertices.length - 1; i++) {
            duration += (graph.getDistance(vertices[i], vertices[i+1]) / graph.getSpeed(vertices[i], vertices[i+1]));
        }
        return duration;
    }

    public static int findIndexOfMin(double[] arr) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex])
                minIndex = i;
        }
        return minIndex;
    }
}