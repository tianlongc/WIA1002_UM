/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q6;

/**
 *
 * @author tianlongc
 * 
 */
class Vertex<T extends Comparable<T>, N extends Comparable<N>>{
    T point;
    T type;
    Vertex<T,N> nextVertex;
    Edge<T,N> firstEdge;
    
    public Vertex(){
        this(null, null, null);
    }
    
    public Vertex(T point, T type, Vertex<T,N> nextVertex){
        this.point = point;
        this.type = type;
        this.nextVertex = nextVertex;
        this.firstEdge = null;
    }
}

public class Edge<T extends Comparable<T>, N extends Comparable<N>>{
    Vertex<T,N> toVertex;
    N distance;
    Double speed;
    Edge<T,N> nextEdge;
    
    public Edge(){
        this(null, null, null, null);
    }
    
    public Edge(Vertex<T,N> toVertex, N distance, Double speed, Edge<T,N> nextEdge){
        this.toVertex = toVertex;
        this.distance = distance;
        this.speed = speed;
        this.nextEdge = nextEdge;
    }
}
