/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author tianlongc
 */
import java.util.Scanner;

public class Day {
    // Shared array of days to parse in where the index starts at 0
    static final String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private int number;
    
    public Day(int number){
        // Exception handling
        if (number < 1 || number > 7) {
            throw new IllegalArgumentException("Invalid number for day!");
        }
        this.number = number;
    }
    
    /**
     * Subtract 1 for array index since number is 1 to 7 mapped into 0-6 in days array
     * @return the day name for a given number
     */
    public String getDay(){
        return days[number-1];
    }
    
    /**
     * Modulo 7 ensures the result is always in the range 0 to 6 (valid index for days)
     * --> wrap-around from Sunday (7) to Monday (0)
     * Case 1: number = 3 3%7 = 3 is Wednesday when number-1 and 3 as array index mapped to Thursday
     * Case 2: number = 7 7%7 = 0 is Sunday when number-1 and 0 as array index mapped into Monday
     * @return the next day for a given number
     */
    public String getNextDay(){
        return days[number%7];
    }
    
    /**
     * number-2: adjusts the index to get the previous day (days is 0-indexed)
     * +7: ensures the value is non-negative (important for number = 1)
     * %7: wrap-around for the result as valid index
     * @return the previous day for a given number
     */
    public String getPreviousDay(){
        return days[(number-2+7)%7];
    }
    
    /**
     * number-1+day: handle array index and plus added days
     * %7: do wrap-around
     * @param day number of days to be added
     * @return the day name after adding the given day
     */
    public String addDay(int day){
        // Raw offset for the day
        int index = (number-1+day)%7;
        if (index < 0) {
            index += 7; // Handle negative results
        }
        return days[index];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Specify your day in number:");
        for (int i = 0; i < days.length; i++) {
            System.out.printf("%d for %s\n", i+1, days[i]);
        }
        int number = sc.nextInt();
        
        Day day = new Day(number);
        
        System.out.println("The name of the day is : " + day.getDay());
        System.out.println("The following day of " + day.getDay() + " is : " + day.getNextDay());
        System.out.println("The previous day of " + day.getDay() + " is : " + day.getPreviousDay());
        System.out.printf("How many days to add to the specified/current day (%s)? :\n", day.getDay());
        number = sc.nextInt();
        
        System.out.println("The new day after the addition of " + number + " day(s) is : " + day.addDay(number));
        
        sc.close();
    }
}
