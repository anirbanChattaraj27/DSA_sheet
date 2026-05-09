/*
Example 1:
Input: asteroids = [2, -2]
Output: []
Explanation: The asteroid with size 2 and the one with size -2 collide, exploding each other.

Example 2:
Input: asteroids = [10, 20, -10]
Output: [10, 20]
Explanation: The asteroid with size 20 and the one with size -10 collide, resulting in the remaining asteroid with size 20. The asteroids with sizes 10 and 20 never collide.

LC.: 735 ---> https://leetcode.com/problems/asteroid-collision/
*/

import java.util.*;

// Solution class containing the asteroidCollision logic
class Solution {

    // Function to determine the state of asteroids after all collisions
    public int[] asteroidCollision(int[] asteroids) {
        // Size of the array
        int n = asteroids.length;

        // List acting as a stack to store surviving asteroids
        List<Integer> st = new ArrayList<>();

        // Traverse through each asteroid
        for (int i = 0; i < n; i++) {

            // If asteroid is moving right, push it to the stack
            if (asteroids[i] > 0) {
                st.add(asteroids[i]);
            }

            // If asteroid is moving left, handle possible collisions
            else {
                // Destroy all smaller right-moving asteroids
                while (!st.isEmpty() && st.get(st.size() - 1) > 0 &&
                       st.get(st.size() - 1) < Math.abs(asteroids[i])) {
                    st.remove(st.size() - 1);
                }

                // Destroy both if sizes are equal
                if (!st.isEmpty() && st.get(st.size() - 1) == Math.abs(asteroids[i])) {
                    st.remove(st.size() - 1);
                }

                // If top of stack is a left-moving or no asteroid, add this one
                else if (st.isEmpty() || st.get(st.size() - 1) < 0) {
                    st.add(asteroids[i]);
                }
            }
        }

        // Convert the list to an array
        int[] result = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            result[i] = st.get(i);
        }

        // Return the final state of asteroids
        return result;
    }
}

// Main class containing the main method
public class O18_Aestroid_collison {
    public static void main(String[] args) {
        // Input array representing asteroid directions and sizes
        int[] arr = {10, 20, -10};

        // Create an instance of the Solution class
        Solution sol = new Solution();

        // Call the asteroidCollision function
        int[] ans = sol.asteroidCollision(arr);

        // Print the final state of asteroids
        System.out.print("The state of asteroids after collisions is: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}