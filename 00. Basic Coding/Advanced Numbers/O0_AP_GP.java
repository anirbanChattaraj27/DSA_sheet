import java.util.*;

public class O0_AP_GP {
    
    public static double ap(int a, int d, int n){
        // a = 1st term
        // d = common diff
        // n = number of terms

        System.out.println("all numbers upto n");
        for(int i=0; i<n; i++){
            System.out.print(a + (i*d) + " ");
        }

        System.out.println(); // nth term
        return (a+(n-1)*d);
    }

    public static double gp(int a, int r, int n){

        // a = 1st term
        // r = common ratio
        // n = number of terms

        System.out.println("all numbers upto n");
        for(int i=0; i<n; i++){
            System.out.print(a * Math.pow(r, i) + " ");
        }

        System.out.println();
        return a*Math.pow(r, n-1);
    }


    public static void main(String[] args) {
        
        // 1st line contains the initial term of G.P
        // 2nd line contains the common ratio of G.P
        // 3rd line contains the nth term we have to find

        int a = 5;
        int r = 2;
        int n = 10;

        // System.out.println("nth term: " + gp(a,r,n));
        System.out.println("nth term: " + ap(a,r,n));
    }
}
