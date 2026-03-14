public class O7_lcm {

    // Recursive function to return gcd of a and b
    static int gcd(int num1, int num2) {
        // Everything divides 0
        if (num1 == 0)
            return num2;

        if (num2 == 0)
            return num1;

        // base case
        if (num1 == num2)
            return num1;

        // a is greater
        if (num1 > num2)
            return gcd(num1 - num2, num2);
        return gcd(num1, num2 - num1);
    }
    
    // method to return LCM of two numbers
    static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
    // Driver method
    public
    static void main(String[] args) {
        int a = 15, b = 20;
        System.out.println("LCM of " + a + " and " + b + " is " + lcm(a, b));
    }

}
