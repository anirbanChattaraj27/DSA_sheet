/*
    Traverse through the array, and for every index, find the number of smaller 
    elements on its right side of the array. This can be done using a nested loop. 
    Sum up the counts for all indices in the array and print the sum.

    Input: arr[] = {8, 4, 2, 1}
    Output: 6
    Explanation: Given array has six inversions: (8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).

    Input: arr[] = {1, 20, 6, 4, 5}
    Output: 5
    Explanation: Given array has five inversions: (20, 6), (20, 4), (20, 5), (6, 4), (6, 5)
*/

public class O31_count_inversion {
    // static int arr[] = new int[] { 1, 6, 4, 5 };

    static int getInvCount(int arr[]) {
        int inv_count = 0;

        for (int i=0; i<arr.length-1; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] > arr[j])
                    inv_count++;
        return inv_count;
    }

    // Driver method to test the above function
    public static void main(String[] args) {
        int arr[] = { 8, 4, 2, 1 };
        System.out.println("Number of inversions are " + getInvCount(arr)); //(6,4), (6,5)
        // printInversion(arr); 
    }
}
