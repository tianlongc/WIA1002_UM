/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q43b;

/**
 *
 * @author tianlongc
 */
public class Car implements Comparable<Car>{
    private String colour;
    private String model;
    private String plateNumber;

    public Car(String colour, String model, String plateNumber) {
        this.colour = colour;
        this.model = model;
        this.plateNumber = plateNumber;
    }

    public String getColour() {
        return colour;
    }

    public String getModel() {
        return model;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    
    @Override
    public int compareTo(Car other){
        return this.plateNumber.compareTo(other.plateNumber);
    }
    
    @Override
    public String toString(){
        return String.format("Car{colour='%s', manufacturer='%s', plateNumber='%s'}", colour, model, plateNumber);
    }
}
