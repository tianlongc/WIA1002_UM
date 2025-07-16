/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L8Q3Q4;

/**
 *
 * @author tianlongc
 * @param <T> generic type parameter named Vertex Type
 * - represents the type of data stored in the vertices of the graph.
 */
public class Edge<T extends Comparable<T>>{
    Vertex<T> toVertex;
    Edge<T> nextEdge;
    
    public Edge(){
        toVertex = null;
        nextEdge = null;
    }
    
    public Edge(Vertex<T> destination, Edge<T> a){
        toVertex = destination;
        nextEdge = a;
    }
}
