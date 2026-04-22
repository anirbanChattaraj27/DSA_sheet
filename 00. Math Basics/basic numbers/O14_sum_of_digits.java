public class O14_sum_of_digits {
    public static void main(String[] args) {

        int num = 12345, sum = 0, last = 1;

        // loop to find sum of digits
        while (num != 0) {
            // sum += num % 10; // both are correct
            // num = num / 10;

            last = num%10;
            sum += last;
            num = num/10;
        }

        // output
        System.out.println("Sum of digits : " + sum);
    }
}
