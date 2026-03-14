public class O16_palindrome {

    // easiest method
    static boolean usingStr(int num){
        String s = "";
        String cpy = Integer.toString(num);

        while(num > 0){ 
            s += num%10;
            num /= 10;
        }
        return s.equals(cpy); // equals compare value and == compare address
    }

    // recursive fun
    static int getReverse(int num, int rev) {
        if (num == 0)
            return rev;

        int rem = num % 10;
        rev = rev * 10 + rem;

        return getReverse(num / 10, rev);
    }

    public static long reverse(int num){

        boolean isNegetive = num < 0;
        if(isNegetive){
            num = num * -1;
        }
        long reverse = 0;

        int lastDigit;
        while(num > 0){
            lastDigit = num % 10;
            reverse = reverse *10 + lastDigit;
            num = num / 10;
        }

        return isNegetive? reverse * -1 : reverse; 
    }

    // Function to check if n is palindrome
    static boolean isPalindrome2(int n) {
        // Find the appropriate divisor
        // to extract the leading digit
        int divisor = 1;
        while (n / divisor >= 10)
            divisor *= 10;

        while (n != 0) {
            int x = n / divisor;
            int y = n % 10;

            // If first and last digits are
            // not same then return false
            if (x != y)
                return false;

            // Removing the leading and trailing
            // digits from the number
            n = (n % divisor) / 10;

            // Reducing divisor by a factor
            // of 2 as 2 digits are dropped
            divisor = divisor / 100;
        }
        return true;
    }

    public static void main(String[] args) {
        // variables initialization
        int num = 77177, reverse = 0;
        
        System.out.println(usingStr(num));


        // recursive function
        // palindrome if num and reverse are equal
        if (getReverse(num, reverse) == num)
            System.out.println(num + " is Palindrome");
        else
            System.out.println(num + " is not Palindrome");


        // normal function
        if (reverse(num) == num)
            System.out.println(num + " is Palindrome");
        else
            System.out.println(num + " is not Palindrome");

    }
}

