import java.util.*;
import java.lang.*;

public class O8_cube_sqr_root {
    
    static double SquareRoot(int x) {
        double sq;
        sq = Math.sqrt(x);
        return sq;
    }
    
    static double CubeRoot(int x) {
        double cb;
        cb = Math.cbrt(x);
        return cb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter sqrt value: ");
        int x = sc.nextInt();

        System.out.println("cube root value : ");
        int y = sc.nextInt();

        System.out.println("The square root of " + x + " is : " + SquareRoot(x));
        System.out.println("The cube root of " + y + " is : " + CubeRoot(y));
    }
}
