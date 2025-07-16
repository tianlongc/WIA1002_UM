/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L8Q1Q2;

/**
 *
 * @author tianlongc
 * @param <T> generic type parameter named Vertex Type 
 * - represents the type of data stored in the vertices of the graph.
 * @param <N> generic type parameter named Weight Type
 * - represents the type of data used for edge weights
 */
public class Vertex<T extends Comparable<T>, N extends Comparable<N>>{
    T vertexInfo;
    int indeg;
    int outdeg;
    Vertex<T,N> nextVertex;
    Edge<T,N> firstEdge;
    
    public Vertex(){
        vertexInfo = null;
        indeg = 0;
        outdeg = 0;
        nextVertex = null;
        firstEdge = null;
    }
    
    public Vertex(T vInfo, Vertex<T,N> next){
        vertexInfo = vInfo;
        indeg = 0;
        outdeg = 0;
        nextVertex = next;
        firstEdge = null;
    }
}
