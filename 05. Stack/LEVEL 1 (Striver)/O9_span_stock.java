// time O(n)

import java.util.*;



public class O9_span_stock{

    public static void stockSpan(int[] arr, int size) {
    
        // The stack stores indexes, not stock prices.
        Stack<Integer> s = new Stack<>() ;
        s.add(0); 
    
        System.out.print(1 + " "); // print 1 bcz for 0th index it should be one bcz prev. element of 0th index is nothing so span will be one
        for (int i = 1 ; i < size; i++) {
            while (s.isEmpty() == false && arr[s.peek()] <= arr[i]) // if stack will be empty then move out from the loop bt if element is there then push 0th index as per the prev. code
            {
                s.pop();
            }
            int span = s.isEmpty() ? i + 1 : i - s.peek(); // dry run with [1 2 3] and [3 2 1]

            System.out.print(span + " ");
            s.push(i);
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int[] arr = {100, 20, 30, 60, 38, 36, 32, 55, 80, 50, 120};
        int size = arr.length;
        stockSpan(arr, size);
    
    }
}