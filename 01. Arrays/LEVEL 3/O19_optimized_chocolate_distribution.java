// https://leetcode.com/problems/distribute-candies-to-people/submissions/
//  by using previous code time limit excesded so use this code


// https://www.youtube.com/watch?v=zZc6nsBf_A4

import java.util.*;

public class O19_optimized_chocolate_distribution {
	public static int[] distributeCandies(int candies, int num_people) {
        int result[] = new int[num_people];
        
        int idx = 0;
        // int candy = 1; // initially 1 candy should be there dor 1st person
        
        while(candies > 0){
            result [idx % num_people] += Math.min(candies, ++idx);
            candies -= idx;
            // candy++;
        }
        return result;
    }

    public static void main(String[] args) 
		{
		// int arr[] = { 1, 3, 4, 7, 9, 9, 12, 56 };
		
		// int m = 5;  // Number of students
		
		System.out.println("Minimum difference is " + distributeCandies(7, 4));
	
	}
}
