import java.util.Scanner;

import javax.sql.rowset.spi.SyncResolver;

// give an input n
// n= [7, 1, 0, 5, 3]
/*
    o/p->
            *       -       -       -       -
            *       -       -       *       -
            *       -       -       *       -
            *       -       -       *       *
            *       -       -       *       *
            *       *       -       *       *

*/

public class O1_bar_charts {
    public static void main(String[] args) {

        Scanner s = new Scanner((System.in));

        // enter how many elements u want to print
        System.out.println("Enter how many elements u want to print");
        int n = s.nextInt();
        int[] arr = new int[n];

        // enter numbers in array
        System.out.println("Enter numbers");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        // finding max
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int floor = max; floor >= 1; floor--) {  // starting from max floor upto 1st floor means decrement the values  // column
            for (int i=0; i < arr.length; i++) { // this will analize evry bulding // row
                if (arr[i] >= floor) { // if building is >= to floor
                    System.out.print("*    ");
                } else {
                    System.out.print("-    ");
                }
            }
            System.out.println();
        }
    }
}
