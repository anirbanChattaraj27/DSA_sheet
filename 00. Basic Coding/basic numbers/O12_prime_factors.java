// prime factors of a number and
// factors of a number ARE SAME

import java.util.*;

public class O12_prime_factors {

    public static boolean isPrime(int num) {

        if (num < 2){
            return false;
        }

        for (int i = 2; i < num/2; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void primeFactors(int num) {

        for (int i = 2; i <= num; i++) {
            if (isPrime(i)) {
                while (num % i == 0) {
                    System.out.print(i + " ");
                    num /= i;
                }
            }
        }
    }

    public static void main(String args[]) {

        int n = 27;
        primeFactors(n);
        // int number;
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter a number ::");
        // number = sc.nextInt();

        // for (int i = 2; i < number; i++) { // for(i=2; i <= n/2; i++) // for (i = 2;
        // i < n; i++)
        // while (number % i == 0) {
        // System.out.print(i + " ");
        // number = number / i;
        // }
        // }

        // if (number > 2) {
        // System.out.println(number);
        // }
    }
}
