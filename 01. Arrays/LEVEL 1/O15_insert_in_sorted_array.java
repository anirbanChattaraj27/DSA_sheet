/*
    FOUR steps for insertion
        1) Find the spot where the items goes
        2) Make room for the item there
        3) put the item in the array
        4) increase the number of items
*/
import java.util.Scanner;

public class O15_insert_in_sorted_array {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int i, n, num, pos = 0;

        int arr[] = new int[100];

        System.out.println("Enter the size of array : ");
        n = sc.nextInt();

        System.out.println("Enter the elements of the array : ");
        for (i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number to be entered : ");
        num = sc.nextInt();

        /* Find position where elements should be entered. */
        for (i = 0; i < n; i++) {
            if (arr[i] < num) {
                pos++;
            } else {
                break;
            }
        }

        System.out.println(num + " should be entered at position " + pos);

        /*
            * Execute a loop to move all elements right by 1 position having
            * index greater than position where to insert element
        */

        for (i = n - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }

        // Insert element at given position
        arr[pos] = num;

        // Finally print new array after insertion of new element
        System.out.println("\nThe new array is : ");
        for (i = 0; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
