import java.util.*;

public class O7_book_allocation {

    // Function to count how many students are needed
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

    // Function to find minimum number of maximum pages
    public static int findPages(int[] arr, int n, int m) {
        if (m > n) return -1;

        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int students = countStudents(arr, mid);

            if (students > m) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        // Hardcoded input
        int[] arr = {12, 34, 67, 90};
        int n = arr.length;
        int m = 2;

        int result = findPages(arr, n, m);

        if (result == -1) {
            System.out.println("Allocation not possible");
        } else {
            System.out.println("Minimum maximum pages allocated: " + result);
        }
    }
}
