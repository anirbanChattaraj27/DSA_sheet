/*
 * Num = 9474
 * 9^4  +  4^4  +  7^4  +  4^4  =  9474
 * 
 * num = 153
 * 1^3  +  5^3  +  3^3  =  153
 */


public class O17_armstrong {
   
    static int order(int x) {
        int len = 0;
        while (x != 0) {
            len++;
            x = x / 10;
        }
        return len;
    }

    static boolean armstrong(int n){
        int temp = n;
        int last = 0;
        int sum = 0;
        while(temp > 0){
            last = temp%10;
            sum += Math.pow(last, order(n));
            temp = temp/10;
        }
        return sum==n;
    }

     public static void main(String[] args) {
        int num = 407;

        System.out.println(armstrong(num));
    }

}
