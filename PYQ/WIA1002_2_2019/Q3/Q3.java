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

class Position{
    int row;
    int col;
    
    public Position(){
        this(0,0);
    }
    
    public Position(int row, int col){
       this.row = row;
       this.col = col;
    }
    
    @Override
    public String toString(){
        return String.format("(%d,%d)", row, col);
    }
}

public class Q3 {
    public static void main(String[] args) {
        char[][] maze1 = readFile("maze1.txt");
        char[][] maze2 = readFile("maze2.txt");
        printMaze(maze1);
        solveMaze(maze1);
        System.out.println("");
        printMaze(maze2);
        solveMaze(maze2);
    }
    
    /*
        1. Check maze boundaries
        2. Determine the path is '1' or 'C'
        3. Haven't visited
    */
    public static boolean isValid(int row, int col, char[][] maze, boolean[][] visited){
        return row >=  0 && col >= 0 && row < maze.length && col < maze[0].length && (maze[row][col] == '1' || maze[row][col] == 'C') && !visited[row][col];
    }
    
    public static void solveMaze(char[][] maze){
        boolean[][] visited  = new boolean[maze.length][maze[0].length];
        GenericStack<Position> stack = new GenericStack<>();
        
        stack.push(new Position()); // starts from (0,0)
        visited[0][0] = true; // mark as seen
        
        // (row, col) notation
        int[][] moves = {
            {0, 1},   // Right (same row, next column)
            {1, 0},   // Down (next row, same column)
            {0, -1},  // Left (same row, previous column)
            {-1, 0}   // Up (previous row, same column)
        };
        
        while (!stack.isEmpty()) {
            Position p = stack.peek();
            
            if (maze[p.row][p.col] == 'C') { // Found the cup
                printPath(stack);
                return;
            }
            
            boolean moved = false;
            for (int[] move : moves) {
                int newRow = p.row + move[0];
                int newCol = p.col + move[1];
                
                if (isValid(newRow, newCol, maze, visited)) {
                    stack.push(new Position(newRow, newCol));
                    visited[newRow][newCol] = true; // mark as seen
                    moved = true;
                    break;
                }
            }
            if (!moved) {
                stack.pop(); // backtrack
            }
        }
        System.out.println("Oh no!!! Harry couldn't find the Triwizard Cup!\nSomeone quickly gets Professor Dumbledoro.");
    }
    
    public static char[][] readFile(String path){
        char[][] maze = new char[0][0];
        
        try{
            BufferedReader file = new BufferedReader(new FileReader(path));
            
            String line = "", content = "";
            while ((line = file.readLine()) != null) {
                content += line + "\n";
            }
            String[] columns = content.split("\n");
            String[] rows = columns[0].split(" ");

            maze = new char[columns.length][rows.length];
            
            for (int i = 0; i < maze.length; i++) {
                rows = columns[i].split(" ");
                for (int j = 0; j < maze[i].length; j++) {
                    maze[i][j] = rows[j].charAt(0);
                }
            }
            
            file.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + e.getMessage());
        }catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        return maze;
    }
    
    public static void printMaze(char[][] maze){
        System.out.println("The Triwizard Maze:");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public static void printPath(GenericStack<Position> stack){
        System.out.println("Hurray!!! Harry found the Triward Cup at " + stack.peek());
        System.out.print("This is the path Harry has taken: ");
        GenericStack<Position> temp = new GenericStack<>();
        
        // Change LIFO into FIFO for printing
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        int count = 0;
        while (!temp.isEmpty()) {
            if (count++ > 0) {
                System.out.print(" > ");
            }
            System.out.print(temp.pop());
        }
        System.out.println("");
    }
}