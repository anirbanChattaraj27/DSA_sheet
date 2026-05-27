// LC 881

/*
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats 
where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, 
provided the sum of the weight of those people is at most limit.

Return the minimum number of boats to carry every given person.

Example 2:
Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

Example 3:
Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)

*/
import java.util.*;

public class O8_Boats_to_save_people {

    // classic way
    public int numRescueBoats(int[] people, int target) {
        Arrays.sort(people);
         
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            // If the lightest and heaviest can share, move the left pointer
            if (people[left] + people[right] <= target) {
                left++;
            }
            // The heaviest person always gets a boat
            right--;
            boats++;
        }        
        return boats;
    }

    // LC 2824, kind of similar code, needs to understand this in depth
    // count pairs with sum  < target
    public int numRescueBoats2(int[] nums, int target) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        // 1. Use <= so the last remaining person gets a boat
        while (left <= right) { 
            
            // 2. Handle the last single person remaining
            if (left == right) {
                count++;
                break; 
            }

            int sum = nums[left] + nums[right];

            // 3. Changed to <= (if sum equals target, they can still share!)
            if (sum <= target) { 
                count++;
                left++;  // Light person gets on the boat
                right--; // Heavy person gets on the same boat
            } else {
                // 4. If they don't fit, the heavy person MUST take a boat alone
                count++; 
                right--; // Only the heavy person gets on the boat
            }
        }        
        return count;
    }
}
