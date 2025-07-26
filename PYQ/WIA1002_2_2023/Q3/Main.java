/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 */
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String familyBook = readFile("family_book.csv");
        String pastMedicalRecord = readFile("past_medical_record.csv");
        String upcomingPatients = readFile("upcoming_patients.csv");
        
        List<Patient> patients = new ArrayList<>();
        List<List<String>> familyTable = new ArrayList<>();
        List<List<String>> medicalTable = new ArrayList<>();
        List<List<String>> patientTable = new ArrayList<>();
        
        processData(familyBook, familyTable);
        processData(pastMedicalRecord, medicalTable);
        processData(upcomingPatients, patientTable);
        
        // Skip table header, i = 1
        for (int i = 1; i < familyTable.size(); i++) {
            patients.add(new Patient(familyTable.get(i).get(0), familyTable.get(i).get(1)));
        }
        
        loadPastMedicalRecord(medicalTable, patients);
        
        FamilyTree tree = new FamilyTree();
        for (Patient patient : patients) {
            tree.add(patient);
        }
        addParentRelationship(tree, familyTable, patients);
        
        List<List<String>> table = new ArrayList<>();
        loadUpcomingPatients(tree, patientTable, table, patients);
        displayTable(table);
    }
    
    public static String readFile(String path){
        StringBuilder content = new StringBuilder();
        try{
            BufferedReader file = new BufferedReader(new FileReader(path));
            
            String line = "";
            while ((line = file.readLine()) != null) {
                content.append(line).append("\n");
            }
            file.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        return content.toString();
    }
    
    // Parses CSV content into 2D table structure
    public static void processData(String content, List<List<String>> table){
        String[] lines = content.split("\n");
        for (String line : lines) {
            if (line.trim().isEmpty()) continue; // Skip empty lines
            // Add -1 to handle empty columns
            // Example: "a,b," → ["a", "b", ""] 
            String[] columns = line.split(",", -1); 
            List<String> row = new ArrayList<>();
            for (String column : columns) {
                row.add(column);
            }
            table.add(row);
        }
    }
    
    public static void loadPastMedicalRecord(List<List<String>> medicalTable, List<Patient> patients){
        // Skip table header, i = 1
        for (int i = 1; i < medicalTable.size(); i++) {
            String firstName = medicalTable.get(i).get(0);
            String lastName = medicalTable.get(i).get(1);
            
            Patient currentPatient = findPatient(patients, firstName, lastName); 
            if (currentPatient == null) continue;
            
            // information starts at 2nd index
            int height = Integer.parseInt(medicalTable.get(i).get(2));
            int weight = Integer.parseInt(medicalTable.get(i).get(3));
            String occupation = medicalTable.get(i).get(4);
            String diabetic = medicalTable.get(i).get(5);
            String heartDisease = medicalTable.get(i).get(6);
            String smoking = medicalTable.get(i).get(7);
            String drinkAlcohol = medicalTable.get(i).get(8);
            
            PastMedicalRecord pastMedicalRecord = new PastMedicalRecord(height, weight, occupation, diabetic, heartDisease, smoking, drinkAlcohol);
            currentPatient.setPastMedicalRecord(pastMedicalRecord);
        }
    }
    
    public static Patient findPatient(List<Patient> patients, String firstName, String lastName){
        for (Patient patient : patients) {
            if (patient.getFirstName().equals(firstName) && patient.getLastName().equals(lastName)) {
                return patient;
            }
        }
        return null;
    }
    
    public static void addParentRelationship(FamilyTree tree, List<List<String>> familyTable, List<Patient> patients){
        for (int i = 1; i < familyTable.size(); i++) {
            List<String> row = familyTable.get(i);
            // Patient node
            String patientFirstName = row.get(0);
            String patientLastName = row.get(1);
            Patient patient = findPatient(patients, patientFirstName, patientLastName);
            // Parent node
            String parentFirstName = row.get(2);
            String parentLastName = row.get(3);
            Patient parent = findPatient(patients, parentFirstName, parentLastName);
            // Create link
            tree.addParentRelationship(patient, parent);
        }
    }
    
    public static void loadUpcomingPatients(FamilyTree tree, List<List<String>> patientsTable, List<List<String>> table, List<Patient> patients){
        String[] tableHeaderColumns = {"FirstName", "LastName", "ParentFirstName", "ParentLastName", "ParentHeight", "ParentWeight", "ParentOccupation", "ParentDiabetic", "ParentDisease", "ParentSmoking", "ParentDrinkAlcohol"};
        List<String> header = new ArrayList<>();
        for (String column : tableHeaderColumns) {
            header.add(column);
        }
        table.add(header);
        
        for (int i = 1; i < patientsTable.size(); i++) {
            String firstName = patientsTable.get(i).get(0);
            String lastName = patientsTable.get(i).get(1);
            Patient patient = findPatient(patients, firstName, lastName);
            
            Patient parent = tree.findClosestAncestorWithMedicalRecord(patient);
            
            List<String> row = new ArrayList<>();
            row.add(firstName);
            row.add(lastName);
            
            if (parent == null) {
                for (int j = 0; j < tableHeaderColumns.length-2; j++) {
                    row.add("None");
                }
            }else{
                row.add(parent.getFirstName());
                row.add(parent.getLastName());
                row.add(Integer.toString(parent.getPastMedicalRecord().getHeight()));
                row.add(Integer.toString(parent.getPastMedicalRecord().getWeight()));
                row.add(parent.getPastMedicalRecord().getOccupation());
                row.add(parent.getPastMedicalRecord().getDiabetic());
                row.add(parent.getPastMedicalRecord().getHeartDisease());
                row.add(parent.getPastMedicalRecord().getSmoking());
                row.add(parent.getPastMedicalRecord().getDrinkAlcohol());
            }
            table.add(row);
        }
    }
    
    public static void displayTable(List<? extends List<?>> table){
        // resizable table columns
        int colCount = table.get(0).size();
        int[] colWidths = new int[colCount];
        // Calculate the maximum width for each column by checking all rows
        for (int i = 0; i < colCount; i++) {
            for (List<?> rows : table) {
                colWidths[i] = Math.max(colWidths[i], rows.get(i).toString().length());
            }
        }
        for (List<?> row : table) {
            for (int i = 0; i < colCount; i++) {
                // Add padding by 1 for better readibility
                System.out.printf("%-" + (colWidths[i]+1) + "s\t", row.get(i));
            }
            System.out.println();
        }
    }
}
