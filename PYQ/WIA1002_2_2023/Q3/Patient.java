/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 */
public class Patient {
    private String firstName;
    private String lastName;
    private PastMedicalRecord pastMedicalRecord;
    
    public Patient(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pastMedicalRecord = null;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setPastMedicalRecord(PastMedicalRecord pastMedicalRecord){
        this.pastMedicalRecord = pastMedicalRecord;
    }
    
    public PastMedicalRecord getPastMedicalRecord(){
        return pastMedicalRecord;
    }
    
    /*
        Refer back to Lab 02 Question 3 Store Pair Generics
        @Overide the equals() function
    */
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true; // Check if the objects are the same instance
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Patient other = (Patient) obj;
        return firstName.equals(other.firstName) && lastName.equals(other.lastName);
    }
}
