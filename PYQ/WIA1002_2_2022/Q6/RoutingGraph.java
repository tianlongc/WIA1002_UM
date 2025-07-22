/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q6;


/**
 *
 * @author tianlongc
 * Basic Implementation using Linked List in Graph
 */
import java.util.ArrayList;

public class RoutingGraph<T extends Comparable<T>, N extends Comparable<N>>{
    final static double y = 2.0; // Assume y = 2.0
    private Vertex<T,N> head;
    private int size;
    
    public RoutingGraph(){
        this.head = null;
        this.size = 0;
    }
    
    public int getSize(){
        return size;
    }
    
    public T getVertex(int pos){
        if (pos < 0 || pos >= size) {
            return null;
        }
        Vertex<T,N> current = head;
        for (int i = 0; i < pos; i++) {
            current = current.nextVertex;
        }
        return current.point;
    }
    
    public boolean hasEdge(T source, T destination){
        if (head == null) {
            return false;
        }
        for (Vertex<T,N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex) {
            if (sourceVertex.point.compareTo(source) == 0) {
                for (Edge<T,N> currentEdge = sourceVertex.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge) {
                    if (currentEdge.toVertex.point.compareTo(destination) == 0) {
                       return true; 
                    }
                }
            }
        }
        return false;
    }
    
    public ArrayList<T> getNeighbours(T v){
        ArrayList<T> list = new ArrayList<>();
        for (Vertex<T,N> current = head; current != null; current = current.nextVertex) {
            if (current.point.compareTo(v) == 0) {
                for (Edge<T,N> currentEdge = current.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge) {
                    list.add(currentEdge.toVertex.point);
                }
            }
        }
        return list;
    }
    
    public void printEdges(){
        System.out.println("\nPrint all edges :");
        for (Vertex<T,N> temp = head; temp != null; temp = temp.nextVertex) {
            System.out.printf("# %s : ", temp.point);
            for (Edge<T,N> currentEdge = temp.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge) {
                System.out.printf("[%s,%s(speed=", temp.point, currentEdge.toVertex.point);
                System.out.print(currentEdge.speed + " , distance=" +currentEdge.distance + ")] ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public boolean hasVertex(T v){
        if (head == null) {
            return false;
        }
        for (Vertex<T,N> temp = head; temp != null; temp = temp.nextVertex) {
            if (temp.point.compareTo(v) == 0) {
                return true;
            }
        }
        return false;
    }
    
    public boolean addVertex(T v, T type){
        if (hasVertex(v)) {
            return false;
        }
        Vertex<T,N> newVertex = new Vertex<>(v, type, null);
        if (head == null) {
            head = newVertex;
        }else{
            Vertex<T,N> previous = head;
            for (Vertex<T,N> temp = head; temp != null; temp = temp.nextVertex) {
                previous = temp;
            }
            previous.nextVertex = newVertex;
        }
        size++;
        return true;
    }
    
    public boolean addEdge(T source, T destination, N distance){
        if (head == null) {
            return false;
        }
        if (!hasVertex(source) || !hasVertex(destination)) {
            return false;
        }
        for (Vertex<T,N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex) {
            if (sourceVertex.point.compareTo(source) == 0) {
                for (Vertex<T,N> destinationVertex = head; destinationVertex != null; destinationVertex = destinationVertex.nextVertex) {
                    if (destinationVertex.point.compareTo(destination) == 0) {
                        Double speed;
                        if (sourceVertex.type.equals("Housing Area") && destinationVertex.type.equals("Housing Area")) {
                            speed = y;
                        }else if ((sourceVertex.type.equals("Housing Area") && destinationVertex.type.equals("Food Area")) 
                                || (sourceVertex.type.equals("Food Area") && destinationVertex.type.equals("Housing Area"))) {
                            speed = y;
                        }else if ((sourceVertex.type.equals("Food Area") && destinationVertex.type.equals("Food Area"))){
                            speed = 1.25 * y;
                        }else if ((sourceVertex.type.equals("Food Area") && destinationVertex.type.equals("Industry Area")) 
                                || (sourceVertex.type.equals("Industry Area") && destinationVertex.type.equals("Food Area"))) {
                            speed = 1.5 * y;
                        }else{
                            speed = 3 * y;
                        }
                        Edge<T,N> currentEdge = sourceVertex.firstEdge;
                        Edge<T,N> newEdge = new Edge<>(destinationVertex, distance, speed, currentEdge);
                        sourceVertex.firstEdge = newEdge;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public N getDistance(T source, T destination){
        if (head == null) {
            return null;
        }
        if (!hasVertex(source) || !hasVertex(destination)) {
            return null;
        }
        for (Vertex<T,N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex) {
            if (sourceVertex.point.compareTo(source) == 0) {
                for (Edge<T,N> currentEdge = sourceVertex.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge) {
                    if (currentEdge.toVertex.point.compareTo(destination) == 0) {
                        return currentEdge.distance;
                    }
                }
            }
        }
        return null;
    }
    
    public double getSpeed(T source, T destination){
        double speed = 0.0;
        if (head == null) {
            return 0.0;
        }
        if (!hasVertex(source) || !hasVertex(destination)) {
            return 0.0;
        }
        for (Vertex<T,N> sourceVertex = head; sourceVertex != null; sourceVertex = sourceVertex.nextVertex) {
            if (sourceVertex.point.compareTo(source) == 0) {
                for (Edge<T,N> currentEdge = sourceVertex.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge) {
                    if (currentEdge.toVertex.point.compareTo(destination) == 0) {
                        return currentEdge.speed;
                    }
                }
            }
        }
        return 0.0;
    }
    
    public int getIndex(T vertex){
        Vertex<T,N> current = head;
        
        for (int i = 0; current != null; i++, current = current.nextVertex) {
            if (current.point.compareTo(vertex) == 0) {
                return i;
            }
        }
        return -1;
    }
    
    public ArrayList<ArrayList<T>> getAllPaths(T source, T destination){
        int src = getIndex(source);
        int dest = getIndex(destination);
        
        boolean[] visited = new boolean[size];
        ArrayList<T> path = new ArrayList<>();
        ArrayList<ArrayList<T>> allPaths = new ArrayList<>();
        
        path.add(getVertex(src));
        dfs(src, dest, visited, path, allPaths);
        
        return allPaths;
    }
    
    private void dfs(int src, int dest, boolean[] visited, ArrayList<T> path, ArrayList<ArrayList<T>> allPaths){
        visited[src] = true;
        
        if (src == dest) {
            allPaths.add(new ArrayList<>(path));
        }else{
            Vertex<T,N> current = head;
            for (int i = 0; i < src; i++) {
                current = current.nextVertex;
            }
            for (Edge<T,N> edge = current.firstEdge; edge != null; edge = edge.nextEdge) {
                int nextIndex = getIndex(edge.toVertex.point);
                if (!visited[nextIndex]) {
                    path.add(edge.toVertex.point);
                    dfs(nextIndex, dest, visited, path, allPaths);
                    path.remove(path.size()-1); // backtrack
                }
            }
        }
        visited[src] = false;
    }
}