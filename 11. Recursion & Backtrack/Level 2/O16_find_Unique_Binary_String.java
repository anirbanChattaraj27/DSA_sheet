/* Leetcode(1980): https://leetcode.com/problems/find-unique-binary-string/description/
Example 1:
    Input: nums = ["01","10"]
    Output: "11"
    Explanation: "11" does not appear in nums. "00" would also be correct.

Example 2:
    Input: nums = ["00","01"]
    Output: "11"
    Explanation: "11" does not appear in nums. "10" would also be correct.

Example 3:
    Input: nums = ["111","011","001"]
    Output: "101"
    Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
*/

/*
APPROCH: 
    * What we can do is we create a binary string which differs from first binary at 
    1st position, second binary at 2nd position, third binary at 3rd position,...and so on.

    * This will make sure that the binary we have made is unique (as it differs from all 
    others at atleast one position).
*/


public class O16_find_Unique_Binary_String {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans= new StringBuilder();                  
        for(int i=0; i<nums.length; i++)  
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');  // Using ternary operator
        return ans.toString();
    }
}
