
// PROBLEM LINK--> https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/submissions/

// SOLUTION LINK --> https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-stock-at-most-twice-set-2/


// max profit buy sell stock atmost twice

/*
	Input: prices[] = {3, 3, 5, 0, 0, 3, 1, 4} 
	Output: 6 
	Explanation: 
	Buy on Day 4 and Sell at Day 6 => Profit = 3 – 0 = 3 
	Buy on Day 7 and Sell at Day 8 => Profit = 4 -1 = 3 
	Therefore, Total Profit = 3 + 3 = 6
*/

import java.util.*;

public class O15_max_profit_buySell_stock_atMost_twice {

	// Function to find the maximum
	// profit with two transactions
	// on a given list of stock prices
	public static int maxProfit(int arr[], int n) // if in qs says only 1 parameter in function then no need to do anything just paste the code over there no changes are needed
	{
		// minPrice1 - Money lent to buy 1 stock
		// maxProfit1 - Profit after selling
		// the 1st stock buyed.
		// minPrice2 - Money lent to buy 2 stocks
		// including profit of selling 1st stock
		// maxProfit2 - Profit after selling 2 stocks
		int minPrice1, maxProfit1, minPrice2, maxProfit2;

		// Set initial buying values to Integer.MAX_VALUE as we want to minimize it
		minPrice1 = minPrice2 = arr[0];

		// Set initial selling values to zero as we want to maximize it
		maxProfit1 = maxProfit2 = 0;

		for(int i = 0; i < arr.length; i++)
		{
			// Money lent to buy the stock should be minimum as possible. minPrice1 tracks the minimum possible stock to buy from 0 to i-1.
			minPrice1 = Math.min(minPrice1, arr[i]);

			// Profit after selling a stock should be maximum as possible. maxProfit1 tracks maximum possible profit we can make from 0 to i-1.
			maxProfit1 = Math.max(maxProfit1, arr[i] - minPrice1);

			// Now for buying the 2nd stock, we will integrate profit made from selling the 1st stock
			minPrice2 = Math.min(minPrice2, arr[i] - maxProfit1);

			// Profit after selling a 2 stocks should be maximum as possible. maxProfit2 tracks maximum possible profit we can make from 0 to i-1.
			maxProfit2 = Math.max(maxProfit2, arr[i] - minPrice2);
		}
		return maxProfit2;
	}

		// Driver Code
		public static void main(String[] args)
		{
			int arr[] = { 3,3,5,0,0,3,1,4 };
			int n = arr.length;
			
			System.out.print("Maximum Profit = " + maxProfit(arr, n));
		}
	}

