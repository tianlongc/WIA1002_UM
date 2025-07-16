/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L6;

/**
 *
 * @author tianlongc
 */

/**
 * i) Only one disk may be moved at a time
 * ii) Each move consists of taking the upper disk from one of the rods and sliding it
 *     onto another rod, on top of the other disks that may already be present on that rod.
 * iii) No disk may be placed on top of a smaller disk.
 */
import java.util.Scanner;

public class TowerOfHanoi {
    static int step = 0; // global variable to record total steps
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of disks: ");
        int numberOfDisks = sc.nextInt();
        
        /* Creating Stack array as towers// rods */
        MyStack<Integer>[] rods = new MyStack[3];
        for (int i = 0; i < rods.length; i++) {
            rods[i] = new MyStack<>();
        }
        
        // Initialize the first rod with all disks (largest at bottom)
        for (int i = numberOfDisks; i >= 1; i--) {
            rods[0].push(i);
        }
        
        System.out.println("\nInitial State");
        printRods(rods);
        // fromRod = 1st rod, toRod = 3rd rod, auxRod = 2nd rod
        move(numberOfDisks, 0, 2, 1, rods);
        
        System.out.println("Total optimum move: " + step);
        
        sc.close();
    }
    
    public static void printRods(MyStack<Integer>[] rods){
        for (int i = 0; i < rods.length; i++) {
            System.out.printf("Rod %d: %s\n", (i+1), rods[i]);
        }
        System.out.println("");
    }
    
    // Recursive method that calls repeatly to move the disks
    public static void move(int n, int fromRod, int toRod, int auxRod, MyStack<Integer>[] rods){
        // Base case: if there is only 1 disk
        if (n == 1) {
           int disk = rods[fromRod].pop();
           rods[toRod].push(disk);
           
           System.out.printf("Move disk %d from rod %d to rod %d\n", disk, fromRod+1, toRod+1);
           printRods(rods);
        }else{
            // Move n-1 disks from source to auxiliary rod
            // using target rod as temporary storage
            move(n-1, fromRod, auxRod, toRod, rods);
            
            // Move the remaining largest disk from source to target rod
            int disk = rods[fromRod].pop();
            rods[toRod].push(disk);
            
            System.out.printf("Move disk %d from rod %d to rod %d\n", disk, fromRod+1, toRod+1);
            printRods(rods);
            
            // Move n-1 disks from auxiliary rod to target rod
            // using source rod as temporary storage
            move(n-1, auxRod, toRod, fromRod, rods);
        }
        step++;
    }
}

/*
Walkthru for TOH
Let say n = 3
fromRod is the first rod
toRod is the second rod
auxRod is the third rod
rods array is passed down to mutate and do operation

    Trace the process
    1.	Function call move(int n, int fromRod, int toRod, int auxRod, MyStack<Integer>[] rods) from main method
    2.	Check the condition (base case) is met or not
    3.	If yes, stop the recursive call.
    4.	If no, call move(2, 0, 1, 2, rods)
    5.	Call move(1, 0, 2, 1, rods)
    6.	Function call stack management: move(3, 0, 2, 1, rods) move(2, 0, 1, 2, rods) move(1, 0, 2, 1, rods)
    7.	move(1, 0, 2, 1, rods) is popped to execute
    8.	 base case met n = 1 so the pop the first rod’s disk which is 1 and push the disk into the third rod (toRod)
    9.	Move disk 1 from rod 1 to rod 3 is printed.
    10.	Pop move(2, 0, 1, 2, rods) to execute the statement so the disk is popped from the first rod (fromRod) which is 2 and pushed to the second rod (auxRod).
    11.	Move disk 2 from rod 1 to rod 2 is printed
    12.	Call move (1, 2, 1, 0, rods)
    13.	Function call stack management: move(3, 0, 2, 1, rods) Call move (1, 2, 1, 0, rods)
    14.	So execute move(1,2,1,0, rods)
    15.	Base case n==1 is met so disk which is 1 from third rod (toRod) is popped and pushed to the second rod (auxRod)
    16.	Move disk 1 from rod 3 to rod 2 is printed
    17.	Execute move(3, 0, 2, 1, rods)
    18.	The disk is popped from the first rod (fromRod) which is 3 and pushed to the third rod (toRod)
    19.	Move disk 3 from rod 1 to rod 3 is printed
    20.	Call move(2, 1, 2, 0, rods)
    21.	Call move(1, 1, 0, 2 , rods)
    22.	Function call stack: Call move(2, 1, 2, 0, rods) Call move(1, 1, 0, 2, rods)
    23.	Execute move(1, 1, 0, 2, rods)
    24.	Pop the disk 1 from the second rod (aux rod) to first rod (fromRod)
    25.	Move disk 1 from rod 2 to rod 1 is printed
    26.	Execute move(2, 1, 2, 0, rods) 
    27.	Pop the disk 2 from the second rod (aux rod) to the third rod (toRod)
    28.	Move disk 2 from rod 2 to rod 3 is printed
    29.	Call Move(1, 0, 2, 1, rods)
    30.	Execute the move
    31.	Pop the disk 1 from the first rod (from Rod) to the third rod (toRod)
    32.	Move disk 1 from rod 1 to rod 3 is printed
 */
