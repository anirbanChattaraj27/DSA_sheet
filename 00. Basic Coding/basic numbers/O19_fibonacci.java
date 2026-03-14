// NOTE: if i want to return an array[] but parameter does not contain array

public class O19_fibonacci {
    
    static int[] fib(int n) {

        int f[] = new int[n];

        f[0] = 0;
        f[1] = 1;

        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static void main(String[] args) {

        int n = 10;

        int arr[] = fib(n);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        // nTh term
        int nth = 6;
        System.out.println(nth + "th term is: " + arr[nth-1]);
    }


    // // using loop 
    // // algorithm:
                    // Fibonacci Series : 0 1 1 2 3
                    // Explanation:
                    // For 3rd term it's 2nd term + 1st term.
                    // For 4th term it's 3rd term + 2nd term.
                    // for 5th term it's 4th term + 3rd term.


    // public static void main(String[] args) {

    //     int num = 15;
    //     int a = 0, b = 1;

    //     // Here we are printing 0th and 1st terms
    //     System.out.print(a + " , " + b + " , ");

    //     int nextTerm;

    //     // printing the rest of the terms here
    //     for (int i = 2; i < num; i++) {
    //         nextTerm = a + b;
    //         a = b;
    //         b = nextTerm;
    //         System.out.print(nextTerm + " , ");
    //     }

    // }
}
