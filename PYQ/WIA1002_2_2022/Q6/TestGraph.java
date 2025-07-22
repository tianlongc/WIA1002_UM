/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q6;

/**
 *
 * @author tianlongc
 */
import java.util.ArrayList;

public class TestGraph {
    public static void main(String[] args) {
        RoutingGraph<String, Double> graph = new RoutingGraph<>();
        graph.addVertex("A", "Housing Area");
        graph.addVertex("B", "Food Area");
        graph.addVertex("C", "Housing Area");
        graph.addVertex("D", "Food Area");
        graph.addVertex("E", "Food Area");
        graph.addVertex("F", "Industry Area");
        graph.addVertex("G", "Industry Area");
        
        System.out.println("The number of vertices in MyCityGraph: " + graph.getSize());
        
        System.out.println("List all vertices:");
        for (int i = 0; i < graph.getSize(); i++)
           System.out.print(i+ ": " + graph.getVertex(i) + "\t");
        System.out.println();
        
        graph.addEdge("A", "B", 7.0);
        graph.addEdge("A", "C", 10.1);
        graph.addEdge("B", "A", 7.0);
        graph.addEdge("B", "C", 5.5);
        graph.addEdge("B", "E", 3.2);
        graph.addEdge("C", "B", 5.5);
        graph.addEdge("C", "D", 8.3);
        graph.addEdge("D", "G", 4.9); // not shown in diagram
        graph.addEdge("E", "D", 2.9);
        graph.addEdge("E", "G", 6.0);
        graph.addEdge("E", "F", 4.0);
        graph.addEdge("F", "G", 2.3);
        graph.addEdge("G", "E", 6.0);
        
        System.out.println("Has edge from B to A? " + graph.hasEdge("B", "A"));
        System.out.println("Has edge from A to D? " + graph.hasEdge("A", "D"));
        
        System.out.println("\nFind all neighbours of B : " + graph.getNeighbours("B"));
        
        graph.printEdges(); // C and D speed ERRATA i guess
        
        // Hardcode because we need to follow the specific distance for the path
        String[][] paths = {
            {"A", "B", "C", "D", "G"},
            {"A", "B", "E", "G"},
            {"A", "C", "B", "E", "F", "G"},
            {"A", "B", "E", "D", "G"},
            {"A", "C", "D", "G"}
        };

//        ArrayList<ArrayList<String>> allPaths = graph.getAllPaths("A", "G");
        
//        for (ArrayList<String> allPath : allPaths) {
//            System.out.println(allPath);
//        }
        
//        ArrayList<ArrayList<String>> paths = new ArrayList<>();
//        paths.add(new ArrayList<>(allPaths.get(7)));
//        paths.add(new ArrayList<>(allPaths.get(5)));
//        paths.add(new ArrayList<>(allPaths.get(1)));
//        paths.add(new ArrayList<>(allPaths.get(6)));
//        paths.add(new ArrayList<>(allPaths.get(0)));
//        
//        for (ArrayList<String> path : paths) {
//            System.out.println(path);
//        }
        
        double[] distance = new double[paths.length];
        double[] duration = new double[paths.length];
        
        for (int i = 0; i < paths.length; i++) {
            System.out.print("Path " + (i+1) + ": [");
            distance[i] = calculateDistance(paths[i], graph);
            duration[i] = calculateDuration(paths[i], graph);
            for (int j = 0; j < paths[i].length; j++) {
                System.out.printf("%s%s", paths[i][j], j != paths[i].length-1 ? ", ": "]\n");
            }
            System.out.printf("Distance= %.2f km, Duration= %.2f min\n", distance[i], duration[i]);
        }
        
        sortDistance(distance);
        sortDuration(duration);
    }
    
    public static double calculateDistance(String[] vertices, RoutingGraph<String, Double> graph){
        double distance = 0.0;
        for (int i = 0; i < vertices.length-1; i++) {
            distance += graph.getDistance(vertices[i], vertices[i+1]);
        }
        return distance;
    }
    
    public static double calculateDuration(String[] vertices, RoutingGraph<String, Double> graph){
        double duration = 0.0;
        for (int i = 0; i < vertices.length-1; i++) {
            duration += (graph.getDistance(vertices[i], vertices[i+1])) * (graph.getSpeed(vertices[i], vertices[i+1]));
        }
        return duration;
    }
    
    public static void sortDistance(double[] distance){
        System.out.println("\nAfter Bubble Sort:");
        int[] path = new int[distance.length];
        for (int i = 0; i < distance.length; i++) {
            path[i] = i+1;
        }
        for (int i = 0; i < distance.length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < distance.length-i-1; j++) {
                if (distance[j] > distance[j+1]) {
                    // Swap distance
                    double temp = distance[j];
                    distance[j] = distance[j+1];
                    distance[j+1] = temp;
                    // Swap index
                    int tempI = path[j];
                    path[j] = path[j+1];
                    path[j+1] = tempI;
                    isSwap = true;
                }
            }
            if (!isSwap) break;
        }
        
        for (int i = 0; i < path.length; i++) {
            System.out.printf("Path %d (%.2f km)\n", path[i], distance[i]);
        }
    }
    
    public static void sortDuration(double[] duration){
        System.out.println("\nAfter Insertion Sort:");
        int[] path = new int[duration.length];
        for (int i = 0; i < duration.length; i++) {
            path[i] = i+1;
        }
        
        for (int i = 1; i < duration.length; i++) {
            double currentElement = duration[i];
            int currentIndex = path[i], k;
            
            for (k = i-1; (k >= 0) && (duration[k] < currentElement); k--) {
                duration[k+1] = duration[k];
                path[k+1] = path[k];
            }
            duration[k+1] = currentElement;
            path[k+1] = currentIndex;
        }
        
        for (int i = 0; i < path.length; i++) {
            System.out.printf("Path %d (%.2f min)\n", path[i], duration[i]);
        }
    }
}


