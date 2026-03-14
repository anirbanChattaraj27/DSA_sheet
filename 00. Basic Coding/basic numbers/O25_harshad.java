/*
 * Suppose a number 24 .
   Calculate the sum of digits of the number (2 + 4) = 6
   if 24 / 6 is divisible then harshad
 */

public class O25_harshad {
    public static void main(String[] args) {
        // make a copy of original number
        int n = 24;
        int temp = n;
        // declare a variable to store sum of digits
        int result = 0;
        // perform logic for calculating sum of digits of a number
        while (temp != 0) {
            int lastDigit = temp % 10;
            result = result + lastDigit;
            temp = temp / 10;
        }
        
        if (n % result == 0)
            System.out.println("Harshad Number");
        else
            System.out.println("Not a Harshad Number");
    }
}
