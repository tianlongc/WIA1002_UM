/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L1Q1;

/**
 *
 * @author tianlongc
 */
import java.io.*;
import java.util.Scanner;

public class ReadMyLetter_24068668 {
    public static void main(String[] args) {
        readFile(); // Part 1
        writeFile(); // Part2
    }
    
    public static void readFile(){
        try{
            BufferedReader inputStream = new BufferedReader(new FileReader("ChooTianLong_24068668.txt"));
            
            String line = "";
            while ((line = inputStream.readLine()) != null) {
                System.out.println(line);
            }
            
            inputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static void writeFile(){
        try{
            Scanner sc = new Scanner(System.in);
            String input = "";
            
            // Make sure the file is append so we use true
            PrintWriter outputStream = new PrintWriter(new FileOutputStream("ChooTianLong_24068668.txt", true));
            
            System.out.println("\n\n");
            outputStream.println("\n\n");
            String line = "";
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                // Enter key to terminate input
                if (line.isEmpty()) {
                    break;
                }
                outputStream.println(line + "\n");
                System.out.println(""); // nextLine for spacing
            }
            
            outputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Error outputting file: " + e.getMessage());
        }
    }
}
