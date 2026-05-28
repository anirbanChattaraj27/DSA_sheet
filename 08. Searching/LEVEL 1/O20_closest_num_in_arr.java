// Java program to find closest number in a sorted array
// https://www.geeksforgeeks.org/dsa/find-closest-number-array/

class O20_closest_num_in_arr {
    static int findClosest(int[] arr, int target) {
        int res = arr[0];
        int lo = 0, hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // Update res if mid is closer to target
            if (Math.abs(arr[mid] - target) < Math.abs(res - target)) {
                res = arr[mid];

            // In case of a tie, prefer larger value
            } else if (Math.abs(arr[mid] - target) == Math.abs(res - target)) {
                res = Math.max(res, arr[mid]);
            }

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 6, 8, 8, 9};
        int target = 11;

        System.out.println(findClosest(arr, target));
    }
}