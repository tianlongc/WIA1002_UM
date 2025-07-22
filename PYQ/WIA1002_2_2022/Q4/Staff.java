/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 */
public class Staff {
    private int staffID;
    private String staffName;
    private String position;
    
    public Staff() {
    }
    
    public Staff(int id, String name, String post) {
        staffID= id;
        staffName = name;
        position = post;
    }
    
    public int getID(){
        return staffID;
    }
    
    public String getName(){
        return staffName;
    }
    
    public String getPosition(){
        return position;
    }
}
