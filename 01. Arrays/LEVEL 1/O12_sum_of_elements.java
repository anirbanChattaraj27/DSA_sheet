import java.util.Scanner;

public class O12_sum_of_elements {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int sum = 0;
        int arr[] = new int[5];

        System.out.println("Enter all elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println(sum);
    }
}
