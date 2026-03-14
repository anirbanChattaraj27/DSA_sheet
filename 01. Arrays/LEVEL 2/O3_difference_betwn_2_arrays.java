// problem

// assume array2 is greater

import java.util.Scanner;

public class O3_difference_betwn_2_arrays {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        {
            int n1 = s.nextInt();
            int[] arr1 = new int[n1];
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = s.nextInt();
            }

            int n2 = s.nextInt();
            int[] arr2 = new int[n2];
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = s.nextInt();
            }

            int[] diff = new int[n1 > n2 ? n1 : n2];
            int carry = 0;

            int i = 0;
            int j = 0;
            int k = 0;

            while (k >= 0) {
                int digit = 0;
                int value = i >= 0 ? arr1[i] : 0;

                // we do minus arr1 from arr2
                if (arr2[j] + carry >= value) {
                    digit = arr2[j] + carry - value;
                    carry = 0;
                } else { // this substraction will be done without carry
                    digit = arr2[j] + carry + 10 - value;
                }

                diff[k] = digit;
                i--;
                j--;
                k--;
            }

            int index = 0;
            while (index < diff.length) {
                if (diff[index] == 0) {
                    index++;
                } else {
                    break;
                }
            }

            while (index < diff.length) {
                System.out.print(diff[index]);
                index++;
            }
        }
    }
}