/*
 * https://leetcode.com/problems/palindrome-partitioning/description/
 * 
 * Given a string s, partition s such that every substring of the 
 * partition is a palindrome. Return all possible palindrome partitioning of s.

    Example 1:
    Input: s = "aab"
    Output: [["a","a","b"],["aa","b"]]

    Example 2:
    Input: s = "a"
    Output: [["a"]]
 */

 
import java.util.*;

public class O13_Palindrome_Partioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0, s, path, res);
        return res;
    }

    void func(int index, String s, List<String> path, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                func(i + 1, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        O13_Palindrome_Partioning solver = new O13_Palindrome_Partioning();
        String s = "aab";
        List<List<String>> result = solver.partition(s);
        System.out.println("Palindrome Partitions:");
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}
