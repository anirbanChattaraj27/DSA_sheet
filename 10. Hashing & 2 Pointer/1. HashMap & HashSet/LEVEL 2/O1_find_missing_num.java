// leetcode 448: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the 
integers in the range [1, n] that do not appear in nums.

Example 1:  
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]
 
 */
import java.util.*;

public class O1_find_missing_num {
    public static List<Integer> findDisappearedNumbers(int[] arr) {
        HashSet<Integer>hs=new HashSet<>();

        for(int val:arr)
        {
            hs.add(val);
        }

        List<Integer> al = new ArrayList<>();
        int n = arr.length;for(
        int i = 1;i<=n;i++)if(hs.contains(i)==false)al.add(i);

        return al;
    }
    public static void main(String[] args){
        int arr[] = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }
}