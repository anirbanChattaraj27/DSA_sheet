// NOTE-> ✨✨
// here i created an array of size more than required and i did not travarse whole array i travarsed only upto required length

import javax.print.event.PrintJobListener;

import org.omg.Messaging.SyncScopeHelper;

public class O1_decimal_to_binary {

    public static void decimalTObinary(int empty) {

        int decimal = 25;
        int binary[] = new int[20]; // integer array for storing binary digits
        int n = 0;

        while (decimal > 0) {
            int remainder = decimal % 2;
            binary[n++] = remainder; // ✨✨
            decimal = decimal / 2;
        }

        // printing array numbers
        System.out.print("decimal to Binary number : ");
        for (int j = n - 1; j >= 0; j--)  // ✨✨ here i startd the loop from n-1. inside the loop i increment n and where n will stop from there loop is running and printing digits
            System.out.print(binary[j] + "");

        System.out.println("\n");
    }

    public static void binaryTOdecimal(int empty) {

        int binary = 101010;
        int decimal = 0;
        int n = 0; // Declaring variable to use in power
        
        while (binary > 0) {
            int remainder = binary % 10;
            decimal += remainder * Math.pow(2, n);
            binary = binary / 10;
            n++;
        }
        System.out.println("binary to Decimal number : " + decimal);
    }

    public static void main(String[] args) {
        int empty = 0; // these numbers are not using

        decimalTObinary(empty);
        binaryTOdecimal(empty);

    }

}