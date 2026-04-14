import java.util.*;

public class O24_longest_palindrome_in_arr {

    static boolean isPalindrome1(int num){
        String s = "";
        String cpy = Integer.toString(num);

        while(num > 0){
            s += num%10;
            num /= 10;
        }
        return s.equals(cpy); 
    }
    
    // better approch just sort the array and apply palindrom func
    static int largestPalindrome2(int[] A, int n) {
        Arrays.sort(A);
        for (int i = n - 1; i >= 0; i--) {
            if (isPalindrome1(A[i]))
            return A[i];
        }
        return -1;
    }
    
    // Optimal way 
    static int largestPalindrome(int[] A, int n) {
        int res = -1;

        for (int i = 0; i < n; i++) { // If a palindrome larger than the currentMax is found
            if (isPalindrome1(A[i]))
                res = Math.max(res, A[i]);
        }

        // Return the largest palindromic number from the array
        return res;
    }

    // Driver program
    public static void main(String[] args) {
        int[] A = { 121, 2322, 54545, 999990 };
        int n = A.length;

        // print required answer
        System.out.println(largestPalindrome(A, n));
    }

}
