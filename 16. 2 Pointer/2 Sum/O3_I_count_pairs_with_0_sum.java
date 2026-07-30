
// can be saolved using hash and 2 pointer, same as 2 sum, target = 0 assume


public class O3_I_count_pairs_with_0_sum {

    // if array is sorted
    public int countPairs(int[] arr) {

    int left = 0;
    int right = arr.length - 1;
    int count = 0;

    while (left < right) {

        int currentSum = arr[left] + arr[right];

        if (currentSum == 0) {
            count++;
            left++;
            right--;
        }
        else if (currentSum < 0) {
            left++;
        }
        else {
            right--;
        }
    }

    return count;
}
}

