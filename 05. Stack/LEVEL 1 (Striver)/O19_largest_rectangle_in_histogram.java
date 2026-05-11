

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

    // OPTIMIZED 1: TC- O(5N) SC- O(5N)
    public static int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] leftsmall = new int[n];
        int[] rightsmall = new int[n];

        // Compute NSL (Nearest Smaller to Left)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            leftsmall[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }

        // Clear the stack for reuse
        st.clear();

        // Compute NSR (Nearest Smaller to Right)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            rightsmall[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
            st.push(i);
        }

        // Compute max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = rightsmall[i] - leftsmall[i] + 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
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
        int[] arr = {2, 1, 5, 6, 2, 3, 1};
        int n = arr.length;

        System.out.println("The largest area in the histogram is " + largestRectangleArea2(arr));
    }
}