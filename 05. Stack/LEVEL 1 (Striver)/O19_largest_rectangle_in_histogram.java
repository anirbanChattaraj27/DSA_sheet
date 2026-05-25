

import java.util.*;

public class O19_largest_rectangle_in_histogram {

    // Brute force method to find largest rectangle area in a histogram
    public static int largestArea(int[] arr) {
        
        int n = arr.length;
        int maxArea = 0;

        // Loop through all possible start indices
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;

            // Loop through all possible end indices
            for (int j = i; j < n; j++) {
                // Update minimum height in current range
                minHeight = Math.min(minHeight, arr[j]);

                // Calculate area of current rectangle
                int area = minHeight * (j - i + 1);

                // Update maxArea
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // OPTIMIZED 1
    // Main method to compute the largest rectangle area
    public static int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        
        // Separate logic calls
        int[] leftSmall = PSE(heights, n);
        int[] rightSmall = NSE(heights, n);

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightSmall[i] - leftSmall[i] + 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }

    // PSE Logic: Computes the boundaries on the left
    private static int[] PSE(int[] heights, int n) {
        Stack<Integer> st = new Stack<>();
        int[] leftSmall = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            // If empty, boundary extends to the 0th index
            leftSmall[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }
        return leftSmall;
    }

    // NSE Logic: Computes the boundaries on the right
    private static int[] NSE(int[] heights, int n) {
        Stack<Integer> st = new Stack<>();
        int[] rightSmall = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            // If empty, boundary extends to the last index (n - 1)
            rightSmall[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
            st.push(i);
        }
        return rightSmall;
    }



    // OPTIMIZED 2: TC- O(N) SC- O(N)
    public static int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            // When current bar is less than the bar on top of stack, calculate area
            while (!stack.isEmpty() && (i == n || heights[stack.peek()] >= (i < n ? heights[i] : 0))) {
                int height = heights[stack.pop()];

                int width;
                if (stack.isEmpty()) {
                    width = i; // All previous were taller
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        int n = arr.length;

        System.out.println("The largest area in the histogram is " + largestRectangleArea2(arr));
    }
}