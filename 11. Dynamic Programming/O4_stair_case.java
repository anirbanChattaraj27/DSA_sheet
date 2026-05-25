// There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.

// https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
// Consider the example shown in the diagram. The value of n is 3. There are 3 ways to reach the top. The diagram is taken from Easier Fibonacci 

/*
    Input: n = 1
    Output: 1
    There is only one way to climb 1 stair

    Input: n = 2
    Output: 2
    There are two ways: (1, 1) and (2)

    Input: n = 4
    Output: 5
    (1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2) 
*/



public class O4_stair_case {

    // from GFG
    // this code is just like fibbonacchi series
    static int countWaysUtil(int n, int m) {
        if (n <= 1)
            return n;

        int res = 0;
        for (int i = 1; i <= m && i <= n; i++)
            res += countWaysUtil(n - i, m);

        return res;
    }

    // from prepinsta
    // this bellow code is iteration approch of fibbonacci so dry run it...
    public static int countwaysUtil2(int n, int m) {
        if (n <= 1) 
            return n;

        int res = 0;
        for (int i = 1; i <= m && i <= n; i++)
            res += countwaysUtil(n - i, m);

        return res;
    }


    // this bellow code is common for both above code
    // Returns number of ways to reach s'th stair
    static int countWays(int s, int m) {
        return countWaysUtil(s + 1, m);
        // return countWaysUtil2(s + 1, m);
    }


    public static void main(String args[]) {
        int s = 4, m = 2;
        System.out.println("Number of ways = " + countWays(s, m));
    }
}


