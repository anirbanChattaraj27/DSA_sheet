

// Java program to insert a string into another string
// without using any pre-defined method

import java.lang.*;

class O26_insert_newStr_in_given_idx {

	// Function to insert string
	public static String insertString( String originalString, String stringToBeInserted, int index){

		// Create a new string
		String newString = originalString.substring(0, index + 1) + stringToBeInserted + originalString.substring(index + 1);

		// return the modified String
		return newString;
	}

	// Driver code
	public static void main(String[] args) {

		// Get the Strings
		String originalString = "GeeksGeeks";
		String stringToBeInserted = "For";
		int index = 4;

		System.out.println("Original String: " + originalString);
		System.out.println("String to be inserted: " + stringToBeInserted);
		System.out.println("String to be inserted at index: " + index);

		// Insert the String
		System.out.println("Modified String: " + insertString(originalString, stringToBeInserted, index));
	}
}


// Original String: GeeksGeeks
// String to be inserted: For
// String to be inserted at index: 4
// Modified String: GeeksForGeeks