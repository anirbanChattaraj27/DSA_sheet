/* when COUNT is there, there are 2 types of question
    1. count pair with given sum || with 0 sum
    2.count pair with less than or equal to target || greater than or equal to target
        a) count pairs < target
        b) count pairs <= target
        c) count pairs > target
        d) count pairs >= target
*/
// can be saolved using hash and 2 pointer

public class O3_II_print_pair_with_0_sum {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int target = 6;

        int count = countPairs(arr, target);

        System.out.println("Count of Pairs = " + count);
    }

    public static int countPairs(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        int count = 0;

        while (left < right) {

            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                count++;
                left++;
                right--;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

}

