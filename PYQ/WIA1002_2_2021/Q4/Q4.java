/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 */
import java.util.PriorityQueue;

public class Q4 {
    public static void main(String[] args) {
        PriorityQueue<Passenger> bus = new PriorityQueue<>();
        bus.offer(new Passenger("Susan","Road 0.9"));
        bus.offer(new Passenger("Jack","Road 5.5"));
        bus.offer(new Passenger("Benjamin","Road 1.6"));
        bus.offer(new Passenger("Rachel","Road 3.8"));
        bus.offer(new Passenger("Samuel","Road 4.1"));
        bus.offer(new Passenger("Kenneth","Road 2.6"));
        
        System.out.println("Passenger Drop-off List");
        while (!bus.isEmpty()) {
            Passenger p = bus.poll();
            // starts from pickup point each interval + 1.0km
            // so 0.2 + 1 = 1.2km
            if (p.getDistance() <= 1.2) {
                System.out.print("Stop A: ");
            }else if(p.getDistance() <= 2.2){
                System.out.print("Stop B: ");
            }else if(p.getDistance() <= 3.2){
                System.out.print("Stop C: ");
            }else if(p.getDistance() <= 4.2){
                System.out.print("Stop D: ");
            }else{
                System.out.print("Stop E: ");
            }
            System.out.println(p.getName());
        }
    }
}
