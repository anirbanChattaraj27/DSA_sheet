// 5674
// 5 + 6 + 7 + 4 = 22
// 2 + 2 = 4

// Input : 5674
// Output : 4 


public class O13_1_sum_of_number_until_it_forms_single_digit{

    static int digSum(int n) {
        int sum = 0;

        // Loop to do sum while sum is not less than or equal to 9
        while (n > 0 || sum > 9) { //extra line
            if (n == 0) { // extra line
                n = sum;
                sum = 0;
            }
            int last = n%10;
            sum += last;
            n = n/10;
        }
        return sum;
    }

    public static void main(String argc[]) {
        int n = 456; // 6+5+4 = 15 = 6
        System.out.println(digSum(n));
    }
}