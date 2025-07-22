/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 * ArrayList Implementation of Graph using Adjacency List
 */
import java.util.ArrayList;

class Vertex {
    String point;
    String type;
    ArrayList<Edge> edges;
    
    public Vertex(){
        this(null, null);
    }
    
    public Vertex(String point, String type){
        this.point = point;
        this.type = type;
        this.edges = new ArrayList<>();
    }
}

public class RoutingGraph{
    final static double y = 2.0; // assume y = 2.0
    private ArrayList<Vertex> vertices;
    
    public RoutingGraph(){
        this.vertices = new ArrayList<>();
    }
    
    public int getSize(){
        return vertices.size();
    }
    
    public String getVertex(int i){
        if (i < 0 || i >= vertices.size()) {
            return null;
        }
        return vertices.get(i).point;
    }
    
    public Vertex getVertex(String point){
        for (Vertex v : vertices) {
            if (v.point.equals(point)) {
                return v;
            }
        }
        return null;
    }
    
    public void addEdge(String source, String destination, double distance){
        Vertex src = getVertex(source);
        Vertex dst = getVertex(destination);
        double speed;
        
        if (src.type.equals("Housing Area") && dst.type.equals("Housing Area")) {
            speed = y;
        }else if ((src.type.equals("Housing Area") && dst.type.equals("Food Area")) 
                || (src.type.equals("Food Area") && dst.type.equals("Housing Area"))) {
            speed = y;
        }else if ((src.type.equals("Food Area") && dst.type.equals("Food Area"))){
            speed = 1.25 * y;
        }else if ((src.type.equals("Food Area") && dst.type.equals("Industry Area")) 
                || (src.type.equals("Industry Area") && dst.type.equals("Food Area"))) {
            speed = 1.5 * y;
        }else{
            speed = 3 * y;
        }
        src.edges.add(new Edge(dst, distance, speed));
    }
    
    public boolean hasEdge(String source, String destination){
        if (vertices.isEmpty()) {
            return false;
        }
        Vertex src = getVertex(source);
        for (Edge e: src.edges) {
            if (e.destination.point.equals(destination)) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<String> getNeighbours(String point){
        Vertex v = getVertex(point);
        ArrayList<String> neighbours = new ArrayList<>();
        for (Edge e : v.edges) {
            neighbours.add(e.destination.point);
        }
        return neighbours;
    }
    
    public void printEdges(){
        System.out.println("\nPrint all edges :");
        for (Vertex v : vertices) {
            System.out.printf("# %s : ", v.point);
            for (Edge e : v.edges) {
                System.out.printf("[%s,%s(speed=", v.point, e.destination.point);
                System.out.print(e.speed + " , distance=" + e.distance + ")] ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void addVertex(String point, String type){
        this.vertices.add(new Vertex(point, type));
    }
    
    public int getIndex(String point){
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).point.equals(point)) {
                return i;
            }
        }
        return -1;
    }
    
    public ArrayList<ArrayList<String>> getAllPaths(String source, String destination){
        int src = getIndex(source);
        int dest = getIndex(destination);
        
        boolean[] visited = new boolean[vertices.size()];
        ArrayList<String> path = new ArrayList<>();
        ArrayList<ArrayList<String>> allPaths = new ArrayList<>();
        
        path.add(source);
        dfs(src, dest, visited, path, allPaths);
        
        return allPaths;
    }
    
    private void dfs(int src, int dest, boolean[] visited, ArrayList<String> path, ArrayList<ArrayList<String>> allPaths){
        visited[src] = true;
        
        if (src == dest) {
            allPaths.add(new ArrayList<>(path));
        }else{
            Vertex v = vertices.get(src);
            for (Edge e: v.edges) {
                int nextIndex = getIndex(e.destination.point);
                if (!visited[nextIndex]) {
                    path.add(e.destination.point);
                    dfs(nextIndex, dest, visited, path, allPaths);
                    path.remove(path.size()-1); // backtrack
                }
            }
        }
        visited[src] = false;
    }
    
    public double getDistance(String source, String destination){
        for (Vertex v : vertices) {
            if (v.point.equals(source)) {
                for (Edge e: v.edges) {
                    if (e.destination.point.equals(destination)) {
                        return e.distance;
                    }
                }
            }
        }
        return 0.0;
    }
    
    public double getSpeed(String source, String destination){
        for (Vertex v : vertices) {
            if (v.point.equals(source)) {
                for (Edge e: v.edges) {
                    if (e.destination.point.equals(destination)) {
                        return e.speed;
                    }
                }
            }
        }
        return 0.0;
    }
}
