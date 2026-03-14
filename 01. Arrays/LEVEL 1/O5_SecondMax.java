import java.util.*;

public class O5_SecondMax {

    public static void display(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int findSecondMax(int[] arr) {
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            }

            else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    static void len(int arr[]) {
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 2]);
    }

    public static void main(String[] args) {
        int[] arr = { 25, 24, 22, 12 };
        display(arr);
        System.out.println(findSecondMax(arr));
        len(arr);
    }

}
