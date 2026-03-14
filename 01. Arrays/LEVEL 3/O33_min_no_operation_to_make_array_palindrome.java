// Program to Find Minimum Number of Merge Operations required to make an Array Palindrome in Java

// If arr[i] = arr[j], then there is no need to merge the elements. Increment i and decrement j
// If arr[i] > arr[j], then do merge operation at index j ie, arr[j-1] = arr[j-1] + arr[j], decrement j and increment the no of merge operations count by 1
// If arr[i] < arr[j], then do merge operation at index i ie, arr[i+1] = arr[i+1] + arr[i], increment i and increment the no of merge operations count by 1.

public class O33_min_no_operation_to_make_array_palindrome {

    static int findMinOps(int[] arr, int n) {

        int i = arr[0];
        int j = arr.length-1;
        int ans = 0;

        // Start from two corners
        while(i < j) {
            // If corner elements are same, move i and j
            if (arr[i] == arr[j]) {
                i++;
                j--;
            }

            // If left element is greater, then we merge right two elements
            else if (arr[i] > arr[j]) {
                // need to merge from tail.
                j--;
                arr[j] += arr[j + 1];
                ans++;
            }

            // Else we merge left two elements
            else {
                i++;
                arr[i] += arr[i - 1];
                ans++;
            }
        }
        return ans;
    }

    // Driver method to test the above function
    public static void main(String[] args) {
        // int arr[] = new int[] { 1, 4, 5, 9, 1 };
        int arr[] = new int[] { 1, 2, 3, 5, 3, 2, 4};
        // int arr[] = new int[] { 1, 4, 5, 1, 2};
        System.out.println("Count of minimum operations is " + findMinOps(arr, arr.length));

    }
}
