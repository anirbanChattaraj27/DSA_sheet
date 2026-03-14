import java.util.*;
import java.lang.*;


// 2 ways -> 1. Math.pow    2. loop
public class O7_N_power {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of base : ");
        double base = sc.nextDouble();

        System.out.print("Enter the value of exponent : ");
        double power = sc.nextDouble();
        
        double result = 1;

        while (power --> 0) {
            result = result * base;
            // --power;
        }

        // for (int i = 1; i <= power; i++)
        //     result = result * base;

        System.out.println("Answer with loop = " + result);
        System.out.println("Answer with built-in function = " + Math.pow(base, power));

    }
}



/*
 *  Enter the value of base : 2
    Enter the value of exponent : 4
    Answer = 16.0
 */