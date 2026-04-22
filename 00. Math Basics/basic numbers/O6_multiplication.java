import java.util.*;

public class O6_multiplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int x = sc.nextInt();
        table(x);

    }

    static void table(int x) {
        int i;
        for (i = 1; i <= 10; i++) {
            System.out.println(x + " * " + i + " = " + x * i);
        }
    }
}


