import java.util.*;

public class O5_rounding_of_num {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a decimal number: ");
        double num = sc.nextDouble();

        System.out.println(Math.round(num));
        System.out.println(Math.floor(num));
        System.out.println(Math.ceil(num));
        
        
        int a = 12;
        int b = 14;
        System.out.println("with using Math.abs-> " + Math.abs(a-b));
        System.out.println();
        System.out.println("without using Math.abs-> " + (a-b));
    }
} 
