/*
 * To check if the 0th index alphabet is present in alternative positions in a string in Java, you can use the following approach:

  *  Iterate through the string and check the character at each even index.
  *  Compare the character at each even index with the character at the 0th index.
  *  If all the characters at the even indexes are the same as the character at the 0th index, return 1. Otherwise, return 0.

  chatGPT -> source
  
 */
public class O36_0th_idx_Alphabet_in_alternative_indexes {

  public static boolean checkAlternating(String s1) {

    for (int i = 0; i < s1.length(); i += 2) {
      if (s1.charAt(0) != s1.charAt(i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    // Test the function
    System.out.println(checkAlternating("abcdefg")); // should return false
    System.out.println(checkAlternating("aabbccddeeffgg")); // should return false
    System.out.println(checkAlternating("abacafadaea")); // should return true
    System.out.println(checkAlternating("abcdabcdabcdabcd")); // should return false
  }
}
