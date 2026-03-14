/* At a lemonade stand, each lemonade costs $5. Customers are standing in a 
   queue to buy from you and order one at a time (in the order specified by bills). 4
   Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. 
   You must provide the correct change to each customer so that the net transaction is 
   that the customer pays $5.
   
   Note that you do not have any change in hand at first.
   Given an integer array bills where bills[i] is the bill the ith customer pays, 
   return true if you can provide every customer with the correct change, or false otherwise.

    Input: bills = [5,5,5,10,20]
    Output: true
    Explanation: 
    From the first 3 customers, we collect three $5 bills in order.
    From the fourth customer, we collect a $10 bill and give back a $5.
    From the fifth customer, we give a $10 bill and a $5 bill.
    Since all customers got correct change, we output true.
 */
/* 
https://leetcode.com/problems/lemonade-change/description/ -> problem
https://algo.monster/liteproblems/860 -> solution
 */

public class O2_Lemonade {
    /**
     * Determines if we can provide correct change for all customers in a lemonade stand.
     * Each lemonade costs $5. Customers can pay with $5, $10, or $20 bills.
     * We start with no change and must give correct change to each customer in order.
     * 
     * @param bills Array of bills representing the payment from each customer in order
     * @return true if we can provide change to all customers, false otherwise
     */
    public boolean lemonadeChange(int[] bills) {
        // Track the count of $5 and $10 bills we have as change
        int fiveDollarBills = 0;
        int tenDollarBills = 0;
      
        // Process each customer's payment
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    // Customer pays exact amount, no change needed
                    fiveDollarBills++;
                    break;
                  
                case 10:
                    // Customer pays $10, need to give $5 change
                    tenDollarBills++;
                    fiveDollarBills--;
                    break;
                  
                case 20:
                    // Customer pays $20, need to give $15 change
                    // Prefer giving one $10 and one $5 if possible
                    if (tenDollarBills > 0) {
                        tenDollarBills--;
                        fiveDollarBills--;
                    } else {
                        // Otherwise, give three $5 bills
                        fiveDollarBills -= 3;
                    }
                    break;
            }
          
            // Check if we have enough change after serving this customer
            if (fiveDollarBills < 0) {
                return false;
            }
        }
      
        return true;
    }
}