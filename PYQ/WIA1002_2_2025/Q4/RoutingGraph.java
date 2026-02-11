/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 */

/*
    Implement the following utility methods
    1. getSize
    2. getVertex
    3. hasEdge
    4. getNeighbours
    5. printEdges
*/
import java.util.ArrayList;

public class RoutingGraph<T extends Comparable<T>, N extends Comparable<N>>{
    private final double x;
    private Vertex<T,N> head;
    private int size;

    public RoutingGraph(){
        this(2.0); // Assume x = 2 for example
    }

    public RoutingGraph(double x){
        this.head = null;
        this.size = 0;
        this.x = x;
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
                System.out.printf("[%s, %s (speed=%.1f, distance=%.1f)] ", temp.point, currentEdge.toVertex.point, currentEdge.speed, currentEdge.distance);
            }
            System.out.println("");
        }
    }

    public boolean addVertex(T point, T type){
        if (hasVertex(point)){
            return false;
        }
        Vertex<T,N> newVertex = new Vertex<>(point, type, null);
        if (head == null) {
            head = newVertex;
        }else{
            Vertex<T,N> previous = head;
            for (Vertex<T,N> temp = head; temp != null; temp = temp.nextVertex){
                previous = temp;
            }
            previous.nextVertex = newVertex;
        }
        size++;
        return true;
    }

    public boolean hasVertex(T point){
        if (head == null) {
            return false;
        }
        for (Vertex<T,N> temp = head; temp != null; temp = temp.nextVertex) {
            if (temp.point.compareTo(point) == 0) {
                return true;
            }
        }
        return false;
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
                        double speed;
                        if (sourceVertex.type.equals("Residential Area") && destinationVertex.type.equals("Residential Area")) {
                            speed = x;
                        }else if ((sourceVertex.type.equals("Residential Area") && destinationVertex.type.equals("Commercial Centre")) ||
                                  (sourceVertex.type.equals("Commercial Centre") && destinationVertex.type.equals("Residential Area"))) {
                            speed = 1.5 * x;
                        }else if ((sourceVertex.type.equals("Residential Area") && destinationVertex.type.equals("School Area")) ||
                                  (sourceVertex.type.equals("School Area") && destinationVertex.type.equals("Residential Area"))) {
                            speed = 1.7 * x;
                        }else if ((sourceVertex.type.equals("Commercial Centre") && destinationVertex.type.equals("Commercial Centre"))){
                            speed = 2.5 * x;
                        }else if ((sourceVertex.type.equals("Commercial Centre") && destinationVertex.type.equals("School Area")) ||
                                  (sourceVertex.type.equals("School Area") && destinationVertex.type.equals("Commercial Centre"))) {
                            speed = 2.0 * x;
                        }else{
                            speed = 1.2 * x;
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

    public boolean addBidirectedEdge(T source, T destination, N distance){
        return addEdge(source, destination, distance) && addEdge(destination, source, distance);
    }

    public N getDistance(T source, T destination) {
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
}
