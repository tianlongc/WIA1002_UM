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
public class Vertex<T extends Comparable<T>>{
    T vertexInfo;
    int indeg;
    int outdeg;
    Vertex<T> nextVertex;
    Edge<T> firstEdge;
    
    public Vertex(){
        vertexInfo = null;
        indeg = 0;
        outdeg = 0;
        nextVertex = null;
        firstEdge = null;
    }
    
    public Vertex(T vInfo, Vertex<T> next){
        vertexInfo = vInfo;
        indeg = 0;
        outdeg = 0;
        nextVertex = next;
        firstEdge = null;
    }
}
