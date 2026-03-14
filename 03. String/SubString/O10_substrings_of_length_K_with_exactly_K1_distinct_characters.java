// Count of substrings of length K with exactly K-1 distinct characters
// got this qs from GFG

// https://www.geeksforgeeks.org/count-of-substrings-of-length-k-with-exactly-k-distinct-characters/

/*
Input: s = “abcc”, k = 2 
Output: 1
Explanation: Substrings of length 2 are “ab”, “bc” and “cc”. Only “cc” has 2-1 = 1 distinct character.


Input: s = “aabab”, k = 3 
Output: 3
Explanation: Substrings of length 3 are “aab”, “aba”, “bab”. All 2 substrings contains k-1 distinct characters.
 */
public class O10_substrings_of_length_K_with_exactly_K1_distinct_characters {

    // Naive way
    static int countOfSubstrings1(String s, int k) {

        int n = s.length();
        int count = 0;

        // Check for all subarray of size K
        for (int i = 0; i < n - k + 1; i++) {
            int[] cnt = new int[26];

            for (int j = i; j < i + k; j++) {
                cnt[s.charAt(j) - 'a']++;
            }

            int distinctCnt = 0;

            // Count number of distinct characters
            for (int i1 = 0; i1 < 26; i1++) {
                if (cnt[i1] > 0) {
                    distinctCnt++;
                }
            }

            if (distinctCnt == k - 1) {
                count++;
            }
        }

        return count;
    }

    // 2 pointers
    static int countOfSubstrings2(String s, int k) {

        if (k > s.length()) {
            return 0;
        }

        int n = s.length();
        int[] cnt = new int[26];
        int ans = 0;

        for (int i = 0; i < k - 1; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        for (int i = k - 1; i < n; i++) {

            cnt[s.charAt(i) - 'a']++;

            // Check if the current window contains k-1 distinct chars. 
            int distinctCnt = 0;
            for (int j1 = 0; j1 < 26; j1++) {
                if (cnt[j1] > 0) {
                    distinctCnt++;
                }
            }
            if (distinctCnt == k - 1) {
                ans++;
            }

            cnt[s.charAt(i - k + 1) - 'a']--;
        }

        return ans;
    }

    public static void main(String[] args) {

        String str = "abcc";
        int k = 2;

        System.out.println(countOfSubstrings2(str, k));
    }
}
