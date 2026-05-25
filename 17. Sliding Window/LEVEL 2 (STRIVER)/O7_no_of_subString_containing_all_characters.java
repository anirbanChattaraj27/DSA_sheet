/*
str = bbacba
o/p: 9
explain: bbac, bbacb, bbacba | bac, bacb, bacba | acb, acba | cba  
*/


import java.util.*;

// Brute Force
public class O7_no_of_subString_containing_all_characters {
    // Function to count substrings containing at least one 'a', one 'b', and one 'c'
    public int countSubstringsBruteForce(String s) {
        // Variable to store final count
        int count = 0;
        // Length of the input string
        int n = s.length();

        // Outer loop to fix the start of the substring
        for (int i = 0; i < n; i++) {
            // Array to track the count of 'a', 'b', and 'c'
            int[] freq = new int[3];

            // Inner loop to fix the end of the substring
            for (int j = i; j < n; j++) {
                // Update frequency for current character
                freq[s.charAt(j) - 'a']++;

                // Check if all three characters are present
                if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                    // Add valid substring
                    count++;
                }
            }
        }

        return count;
    }


    // Optimal
    public static int countSubstringsOptimal(String s) {
        int n = s.length();
        int count = 0;

        int left = 0;
        int[] freq = new int[3]; // a=0, b=1, c=2

        for (int right = 0; right < n; right++) {

            char ch = s.charAt(right);
            freq[ch - 'a']++;

            // shrink until invalid
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {

                // ALL substrings from this window are valid
                count += (n - right);

                // shrink from left
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                left++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println("     " + countSubstringsOptimal(s));
    }
}

/*
⚠️ Important Condition
        This works ONLY when:
            Characters are continuous (like a–z)

| Character | ASCII | Calculation | Index |
| --------- | ----- | ----------- | ----- |
| 'a'       | 97    | 97 - 97     | 0     |
| 'b'       | 98    | 98 - 97     | 1     |
| 'c'       | 99    | 99 - 97     | 2     |


char ch = 'b';
freq[ch - 'a']++;

Step:
'b' - 'a' = 98 - 97 = 1

So:
freq[1]++   // increment count of 'b'


freq = [0, 0, 0]   // a, b, c

ch = 'a' → freq[0]++
freq = [1, 0, 0]

ch = 'c' → freq[2]++
freq = [1, 0, 1]

*/

