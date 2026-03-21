// i/p = 12, 16, 22, 12, 16
// o/p = 2
// bcz, 12+16+22 = 50 and 22 is in middle so this  is equilibrium index

public class O7_find_equilibrium_index_of_array {

    // OPTIMIZED
    public static int findEquilibriumIdx(int[] nums, int n) {
        // Calculate the total sum of the array
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        // Initialize left and right sums
        int leftSum = 0, rightSum = totalSum;

        // Loop through the array to check if any index is the equilibrium index
        for (int i = 0; i < n; i++) {
            rightSum -= nums[i];  // Subtract the current element from right sum

            // Check if left sum is equal to right sum
            if (leftSum == rightSum) {
                return i;  // Return the equilibrium index
            }

            leftSum += nums[i];  // Add the current element to left sum
        }

        return -1;  // Return -1 if no equilibrium index is found
    }

    // BRUTE-FORCE
    static int equilibrium_index(int arr[], int n) {

        int i, j;
        int leftsum, rightsum;
        
        for (i = 0; i < n; ++i) {

            leftsum = 0;
            for (j = 0; j < i; j++)
                leftsum += arr[j];

            rightsum = 0;
            for (j = i + 1; j < n; j++)
                rightsum += arr[j];

            if (leftsum == rightsum)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        
        int arr[] = { 1,2,1,1,2};
        int arr_size = arr.length;
        
        System.out.print("Equilibrium Index : ");
        System.out.println(equilibrium_index(arr, arr_size));
    }
}