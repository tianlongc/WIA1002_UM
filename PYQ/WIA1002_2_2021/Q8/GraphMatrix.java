/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q8;

/**
 *
 * @author tianlongc
 */
public class GraphMatrix {
    int vertex;
    boolean edges[][];
    
    public GraphMatrix(int v){
        this.vertex = v;
        edges = new boolean[v][v];
    }
    
    public void addEdge(int from, int to){
        edges[from][to] = true;
        edges[to][from] = true;
    }
    
    public void print(){
        System.out.println("Print the graph:");
        for (int i = 0; i < vertex; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < vertex; j++) { // line 19: replace j = i with j = 0
                if (edges[i][j]) {
                    System.out.print(j + " ");
                }
            }
            System.out.println("End of the graph:");
        }
    }
    
    // b) Depth-first search
    
    // c)
    /*
                    0
                    |
                    1
                    | \
                    3  2
                    |
                    7
                    |
                    5
                    |
                    6
                    |
                    4
    */
    // i. The parent of 5: 7
    // ii. The sibling of 3: 2
    // iii. The child of 6: 4
    // iv. The last vertex being marked as visited: 4
}
