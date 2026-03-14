public class O21_factorial {

    // using LOOP
    static int factorialLoop(int n)
    {
        int res = 1, i;
        for (i = 1; i <= n; i++)
            res *= i;
        return res;
    }

    static int factorialLoop2(int n)
    {
        int res = 1, i = 1;
        while(n --> 0){
            res *= i;
			i++;
		}
        return res;
    }


    // using RECURSION
    static int factorialRecursion(int n)
	{
		if (n == 0) 
			return 1;
		return n * factorialRecursion(n - 1);
	}
	
	// Driver method
	public static void main(String[] args)
	{
		int num = 6;
		System.out.println("Factorial of " + num + " is " + factorialLoop2(num));
	}
}
