/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 */
public class Edge{
    Vertex destination;
    double distance;
    double speed;
    
    public Edge(){
        this(null, 0.0, 0.0);
    }
    
    public Edge(Vertex destination, double distance, double speed){
        this.destination = destination;
        this.distance = distance;
        this.speed = speed;
    }
}
