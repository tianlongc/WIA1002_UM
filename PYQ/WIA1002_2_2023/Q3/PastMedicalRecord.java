/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 */
public class PastMedicalRecord {
    private int height;
    private int weight;
    private String occupation;
    private String diabetic;
    private String heartDisease;
    private String smoking;
    private String drinkAlcohol;
    
    // insert code to generate constructor and getter methods
    public PastMedicalRecord(int height, int weight, String occupation, String diabetic, String heartDisease, String smoking, String drinkAlcohol) {
        this.height = height;
        this.weight = weight;
        this.occupation = occupation;
        this.diabetic = diabetic;
        this.heartDisease = heartDisease;
        this.smoking = smoking;
        this.drinkAlcohol = drinkAlcohol;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getDiabetic() {
        return diabetic;
    }

    public String getHeartDisease() {
        return heartDisease;
    }

    public String getSmoking() {
        return smoking;
    }

    public String getDrinkAlcohol() {
        return drinkAlcohol;
    }
}
