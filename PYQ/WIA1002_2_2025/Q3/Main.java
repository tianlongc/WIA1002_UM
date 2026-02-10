/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author tianlongc
 */

/*
    Question (a): Given a text file "student.txt" containing student records in the format:
                  Student ID `int` , Name `String`, Score `double`, read the file and store
                  the records in an ArrayList by creating Student objects
    Question (b): Create a Insertion Sort method to arrange the Student ID in ascending order
    Question (c): After sorting, implement a Binary Search method to locate a student by their ID
    Question (d): Test the program
                  - Print sorted student list
                  - Search for student with ID 119 and 197
                  - If the student is found, print their ID, Name, Score
                  - If not found, return -1
*/
import java.io.*;
import java.util.ArrayList;

class Student{
    int id;
    String name;
    double score;
    
    public Student(int id, String name, double score){
        this.id = id;
        this.name = name;
        this.score = score;
    }
    
    @Override
    public String toString(){
        return String.format("id: %d name: %s score: %.1f", id, name, score);
    }
}

public class Main {
    // (d) test program
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        // (a) read file
        try{
            BufferedReader file = new BufferedReader(new FileReader(".\\WIA1002_2_2025\\Q3\\student.txt"));
        
            String line = "";
            while ((line = file.readLine()) != null) {
                String[] parts = line.split(","); // the text file is comma-separated
                students.add(new Student(Integer.parseInt(parts[0]), parts[1], Double.parseDouble(parts[2])));
            }
            
            file.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        // (b) insertion sort
        insertionSort(students);
        for (Student student : students) {
            System.out.println(student);
        }
        
        // (c) binary search
        int[] searchIDs = {119, 197};
        for (int searchID : searchIDs) {
            System.out.println("\nSearching student with ID " + searchID);
            int result = binarySearch(students, searchID);
            if (result == -1) {
                // System.out.println("Student not found");
                System.out.println(-1);
            }else{
                System.out.println("Found student at index " + result);
                System.out.println(students.get(result));
            }
        }
    }
    
    public static void insertionSort(ArrayList<Student> students){
        for (int i = 1; i < students.size(); i++) {
            Student currentStudent = students.get(i);
            int k;
            
            for (k = i-1; k >= 0 && (currentStudent.id < students.get(k).id); k--) {
                students.set(k+1, students.get(k));
            }
            students.set(k+1, currentStudent);
        }
    }
    
    public static int binarySearch(ArrayList<Student> students, int key){
        int low = 0;
        int high = students.size() - 1;
        
        while (low <= high) {
            int mid = (low + high)/2;
            if (key < students.get(mid).id) {
                high = mid - 1;
            }else if(key == students.get(mid).id){
                return mid;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
