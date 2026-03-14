// this bellow code is exactly same as book allocation prblm, just 1 line extra that is this function "findLargestMinDistance"

import java.util.*;

public class O8_Painter_partition {

    // Count how many painters (students) are required
    public static int countStudents(int[] arr, int pages) {
        int students = 1;
        long pagesStudent = 0;

        for (int i = 0; i < arr.length; i++) {
            if (pagesStudent + arr[i] <= pages) {
                pagesStudent += arr[i];
            } else {
                students += 1;
                pagesStudent = arr[i];
            }
        }
        return students;
    }

    public static int findPages(int[] arr, int n, int m) {
        if (m > n) return -1;

        int low = Integer.MIN_VALUE;
        int high = 0;

        // equivalent to max_element and accumulate
        for (int i = 0; i < n; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int students = countStudents(arr, mid);

            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    // Same wrapper function as in image
    public static int findLargestMinDistance(int[] boards, int k) {
        return findPages(boards, boards.length, k);
    }

    public static void main(String[] args) {

        // Hardcoded input
        int[] boards = {10, 20, 30, 40};
        int k = 2;

        int result = findLargestMinDistance(boards, k);

        if (result == -1) {
            System.out.println("Allocation not possible");
        } else {
            System.out.println("Minimum time required: " + result);
        }
    }
}
