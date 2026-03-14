import java.io.*;
import java.util.Arrays;
import java.util.Collections;

class O1_2strings_are_anagram_or_not {

	// time --> O(nlogn)
	static boolean areAnagram1(String s1, String s2) {
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();

		int n1 = ch1.length;
		int n2 = ch2.length;

		if (n1 != n2)
			return false;

		Arrays.sort(ch1);
		Arrays.sort(ch2);

		for (int i = 0; i < n1; i++)
			if (ch1[i] != ch2[i]) /* DO NOT WRITE ==, bcz if i use == then in 1st comparison it will be true and it will return the ans so it will not check fot other results  */
				return false;

		return true; /* it means no comparison made false so it must be true */
	}

	public static boolean areAnagram2(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		if (str1.length() == str2.length()) {

			char[] charArray1 = str1.toCharArray();
			char[] charArray2 = str2.toCharArray();

			Arrays.sort(charArray1);
			Arrays.sort(charArray2);

			// if sorted char arrays are same then the string is anagram
			boolean result = Arrays.equals(charArray1, charArray2);

			if (result) {
				return true;
			} 
			else {
				return false;
			}
		} 
		return false;

	}

	// time --> O(n^2)
	public static boolean areAnagram3(char[] ch1, char[] ch2) {

		if (ch1.length != ch2.length)
			return false;

		// here strings are not sorted so i have to run 2loops
		for (int i = 0; i < ch1.length - 1; i++) {
			for (int j = i + 1; j < ch2.length; j++) {
				if (ch1[i] == ch2[j]) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean areAnagram4(String ch1, String ch2) {

		if (ch1.length() != ch2.length())
			return false;

		for (int i = 0; i < ch1.length(); i++) {
			for (int j = 0; j < ch2.length(); j++) {
				if (ch1.charAt(i) != ch2.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	/* Driver Code */
	public static void main(String args[]) {
		// char ch1[] = { 't', 'e', 's', 't' }; // test
		// char ch2[] = { 's', 't', 'e', 't' }; // stet --> test, so anagram

		String ch1 = "geeksforgeeks";
		String ch2 = "forgeeksgeeks";
		// Function Call
		if (areAnagram1(ch1, ch2))
			System.out.println("The two strings are ANAGRAM of each other");
		else
			System.out.println("The two strings are NOT anagram of each other");
	}
}
