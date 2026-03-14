// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/

// Example 1:
// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// see that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

// Example 2:
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transactions are done and the max profit = 0.

     
import java.util.*;

public class O14_max_profit_by_selling_once {
	
	public static int maxProfit(int[] arr) {
        int minPrice = arr[0];
        int maxProfit = 0;
        
        for(int i=0; i<arr.length; i++){
			
			/* by using in_built function */        	
			minPrice = Math.min(minPrice, arr[i]);
			maxProfit = Math.max(maxProfit, arr[i] - minPrice);
        	
        	/* this is one way of printing by using if-else */
        //    if(arr[i] < minPrice){
        //        minPrice = arr[i];
        //    }
        //    else if(arr[i] - minPrice > maxProfit){
        //        maxProfit = arr[i] - minPrice;
        //    }
        }
        return maxProfit;
    }

	public static void main(String[] args)
	{
		int arr[] = { 7,1,5,3,6,4 };
		
		System.out.print("Maximum Profit = " + maxProfit(arr));
	}

}
