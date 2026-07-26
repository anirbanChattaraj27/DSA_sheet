
/*

LC 340 https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/

APPROCH:
I/P: S = "aaabbccd" K = 2
O/P: 5

explanation: I have to chk total K characters, like here it is 2 so look for 2 unique 
charaters longest length

we will take a map, and start putting elements into it, now when K will become greater 
than K's value, it will erase the map and chkk for another substring from next index

key,val   
|    |
|c->1| --> the moment c becomes 1 (K becomes 3 but I want K=2) so when K becomes 3 like 3 distinct character it will erase the map and create another mao from next a
|b->2|
|a->3|
--------->aaabbc

key,val
|    |
|c->1| --> the moment c becomes 1 (K becomes 3 but I want K=2) so when K becomes 3 like 3 distinct character it will erase the map and create another mao from next a
|b->2|
|a->2|
--------->aabbcc

key,val
|d->1|
|c->2|
|b->2|
|a->1|
---------> abbccd

SO, I have to print a substring where i will have at most K unique character, and 
if substring have more than k distinct character it will erase the map and look for 
another substring from next index
 */
import java.util.HashMap;

public class O5_Longest_SubString_AtMost_K_distinct_Characters {

    /**
     * ****************OPTIMIZED*********************
     */
    // AT MOST K distinct characters (Optimal)
    // fruit into basket is a similar problem. it is string based that is Integer based
    public static int longestSubstringAtMostK(String s, int k) {

        if (k == 0) {
            return 0;
        } 

        int left = 0;
        int maxLength = 0;
        int distinctCount = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            // 1. Add right character
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
 
            if (map.get(ch) == 1) {
                distinctCount++;
            }

            // 2. Shrink until window becomes valid
            while (distinctCount > k) {

                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    distinctCount--;
                }

                left++;
            }

            // 3. Update maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    // EXACTLY K
    public static int longestSubstringExactlyK(String s, int k) {

        if (k == 0) {
            return 0;
        }

        int left = 0;
        int maxLength = -1;   // return -1 if no such substring exists
        int distinctCount = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            // 1. Add right character
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) == 1) {
                distinctCount++;
            }

            // 2. Shrink until valid
            while (distinctCount > k) {

                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    distinctCount--;
                }

                left++;
            }

            // 3. Update answer ONLY when exactly K distinct
            // only change from AT MOST K to EXACTLY K is this condition
            if (distinctCount == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

        String s1 = "aabacbebebe";
        int k1 = 3;
        System.out.println("Output 1: " + longestSubstringExactlyK(s1, k1));
        // Expected: 7

        String s2 = "aaaa";
        int k2 = 2;
        System.out.println("Output 2: " + longestSubstringExactlyK(s2, k2));
        // Expected: -1

        String s3 = "aaabbcccd";
        int k3 = 2;
        System.out.println("Output 3: " + longestSubstringAtMostK(s3, k3));
        // Expected: 5
    }
}



/*
***************************** IF U CAN NOT DIFFERNTIATE BETWEEN THESE 2qs ************************

🔥 1. AT MOST K DISTINCT CHARACTERS
-------------------------------------

Substring can have:
1, 2, 3, … up to K distinct characters

👉 Condition:
map.size() <= k
📌 Example
s = "aabacbebebe", k = 3


Valid substrings:
    "aab" (2 distinct ✅)
    "aaba" (2 distinct ✅)
    "cbebebe" (3 distinct ✅)

❌ Invalid:
    Any substring with 4 distinct characters

🎯 Goal
        Find longest substring where distinct ≤ k

🧠 Key Behavior
    If distinct becomes > k
    👉 Shrink window
    🔥 2. EXACTLY K DISTINCT CHARACTERS
    ✅ Meaning





Substring must have:
ONLY K distinct characters (not less, not more):
------------------------------------------------

👉 Condition:
    map.size() == k
    📌 Example
    s = "aabacbebebe", k = 3

Valid: "cbebebe" → exactly 3 ✅

Invalid:
    "aaba" → only 2 ❌
    "aabac" → maybe 3 but shorter ❌

🎯 Goal
        Find longest substring where distinct = k

🧠 Key Behavior
    If distinct becomes > k
        👉 shrink
    If distinct is < k
        👉 don’t update answer yet

| Feature                 | AT MOST K | EXACTLY K |
| ----------------------- | --------- | --------- |
| Condition               | `<= k`    | `== k`    |
| Accepts fewer distinct? | ✅ Yes     | ❌ No      |
| Update answer when      | size ≤ k  | size == k |
| Flexibility             | More      | Strict    |


 */
