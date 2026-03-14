// Strong number is a special number whose sum of the 
// factorial of digits is equal to the original number. 
// For Example: 145 is strong number. Since, 1! + 4! + 5!

public class O22_strongNumber {
    
    // function to calculate factorial
    static int facto(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++)
            fact = fact * i;

        return fact;
    }

    static boolean detectStrong(int num) {

        int remainder, sum = 0;
        int temp = num;

        // calculate 1! + 4! + 5!
        while (temp != 0) {
            remainder = temp % 10;
            sum = sum + facto(remainder);
            temp /= 10;
        }
        
        // returns 1 if both equal else 0
        if (sum == num)
            return true;
        
        return false;

    }

    public static void main(String[] args) {
    
        int num = 145;
    
        if (detectStrong(num))
            System.out.println(num + " is Strong Number");
        else
            System.out.println(num + " is not a Strong Number");
    }
}
