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
import java.util.Random;

public class LuckyDraw {
    public static void main(String[] args) {
        Staff[] staffs = readFile("staffList.txt");
        LinkedList<Staff> staffList1 = new LinkedList<>();
        for (Staff staff : staffs) {
            staffList1.addLast(staff);
        }
        
        LinkedList<Staff> staffList2 = staffList1.clone();
        firstRound(staffList1);
        System.out.println("");
        secondRound(staffList2);
    }
    
    public static Staff[] readFile(String path){
        Staff[] staffs = new Staff[0];
        
        try{
            BufferedReader file = new BufferedReader(new FileReader(path));
            
            // skip table header
            String line = file.readLine(), content = "";
            while ((line = file.readLine()) != null) {
                content += line + "\n";
            }
            String[] row = content.split("\n");
            staffs = new Staff[row.length];
            
            for (int i = 0; i < staffs.length; i++) {
                String[] data = row[i].split("[\\|\\t]+");
                staffs[i] = new Staff(Integer.parseInt(data[0]), data[1], data[2]);
            }
            file.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        return staffs;
    }
    
    public static void firstRound(LinkedList<Staff> staffList1){
        Random rd = new Random();
//        boolean[] seen = new boolean[staffList1.getSize()];
//        int[] numbers = new int[5];
//        // Generate 5 unique number
//        int count = 0;
//        while (count < 5) {
//            int number = rd.nextInt(staffList1.getSize());
//            if (seen[number]) {
//                continue;
//            }
//            seen[number] = true;
//            numbers[count++] = number;
//        }
//        
//        for (int number : numbers) {
//            Staff winner = staffList1.get(number);
//            System.out.printf("%d %s wins a drone!\n", winner.getID(), winner.getName());
//        }
        for (int i = 0; i < 5; i++) {
            int number = rd.nextInt(staffList1.getSize());
            Staff winner = staffList1.get(number);
            System.out.printf("%d %s wins a drone!\n", winner.getID(), winner.getName());
            staffList1.remove(number);
        }
    }
    
    public static void secondRound(LinkedList<Staff> staffList2){
        Random rd = new Random();
        int totalCashVoucher = 1000, cashVoucher = 0;
        
        while (totalCashVoucher > 0) {
            int number = rd.nextInt(staffList2.getSize());
            Staff winner = staffList2.get(number);
            if (winner.getPosition().equalsIgnoreCase("Manager")) {
                System.out.printf("%s %s is the winner, but no cash voucher will be given\n", winner.getPosition(), winner.getName());
            }else{
                if (winner.getPosition().equalsIgnoreCase("Assistant")) {
                    cashVoucher = 200;
                }else if (winner.getPosition().equalsIgnoreCase("Supervisor")) {
                    cashVoucher = 100;
                }
                cashVoucher = Math.min(cashVoucher, totalCashVoucher); // prevent over-distribution
                totalCashVoucher -= cashVoucher;
                
                System.out.printf("%s %s wins RM%d. Cash vouchers left RM%d\n", winner.getPosition(), winner.getName(), cashVoucher, totalCashVoucher);
            }
        }
    }
}
