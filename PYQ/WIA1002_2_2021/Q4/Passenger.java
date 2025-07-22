/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 */
public class Passenger implements Comparable<Passenger>{
    private String name;
    private double distance;
    
    public Passenger(String name, String road){
        this.name = name;
        this.distance = Double.parseDouble(road.split(" ")[1]);
    }
    
    public String getName(){
        return name;
    }
    
    public double getDistance(){
        return distance;
    }
    
    @Override
    public int compareTo(Passenger other){
        return Double.compare(this.distance, other.distance);
    }
}
