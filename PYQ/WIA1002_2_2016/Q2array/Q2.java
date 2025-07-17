/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2array;

/**
 *
 * @author tianlongc
 */
import java.io.*;

public class Q2 {
    public static void main(String[] args) {
        String texts = readFile("BracMatch.txt");
        
        String[] inputs = texts.split("\n");
        
        for (String input : inputs) {
            System.out.println(isMatched(input));
        }
    }
    
    public static String readFile(String file){
        StringBuilder content = new StringBuilder();
        try{
            BufferedReader inputStream = new BufferedReader(new FileReader(file));
            
            String line = "";
            while ((line = inputStream.readLine()) != null) {
                content.append(line + "\n");
            }
            
            inputStream.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        return content.toString();
    }
    
    public static String isMatched(String input){
        final String opening = "[{(<";
        final String closing = "]})>";
        MyStack<Character> buffer = new MyStack<>();
        boolean hasBrackets = false;
        
        for (char c : input.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                hasBrackets = true;
                buffer.push(c);
            }else if (closing.indexOf(c) != -1){
                hasBrackets = true;
                if (buffer.isEmpty()) {
                    return "Not all brackets are matched";
                }
                if (closing.indexOf(c) != opening.indexOf(buffer.pop())) {
                    return "Not all brackets are matched";
                }
            }
        }
        return hasBrackets ? (buffer.isEmpty() ? "YES - all matched!" : "Not all brackets are matched") : "There is no bracket in the input";
    }
}
