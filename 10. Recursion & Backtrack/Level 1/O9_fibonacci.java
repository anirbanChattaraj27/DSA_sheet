public class O9_fibonacci {
    static int fib(int n){
        if(n <= 1){
            return n;
        }
        else
            return fib(n-1) + fib(n-2);
    }
    static int fib2(int n){
        if(n <= 1){
            return n;
        }

        /*this recursion excute first completely */
        int last = fib(n-1);

        /*then this recursion excute completely */
        int Secondlast = fib(n-2);

        return last + Secondlast;
    }
    
    public static void main(String[] args) {
        int n = 4;

        System.out.println(fib(n));
        System.out.println(fib2(n));
        // fib(n);
    }
}
