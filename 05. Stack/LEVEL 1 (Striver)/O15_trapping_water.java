// https://www.geeksforgeeks.org/trapping-rain-water/

public class O15_trapping_water {

    public static int trap(int[] height, int n) {

        // Variable to store total trapped water
        int totalWater = 0;

        for (int i = 0; i < n; i++) {
            int maxLeft = 0;
            int maxRight = 0;

            // Find maximum height to the left of current bar
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            // Find maximum height to the right of current bar
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            // Water trapped on current bar is min of maxLeft and maxRight minus current height
            totalWater += Math.min(maxLeft, maxRight) - height[i];
        }

        return totalWater;
    }

    // striver code
    public static int maxWater2(int[] height, int n) {

        int left = 0;
        int right = n - 1;
        int res = 0;
        int maxleft = 0, maxright = 0;

        while (left <= right) {

            if (height[left] <= height[right]) {

                if (height[left] >= maxleft)
                    maxleft = height[left];
                else
                    res += maxleft - height[left];

                left++;
            } 
            else {

                if (height[right] >= maxright)
                    maxright = height[right]; 

                else
                    res += maxright - height[right];

                right--;
            }
        }
        return res;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int n = arr.length;
        System.out.print(maxWater2(arr, n));
    }
}