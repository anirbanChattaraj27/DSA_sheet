/*
 * https://leetcode.com/problems/minimum-window-substring/description/
 * https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 * Striver: https://www.youtube.com/watch?v=WJaij9ffOIY&list=PLgUwDviBIf0q7vrFA_HEWcqRqMpCXzYAL&index=12

Given two strings S (length m) and P (length n), the task is to find the smallest substring in S that 
contains all characters of P, including duplicates. If no such substring exists, return “-1”. If multiple 
substrings of the same length are found, return the one with the smallest starting index.

    Input: S = “timetopractice”, P = “toc”
    Output: toprac
    Explanation: “toprac” is the smallest substring in which “toc” can be found.

    Input: S = “zoomlazapzo”, P = “oza”
    Output: apzo
    Explanation: “apzo” is the smallest substring in which “oza” can be found.

*/


import java.util.*;

public class O12_minimum_window_subString {

    // Brute Force
    public static boolean containsAll(Map<Character, Integer> windowFreqMap, Map<Character, Integer> targetFreqMap) {
        // Loop through target frequency map
        for (char c : targetFreqMap.keySet()) {
            // If any character frequency is less in the window, return false
            if (windowFreqMap.getOrDefault(c, 0) < targetFreqMap.get(c)) return false;
        }
        // Otherwise, the current window contains all required characters
        return true;  
    }

    // Function to find minimum window substring
    public static String minWindow(String s, String t) {
        // Frequency map to store characters of target string
        Map<Character, Integer> targetFreqMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreqMap.put(c, targetFreqMap.getOrDefault(c, 0) + 1);
        }

        // Initialize minimum window length and result string
        int minLen = Integer.MAX_VALUE;
        String result = "";

        // Loop through all possible starting indices
        for (int i = 0; i < s.length(); i++) {
            // Frequency map for the current window
            Map<Character, Integer> windowFreqMap = new HashMap<>();

            // Loop through all possible ending indices starting from i
            for (int j = i; j < s.length(); j++) {
                // Add current character to window frequency
                char ch = s.charAt(j);
                windowFreqMap.put(ch, windowFreqMap.getOrDefault(ch, 0) + 1);

                // Check if current window contains all characters of target
                if (containsAll(windowFreqMap, targetFreqMap)) {
                    // If it's smaller than previously found, update result
                    if ((j - i + 1) < minLen) {
                        minLen = j - i + 1;
                        result = s.substring(i, j + 1);
                    }
                    break; // No need to extend this window further
                }
            }
        }

        return result;
    }

    // optimal
    public String minWindow2(String s, String t) {
        // Frequency map for characters in t
        Map<Character, Integer> targetFreqMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetFreqMap.put(c, targetFreqMap.getOrDefault(c, 0) + 1);
        }

        // Number of unique characters required to match
        int required = targetFreqMap.size();

        // Left and right window pointers
        int left = 0, right = 0;

        // Tracks how many characters in current window match required frequency
        int formed = 0;

        // Frequency map for the current window
        Map<Character, Integer> windowFreqMap = new HashMap<>();

        // Minimum window length and starting index
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        // Expand the window
        while (right < s.length()) {
            char c = s.charAt(right);
            windowFreqMap.put(c, windowFreqMap.getOrDefault(c, 0) + 1);

            // If character matches target frequency
            if (targetFreqMap.containsKey(c) && windowFreqMap.get(c).intValue() == targetFreqMap.get(c).intValue()) {
                formed++;
            }

            // Try shrinking the window if all target characters matched
            while (left <= right && formed == required) {
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                windowFreqMap.put(leftChar, windowFreqMap.get(leftChar) - 1);

                if (targetFreqMap.containsKey(leftChar) && windowFreqMap.get(leftChar) < targetFreqMap.get(leftChar)) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        // Call the method and print result
        System.out.println(" ----> " + minWindow(s, t)); // Output should be "BANC"
    }
}

