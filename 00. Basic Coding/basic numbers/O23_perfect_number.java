// perfect number, a positive integer that is equal to the 
// sum of its proper divisors. The smallest perfect number 
// is 6, which is the sum of 1, 2, and 3.
// 6 = 1+2+3 [1,2,3 are its divisors]

public class O23_perfect_number {
    public static void main(String[] args) {

        int n = 28, sum = 0;

        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                sum = sum + i;
        }

        if (sum == n)
            System.out.println(n + " Is a perfect number");
        else
            System.out.println(n + " Is not a perfect number");

    }
}


