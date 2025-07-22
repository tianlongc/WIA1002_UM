/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q42b;

/**
 *
 * @author tianlongc
 * @param <T> generic type parameter named Vertex Type 
 * - represents the type of data stored in the vertices of the graph.
 * @param <N> generic type parameter named Weight Type
 * - represents the type of data used for edge weights
 */
public class Edge<T extends Comparable<T>, N extends Comparable<N>>{
    Vertex<T,N> toVertex;
    N weight;
    Edge<T,N> nextEdge;
    
    public Edge(){
        toVertex = null;
        weight = null;
        nextEdge = null;
    }
    
    public Edge(Vertex<T,N> destination, N w, Edge<T,N> a){
        toVertex = destination;
        weight = w;
        nextEdge = a;
    }
}
