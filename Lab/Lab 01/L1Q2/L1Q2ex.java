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

public class L1Q2ex {
    public static void main(String[] args) {
        // Create a File object for the directory
        File folder = new File("texts");
        
        // List all files in the directory
        File[] listOfFiles = folder.listFiles();
        
        if (listOfFiles != null) {
            for (File file: listOfFiles) {
                if (file.isFile()) {
                    try{
                        BufferedReader inputStream = new BufferedReader(new FileReader(file));
                        
                        System.out.println(file.getName());
                        String content = "";
                        String line = "";
                        while ((line = inputStream.readLine()) != null) {
                            content += line.replaceAll("[,;\\s]+", "") + "\n";
                        }
                        
                        int count = 0, numbers = 0;
                        for (int i = 0; i < content.length(); i++) {
                            if (Character.isLetter(content.charAt(i))) {
                                count++;
                            }else if (Character.isDigit(content.charAt(i))){
                                numbers++;
                            }
                        }
                        
                        System.out.printf("Number of characters: %d\n%s\n", 
                                ((count > 0) ? count : numbers), ((count > 0) ? content.replaceAll("\\d+", "") : content));
                        
//                        if (count > 0) {
//                            System.out.println("Number of characters: " + count);
//                            // [0-9]+
//                            System.out.println(content.replaceAll("\\d+", ""));
//                        }else{
//                            System.out.println("Number of digits: " + numbers);
//                            System.out.println(content);
//                        }
                        
                        inputStream.close();
                    }catch(FileNotFoundException e){
                        System.out.println("File not found: " + e.getMessage());
                    }catch(IOException e){
                        System.out.println("Error reading file: " + e.getMessage());
                    }
                }
            }
        }else{
            System.out.println("The directory is empty or not a directory");
        }
    }
}
