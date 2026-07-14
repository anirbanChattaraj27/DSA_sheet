// Time Complexity: O(N*2). There are two nested loops that account for O(N*2) complexity

// Space Complexity: O(1). We are using three external arrays of size ‘2’.


import java.util.*;

class Solution{
    // Function to calculate the maximum profit from stock trading
    static int stockProfit(int[] Arr) {
        int n = Arr.length;
        int[] cur = new int[2];
        int[] front1 = new int[2];
        int[] front2 = new int[2];
        
        // Iterate through the array backwards
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + front1[0], -Arr[ind] + front1[1]);
                }

                if (buy == 1) { // We can sell the stock
                    profit = Math.max(0 + front1[1], Arr[ind] + front2[0]);
                }

                cur[buy] = profit;
            }

            // Update front1 and front2 arrays
            System.arraycopy(front1, 0, front2, 0, 2);
            System.arraycopy(cur, 0, front1, 0, 2);
        }

        // The maximum profit is stored in cur[0]
        return cur[0];
    }

    public static void main(String args[]) {
        int prices[] = {4, 9, 0, 4, 10};

        System.out.println("The maximum profit that can be generated is " + stockProfit(prices));
    }
}