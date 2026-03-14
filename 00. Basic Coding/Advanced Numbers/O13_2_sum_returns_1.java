// 1^2 + 0^2 + 0^2 = 1

public class O13_2_sum_returns_1 {
    // if sum of each number returns 1 return true
    static boolean digSum2(int n) {
        int sum = 0;
        
        while (n != 1 && n != 4) { /* This while loop is used to repeatedly check the value of n and perform some calculations until either of the two conditions is met: n becomes 1 (indicating it's a happy number) or n becomes 4 (indicating it's not a happy number).   ||   The logic behind this loop is based on the fact that for non-happy numbers, the calculations will eventually lead to a cycle, and in that cycle, 4 is a repeating number. So, as long as n is not equal to 1 (indicating it's not a happy number) and not equal to 4 (indicating it's not yet determined), the loop continues to perform the calculations.   ||   Once n reaches 1, it breaks out of the loop and returns true to indicate that the input number is a happy number. If, during the calculations, it encounters the number 4, it also breaks out of the loop and returns false, indicating that the input number is not a happy number.    ||    This loop is a key part of the algorithm to determine if a number is a happy number or not by avoiding unnecessary calculations and detecting the cycle that occurs in non-happy numbers. */
            while (n > 0) {
                int lastDigit = n % 10;
                sum += lastDigit * lastDigit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(digSum2(100));
    }
}

