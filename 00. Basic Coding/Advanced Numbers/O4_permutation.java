/*
        ALGORITHM
    Input number of students in n
    Input number of seats in r
    Use permutation formula { factorial(n) / factorial(n-r) }
    Print Output



 */
import java.util.*;

public class O4_permutation {
    public static void main(String[] args) {

        int n, r, fact1, fact2;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Value of n: ");
        n = sc.nextInt();

        System.out.println("Enter the Value of r: ");
        r = sc.nextInt();

        fact1 = 1;

        for (int i = n; i > 1; i--) {
            fact1 = fact1 * i; // calculating factorial (n!)
        }

        int number;

        number = n - r;

        fact2 = 1;

        for (int i = number; i > 1; i--) {
            fact2 = fact2 * i; // calculating factorial ((n-r)!)
        }

        int per = fact1 / fact2; // calculating nPr

        System.out.println(per + " ways");
    }
}



/*
 * o/p ->
 * Enter number of people: 5
   Enter number of seats: 9
   Total possible arrangements: 120
 */