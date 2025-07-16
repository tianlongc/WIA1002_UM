/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package L7;

/**
 *
 * @author tianlongc
 */

import java.util.Scanner;
/**
 *   Buy 100 shares at $10 each
 *   Buy 50 shares at $20 each
 *   Sell 50 shares at $20 each
 *   Sell 60 shares at $30 each
 *   Sell 50 shares at $35 each 
 */
public class L7Q3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue<Integer> shareQ = new MyQueue<>();
        MyQueue<Integer> priceQ = new MyQueue<>();
        
        int totalGainLoss = 0;
        
        while (true) {
            System.out.print("Enter your query (In format 'Buy / Sell x shares at $y each'): ");
            String input = sc.nextLine().toLowerCase();
            // Enter key to terminate input
            if (input.isEmpty()) {
                break;
            /** ^ ensures the match starts at the beginning of the string.
                $ ensures the match goes until the end of the string. **/
            }else if (!(input.matches("^(buy|sell) (\\d+) shares at \\$(\\d+) each"))) {
                System.out.println("Invalid format! Please try again.");
                continue;
            }
            // Format the input by splitting (space as delimiter)
            String[] parts = input.split("\\s+");
            /** Example Input: 
                buy         [0]
                x           [1]
                share(s)    [2]
                at          [3]
                $y          [4]
                each        [5] **/
            // let x = amount of shares, y = price of share
            int x = Integer.parseInt(parts[1]);
//            int y = Integer.parseInt(parts[4].replace("$", ""));
            int y = Integer.parseInt(parts[4].substring(1)); // skip 0th which is $
            
            if (parts[0].equals("buy")) {
                System.out.println("Buying now...");
                shareQ.enqueue(x);
                priceQ.enqueue(y);
            }else if (parts[0].equals("sell")){
                System.out.println("Selling the shares now...");
                
                while (x > 0) {
                    if (shareQ.isEmpty()) {
                        System.out.println("No shares to sell!");
                        break;
                    }
                    /** 
                      Outside loop: uses stale values; fails if queue changes (e.g. after dequeue)
                      Inside loop: always checks current queue state; works with dynamic queues
                     **/
                    int share = shareQ.peek();
                    int price = priceQ.peek();
                    
                    if (x >= share) {
                        totalGainLoss += share * (y - price);
                        x -= share;
                        shareQ.dequeue();
                        priceQ.dequeue();
                    }else{
                        totalGainLoss += x * (y - price);
                        shareQ.enqueue(share - x);
                        shareQ.dequeue();
                        priceQ.enqueue(price);
                        priceQ.dequeue();
                        // i > 0 to skip the first element and remove the elements before the first element
                        for (int i = shareQ.getSize()-1; i > 0; i--) {
                            shareQ.enqueue(shareQ.dequeue());
                            priceQ.enqueue(priceQ.dequeue());
                        }
                        x = 0; // resets x
                    }
                    System.out.println("Total Capital Gain / Loss: " + totalGainLoss);
                }
            }
            System.out.println("Queue for Share: " + shareQ);
            System.out.println("Queue for Price: " + priceQ);
        }
        System.out.println("Final Capital Gain / Loss: " + totalGainLoss);
        
        sc.close();
    }
}