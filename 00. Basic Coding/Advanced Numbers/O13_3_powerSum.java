/*
 * TYPE 1: n = 2314 = 2^3  +  3^1  +  1^4  +  4^0 = 13  [if i initialize power value with 0]
 * TYPE 2: n = 2314 = 2^3  +  3^1  +  1^4  +  4^1 = 16  [if i initialize power value with 1]
 */

public class O13_3_powerSum{

    public static void main(String[] args) {

        int n = 2314;
        int sum =0;
        int power = 1;

        while(n > 0){
            int last = n%10;
            sum = sum + (int)Math.pow(last, power);
            power = last;
            n /=10;
        }
        System.out.println(sum);
    }
}