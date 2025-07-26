/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author tianlongc
 */
import java.io.*;
import java.util.*;

public class Q4 {
    public static void main(String[] args) {
        List<List<String>> records = new ArrayList<>();
        
        readFile("IOES_Bachok_14093367.03122014.elab", records);
        
        removeNoise(records, 3);
        convertDegreeToCardinal(records);
        
        List<String> SVP = new ArrayList<>();
        calculateSVP(records, SVP);
        addSVPcolumn(records, SVP);
        
        printTable(records);
    }
    
    public static void readFile(String path, List<List<String>> records){
        try{
            BufferedReader file = new BufferedReader(new FileReader(path));
            
            String line = "";
            while ((line = file.readLine()) != null) {
                List<String> row = new ArrayList<>();
                String[] columns = line.split(",");
                /*  Refer back WIX1002_1_2025 Q5 to gain some insights
                    [0] Date/time
                    [1] RELHumidity - Ave
                    [2] AIRTemp - Ave
                    [3] ATMPressure - Ave
                    [4] WindSPEED - Ave
                    [5] WindDIR - RisDir
                    [6] Power Supply
                    [7] Internal Temperature
                    [8] Dew Point
                    We only interested from 0 to 5
                */
                for (int i = 0; i < 6; i++) {
                    row.add(columns[i]);
                }
                records.add(row);
            }
            file.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    // Sliding window uses Queue logic
    public static void removeNoise(List<List<String>> records, int windowSize){
        // Denoise numeric columns from [1] to [5]
        for (int col = 1; col < 6; col++) {
            LinkedList<Double> window = new LinkedList<>(); // resets window for each column
            // Skip table header, i = 1
            for (int row = 1; row < records.size(); row++) {
                double value = Double.parseDouble(records.get(row).get(col));
                window.add(value);
            
                if (window.size() < windowSize) {
                    records.get(row).set(col, "N/A"); // not enough data
                }else{
                    records.get(row).set(col, Double.toString(getMedian(window)));
                    window.removeFirst();
                }
            }
        }
    }
    
    private static double getMedian(List<Double> numbers){
        List<Double> list = new ArrayList<>(numbers);
        Collections.sort(list); // sort the data in ascending order
        int n = numbers.size();
        return (n % 2 == 1) ? list.get(n/2) : (list.get((n-1)/2) + list.get(n/2))/2;
    }
    
    public static void convertDegreeToCardinal(List<List<String>> records){
        for (int row = 1; row < records.size(); row++) {
            // [5] is Wind Direction
            if (records.get(row).get(5).equals("N/A")) {
                continue;
            }
            String cardinalDirection = getCardinalDirection(Double.parseDouble(records.get(row).get(5)));
            records.get(row).set(5, cardinalDirection);
        }
    }
    
    /*
        The compass has 16 directions, each covering 22.5 degrees.
        --> 360 / 16.0 = 22.5
        To calculate the correct index
        - Add 11.25 to the degree to shift the value to the center of its 22.5° slices
          making floor division match the intended direction
        - Divide by 22.5 to find which of the 16 segments the degree belongs to
        - % 16 to ensure index wrap around (in case 360° or more)
    */
    private static String getCardinalDirection(double degree){
        String[] directions = {
                "N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE",
                "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"
        };
        double deg = (degree + 360) % 360; // wrap-around to handle negative degree
        return directions[(int) Math.floor((((deg + 11.25) / 22.5) % 16))];
    }
    
    public static void calculateSVP(List<List<String>> records, List<String> SVP){
        for (int row = 1; row < records.size(); row++) { // Skip table header
            // [2] is Air Temperature
            if (records.get(row).get(2).equals("N/A")) {
                SVP.add("N/A");
                continue;
            }
            double T = Double.parseDouble(records.get(row).get(2));

            double A = 0, B = 0, C = 0;
            if (T >= 1 && T <= 99) {
                A = 8.07131;
                B = 1730.63;
                C = 233.426;
            }else if (T >= 100 && T <= 374){
                A = 8.14019;
                B = 1810.94;
                C = 244.485;
            }else{ // Handles out of range
                SVP.add("N/A");
                continue;
            }
            double P = Math.pow(10, (A - (B / (C + (T+273.15)))));
            SVP.add(Double.toString(P));
        }
    }
    
    public static void addSVPcolumn(List<List<String>> records, List<String> SVP){
        records.get(0).add("Saturated Vapor Pressure"); // column header
        for (int row = 1; row < records.size(); row++) {
            records.get(row).add(SVP.get(row-1));
        }
    }
    
    public static void printTable(List<List<String>> records){
        // resizable table columns
        int colCount = records.get(0).size();
        int[] colWidths = new int[colCount];
        // Calculate the maximum width for each column by checking all rows
        for (int i = 0; i < colCount; i++) {
            for (List<String> rows : records) {
                colWidths[i] = Math.max(colWidths[i], rows.get(i).toString().length());
            }
        }
        for (List<String> row : records) {
            for (int i = 0; i < colCount; i++) {
                // Add padding by 1 for better readibility
                System.out.printf("%-" + (colWidths[i]+1) + "s\t", row.get(i));
            }
            System.out.println();
        }
    }
}
