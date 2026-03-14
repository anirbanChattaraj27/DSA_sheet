// https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1?page=2&category[]=Hash&sortBy=submissions
// Longest Substring with At Most K Distinct Characters
// Longest Substring with K Distinct Characters

// Input: Str = "aabbcc", k = 1
// Output: 2
// Explanation: Max substring can be any one from {"aa" , "bb" , "cc"}.
// Input: Str = "aabbcc", k = 2
// Output: 4
// Explanation: Max substring can be any one from {"aabb" , "bbcc"}.
// Input: Str = "aabbcc", k = 3
// Output: 6
// Explanation:  There are substrings with exactly 3 unique characters
// {"aabbcc" , "abbcc" , "aabbc" , "abbc" }
// Max is "aabbcc" with length 6.
// Input: Str = "aaabbb", k = 3
// Output: Not enough unique characters
// Explanation: There are only two unique characters, thus show error message.
import java.util.*;

public class O7_Longest_K_unique_characters {

    static void longestKSubstr(String s, int k) {

        int n = s.length();
        int answer = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                HashSet<Character> set = new HashSet<>();
                for (int x = i; x < j; x++) {
                    set.add(s.charAt(x));
                }
                if (set.size() == k) {
                    answer = Math.max(answer, j - i);
                }
            }
        }

        System.out.println(answer);
    }

    // sliding window aaproch GFG
    static boolean isValid(int count[], int k) {
        int val = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                val++;
            }
        }

        return (k >= val);
    }

    static int longestKSubstr2(String s, int k) {
        int u = 0;
        int n = s.length();

        // Associative array to store the count of characters 
        int count[] = new int[26];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            if (count[s.charAt(i) - 'a'] == 0) {
                u++;
            }
            count[s.charAt(i) - 'a']++;
        }

        if (u < k) {
            return -1;
        }

        int curr_start = 0, curr_end = 0;

        int max_window_size = 1;

        // Initialize associative array count[] with zero 
        Arrays.fill(count, 0);

        // put the first character 
        count[s.charAt(0) - 'a']++;

        for (int i = 1; i < n; i++) {
            // Add the character 's[i]'  to current window 
            count[s.charAt(i) - 'a']++;
            curr_end++;

            while (!isValid(count, k)) {
                count[s.charAt(curr_start) - 'a']--;
                curr_start++;
            }

            // Update the max window size if required 
            if (curr_end - curr_start + 1 > max_window_size) {
                max_window_size = curr_end - curr_start + 1;
            }
        }

        return max_window_size;
    }

    // using map
    static int longestkSubstr3(String S, int k) {
        // code here
        Map<Character, Integer> map = new HashMap<>();

        int i = -1;
        int j = -1;
        int ans = -1;

        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            while (i < S.length() - 1) {
                flag1 = true;
                i++;
                char ch = S.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                if (map.size() < k) {
                    continue; 
                }else if (map.size() == k) {
                    int len = i - j;
                    ans = Math.max(len, ans);
                } else {
                    break;
                }
            }
            while (j < i) {
                flag2 = true;
                j++;
                char ch = S.charAt(j);

                if (map.get(ch) == 1) {
                    map.remove(ch); 
                }else {
                    map.put(ch, map.get(ch) - 1);
                }

                if (map.size() == k) {
                    int len = i - j;
                    ans = Math.max(ans, len);
                    break;
                } else if (map.size() > k) {
                    continue;
                }
            }
            if (flag1 == false && flag2 == false) {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        String s = "bccbababd";
        int k = 2;

        // Function Call
        longestKSubstr(s, k);
    }
}
