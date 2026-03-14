/*
  we first create a HashMap to count the frequency of each character in the given string. 
  Then, we iterate through the frequency map to check if there are at most one odd count of 
  characters in the string. If there are more than one odd count of characters, then we return 
  false because a palindrome is not possible. If there is at most one odd count of characters, 
  then we return true because a palindrome is possible.
 */

 /* can be done for Integer and String */

import org.omg.CORBA.ServiceInformation;
import java.util.*;


public class O3_isPalindrome_possible {
    public static boolean isPalindromePossible(String str) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        int oddCount = 0;
        for (int count : map.values()) {
            if (count % 2 == 1) {
                oddCount++;
            }
        }
        return oddCount <2;
    }

    public static void main(String[] args) {
        String str1 = "rearcac"; // o/p -> racecar is palindrome if we rearrange
        String str2 = "13232"; // o/p -> racecar is palindrome if we rearrange
        System.out.println(isPalindromePossible(str1));
        System.out.println(isPalindromePossible(str2));
    }
}
