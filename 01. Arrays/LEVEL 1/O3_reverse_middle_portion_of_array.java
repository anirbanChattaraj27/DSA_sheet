import java.util.Scanner;

// this code is exactly similer like previous code

public class O3_reverse_middle_portion_of_array {

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // here reverse starts starting index starts from 0
    // arr[1, 2, 3, 4, 5], start = 2, end = 4      so, O/P --> 1, 2, 5, 4, 3
    public static void reverse(int[] arr, int start, int end) {

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // here reverse starts starting index starts from 1
    // arr[1, 2, 3, 4, 5], start = 2, end = 4      so, O/P --> 1, 4, 3, 2, 5
    public static void reverse2(int[] arr, int start, int end) {
        start = start-1;
        end = end-1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // int arr[] = {12, 45, 65, 35, 29, 1};
        // display(arr);

        // reverse(arr, 2, 3);
        // display(arr);

        System.out.println("enter array size:");
        int arrSize = s.nextInt();

        int arr[] = new int[arrSize];

        System.out.println("Enter elements");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println("enter start index");
        int startIndx = s.nextInt();

        System.out.println("enter last index");
        int endIndx = s.nextInt();

        reverse(arr, startIndx, endIndx);
        display(arr);
    }
}
