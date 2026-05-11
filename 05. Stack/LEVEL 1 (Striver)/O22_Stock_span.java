/*
Example 1:
Input: n = 7, arr = [120, 100, 60, 80, 90, 110, 115]
Output: 1 1 1 2 3 5 6
Explanation:
    Traversing the given input span:
    120 is greater than or equal to 120 and there are no more elements behind it so the span is 1,
    100 is greater than or equal to 100 and smaller than 120 so the span is 1,
    60 is greater than or equal to 60 and smaller than 100 so the span is 1,
    80 is greater than or equal to 60, 80 and smaller than 100 so the span is 2,
    90 is greater than or equal to 60, 80, 90 and smaller than 100 so the span is 3,
    110 is greater than or equal to 60, 80, 90, 100, 110 and smaller than 120 so the span is 5,
    115 is greater than or equal to all previous elements and smaller than 120 so the span is 6.
    Hence the output will be 1 1 1 2 3 5 6.

Example 2:
Input: n = 6, arr = [15, 13, 12, 14, 16, 20]
Output: 1 1 1 3 5 6

Explanation:
    Traversing the given input span:
    15 is greater than or equal to 15 and there are no more elements behind it, so the span is 1.
    13 is smaller than 15, so the span is 1.
    12 is smaller than 13, so the span is 1.
    14 is greater than or equal to 12 and 13, but smaller than 15, so the span is 3 (days with values 12, 13, and 14).
    16 is greater than or equal to 14, 12, 13, and 15, so the span is 5.
    20 is greater than or equal to all previous elements, so the span is 6.
    Hence the output will be 1 1 1 3 5 6.
*/


import java.util.*;

class Solution {

    // BRUTE
    public int[] stockSpan(int[] arr, int n) {
        // To store the answer (stock span for each day)
        int[] ans = new int[n];
        
        // Traverse through the array
        for(int i = 0; i < n; i++) {
            // To store the current span of stocks
            int currSpan = 0;
            
            // Traverse backwards to find stock span
            for(int j = i; j >= 0; j--) {
                // Update stock span if the current price is less than or equal to current price
                if(arr[j] <= arr[i]) {
                    currSpan++;
                }
                // Else, break the loop when a higher stock price is found
                else {
                    break;
                }
            }
            
            // Store the current span in the result array
            ans[i] = currSpan;
        }
        
        // Return the computed stock span for each day
        return ans;
    }
    

    // OPTIMIZED
    // Func to find PGE Idx
    private int[] findPGE(int[] arr) {
        int n = arr.length; // Size of the array
        
        // To store the previous greater elements
        int[] ans = new int[n];
        
        // Stack to get elements in LIFO fashion
        Stack<Integer> st = new Stack<>();
        
        // Start traversing from the front
        for (int i = 0; i < n; i++) {
            // Get the current element
            int currEle = arr[i];
            
            // Pop elements from the stack until we find a greater element
            while (!st.isEmpty() && arr[st.peek()] <= currEle) {
                st.pop();
            }
            
            // If the stack is empty, it means there's no greater element, so assign -1
            if (st.isEmpty()) 
                ans[i] = -1;
            else 
                ans[i] = st.peek(); // Otherwise, the top element is the previous greater
            
            // Push the current index in the stack
            st.push(i);
        }
        
        // Return the result (indices of previous greater elements)
        return ans;
    }
    
    // Function to find the span of stock prices for each day
    public int[] stockSpanOPTIMIZED(int[] arr, int n) {
        // Get the indices of previous greater elements
        int[] PGE = findPGE(arr);
        for(int i=0; i<PGE.length; i++){
            System.out.println(PGE[i]);
        }
        
        // To store the final span results
        int[] ans = new int[n];
        
        // Compute the span for each element using the previous greater element indices
        for (int i = 0; i < n; i++) {
            ans[i] = i - PGE[i]; // Calculate span based on previous greater element
        }
        
        // Return the result (stock span for each day)
        return ans;
    }
    
}

public class O22_Stock_span {
    public static void main(String[] args) {
        int n = 7; // Number of days
        int[] arr = {120, 100, 60, 80, 90, 110, 115}; // Stock prices for each day
        
        // Create an instance of the Solution class
        Solution sol = new Solution(); 
        
        // Call the function to find the stock span for each day
        int[] ans = sol.stockSpan(arr, n);
        
        // Print the result
        System.out.print("The span of stock prices is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " "); // Display the span of each day
        }
    }
}