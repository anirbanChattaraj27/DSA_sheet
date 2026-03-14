// Given two strings a and b. Check whether they contain any common subsequence (non empty) or not.

// Example 1:
// Input: a = "ABEF" b = "CADE"
// Output: 2
// Explanation: Subsequence "AE" occurs
// in both the strings.

// Example 2:
// Input: a = "ABCD", b = "EFGH"
// Output: 0
// Explanation: There's no common subsequence
// in both the strings.

import java.util.*;

public class O34_count_common_subsequence {

    // if i want to print true or false i can do it by using returen true in place of count++
    static int commonSubseq(String a, String b) {
        int count = 0;
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        for(int i=0; i<a.length(); i++){
            set1.add(a.charAt(i));
        }
        
        for(int i=0; i<b.length(); i++){
            set2.add(b.charAt(i));
        }
        
        for(char ch : set2){
            if(set1.contains(ch)){
                count++;
            }
        }
        return count;
    }

    static int commonSubseq2(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            String s = a.charAt(i) + "";
            if (b.contains(s)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "afgz";
        String s2 = "czdae";

        System.out.println(commonSubseq("afgz", "czdae"));
    }
}
