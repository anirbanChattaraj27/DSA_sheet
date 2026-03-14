public class O11_prime_within_range {
    static boolean isPrime1(int n) {

        // 0, 1 negative numbers are not prime
        if (n < 2)
            return false;

        // checking the number of divisors b/w 1 and the number n-1
        for (int i = 2; i < n; i++) { // for(i=2; i <= n/2; i++)   // for (i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        }

        // if reached here then must be true
        return true;
    }

    public static void main(String[] args) {

        int lower = 1, upper = 20;

        for (int i = lower; i <= upper; i++){

            if (isPrime1(i))
                System.out.println(i);
        }
    }
}
