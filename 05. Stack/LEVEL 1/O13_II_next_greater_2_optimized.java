/*
here we have to find next greater element for every element, but twist is..... 
for every element i have to go to end and then circulary I have to search looking from 0th idx
*/
// start watching striver playlist from here..... video 6

/*
Example 1:
Input: arr = [3, 10, 4, 2, 1, 2, 6, 1, 7, 2, 9]

Output:  [10, -1, 6, 6, 2, 6, 7, 7, 9, 9, 10]

Explanation: For the first element in arr i.e, 3, the greater element which comes next to it while traversing and is closest to it is 10. Hence,10 is present on index 0 in the resultant array. Now for the second element i.e, 10, there is no greater number and hence -1 is it’s next greater element (NGE). Similarly, we got the NGEs for all other elements present in arr.


Example 2:
Input: arr = [5, 7, 1, 7, 6, 0]

Output: [7, -1, 7, -1, 7, 5]

*/
import java.util.*;

class Solution {

    // Function to find the next greater element for each element in the array
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;

        // To store the next greater elements
        int[] ans = new int[n];

        // Stack to help find next greater elements in reverse traversal
        Stack<Integer> st = new Stack<>();

        // Traverse the array twice in reverse to simulate circular array
        for (int i = 2 * n - 1; i >= 0; i--) {
            int ind = i % n;
            int currEle = arr[ind];

            // Pop all elements from stack that are less than or equal to current
            while (!st.isEmpty() && st.peek() <= currEle) {
                st.pop();
            }

            // Only fill result in the first pass (i < n)
            if (i < n) {
                if (st.isEmpty()) {
                    ans[ind] = -1;
                } else {
                    ans[ind] = st.peek();
                }
            }

            // Push current element to stack
            st.push(currEle);
        }

        return ans;
    }
}

public class O13_II_next_greater_2_optimized {
    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 7, 6, 0};

        // Create instance of Solution
        Solution sol = new Solution();

        // Call the function
        int[] ans = sol.nextGreaterElements(arr);

        System.out.print("The next greater elements are: ");
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}