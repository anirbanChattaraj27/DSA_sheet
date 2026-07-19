

import java.util.*;

public class O1_II_LIS_BS {

    // Returns the index of the first element >= target
    static int lowerBound(List<Integer> list, int target) {

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (list.get(mid) >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    static int lengthOfLIS(int[] nums) {

        List<Integer> temp = new ArrayList<>();

        for (int num : nums) {

            int index = lowerBound(temp, num);

            if (index == temp.size()) {
                temp.add(num);          // Extend LIS
            } else {
                temp.set(index, num);   // Replace
            }
        }

        return temp.size();
    }

    // using ArrayList
    static int lengthOfLIS2(int[] nums) {

        List<Integer> temp = new ArrayList<>();

        for (int num : nums) {

            int index = Collections.binarySearch(temp, num);

            if (index < 0) {
                index = -(index + 1);   // insertion point
            }

            if (index == temp.size()) {
                temp.add(num);
            } else {
                temp.set(index, num);
            }
        }

        return temp.size();
    }

    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        // ARRAY
        System.out.println("Length of LIS using Array -> " + lengthOfLIS(nums));

        // ARRAYLIST
        System.out.println("Length of LIS using ARRAYLIST -> " + lengthOfLIS2(nums));
    } 
}