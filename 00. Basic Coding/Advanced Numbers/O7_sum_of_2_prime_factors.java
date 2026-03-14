
import java.util.Scanner;

public class O7_sum_of_2_prime_factors {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int number = sc.nextInt();
        int x = 0;

        for (int i = 2; i <= number / 2; i++) {
            if (isPrime(i) == 1) {
                if (isPrime(number - i) == 1) {
                    System.out.println(number + " = " + i + " + " + (number - i));
                    x = 1;
                }
            }
        }
        if (x == 0)
            System.out.println(+number + " cannot be expressed as a sum of two prime numbers");
    }

    // function for checking number is prime or not
    public static int isPrime(int n) {
        int c = 1;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                c = 0;
                break;
            }
        }
        return c;
    }
}


// Enter a number: 14
// 14 = 3 + 11
// 14 = 7 + 7
// prime nums are 3, 11, 7, 7 // so 3 + 11 &&  7 + 7