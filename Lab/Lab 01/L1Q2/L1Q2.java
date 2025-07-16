/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L1Q2;

/**
 *
 * @author tianlongc
 */
import java.io.*;

public class L1Q2 {
    public static void main(String[] args) {
        // Use methods to modularise the whole program
        readFile("text1.txt", ","); // character separated by comma
        readFile("text2.txt", ",\\s"); // numbers separated by comma and spaces
        readFile("text3.txt", ";\\s"); // real numbers separated by semicolon and space
        readFile("text4.txt", "\\d"); // alphabets separated by numbers
    }
    
    public static void readFile(String fileName, String delimiters){
        // Format the delimiters
        delimiters = "[" + delimiters + "]+";
        
        try{
            BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
            
            System.out.println(fileName);
            String line = "", content = "";
            while ((line = inputStream.readLine()) != null) {
                content += line.replaceAll(delimiters, "") + "\n";
            }
            
            int count = 0;
            for (int i = 0; i < content.length(); i++) {
                if (Character.isLetterOrDigit(content.charAt(i))) {
                    count++;
                }
            }
            System.out.println("Number of characters: " + count);
            System.out.println(content);
            
            inputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
