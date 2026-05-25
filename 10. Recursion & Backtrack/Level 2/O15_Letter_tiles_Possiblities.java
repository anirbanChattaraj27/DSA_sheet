/*
 * leetcode: 1079: https://leetcode.com/problems/letter-tile-possibilities/description/
 
You have n tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters 
printed on those tiles.

Example 1:
Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

Example 2:
Input: tiles = "AAABBC"
Output: 188

Example 3:
Input: tiles = "V"
Output: 1
 */

/* 
Intuition
    The problem requires us to generate all possible non-empty sequences using the given tiles, considering repeated characters and avoiding duplicate sequences.

To achieve this, we can use backtracking:

* Generate all possible sequences by permuting characters.
* Avoid counting duplicate sequences by tracking previously used characters at each recursive level.

Approach:
The approach uses backtracking with pruning to avoid duplicate calculations.

Step 1: Convert String to Character Array
Convert tiles to a character array arr to easily swap elements and generate permutations.

Step 2: Recursive Backtracking
Use a recursive function permute(start, arr):
Base Case: If start == arr.length, return 0 (no further permutations possible).

Recursive Case:
Iterate through each character from index start to arr.length.
Swap the current character with start to fix it in place.
Call permute(start + 1, arr) to generate permutations for the remaining characters.
Swap back to restore the original order.

Step 3: Avoid Duplicate Permutations
The function isPermutedBefore(start, i-1, arr[i], arr) ensures we don’t use the same character in the same recursive level multiple times.
It checks if arr[i] has already appeared in arr[start:i].

Step 4: Count Unique Sequences
Each valid permutation adds 1 to the count.
The final result is the total number of unique sequences.
 */
 
public class O15_Letter_tiles_Possiblities {
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        return permute(0, arr);
    }
    public int permute(int start, char[] arr) {
        if(start == arr.length) return 0;
        int ans = 0;
        for(int i=start; i<arr.length; i++) {
            if(!isPermutedBefore(start, i-1, arr[i], arr)) {
                swap(start, i, arr);
                ans += 1+permute(start+1, arr);
                swap(start, i, arr);
            }
        }
        return ans;
    }
    public boolean isPermutedBefore(int i, int j, char ch, char[] arr) {
        while(i<=j)
            if(arr[i++] == ch) return true;
        return false;
    }
    public void swap(int i, int j, char[] arr) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}