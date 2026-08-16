// LC 678: https://leetcode.com/problems/valid-parenthesis-string/description/

/*
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:
    Input: s = "()"
    Output: true

Example 2:
    Input: s = "(*)"
    Output: true

Example 3:
    Input: s = "(*))"
    Output: true
 
*/

public class O4_Valid_Parathesis_checker {
    
    // greedy approach || TC: O(n) SC: O(1)
    public boolean checkValidString(String s) {

        // Variable to track minimum possible open brackets at current index
        int minOpen = 0;

        // Variable to track maximum possible open brackets at current index
        int maxOpen = 0;

        // Traverse through each character in the string
        for (int i = 0; i < s.length(); i++) {

            // Get current character
            char c = s.charAt(i);

            // If character is '(', it increases both minOpen and maxOpen
            if (c == '(') {
                minOpen++;
                maxOpen++;
            }

            // If character is ')', it decreases both minOpen and maxOpen
            else if (c == ')') {
                minOpen--;
                maxOpen--;
            }

            // If character is '*', it can be '(', ')' or ''
            else {
                // if '*' is ')'
                minOpen--;
                // if '*' is '('
                maxOpen++;
            }

            // If maxOpen becomes negative, too many closing brackets : invalid string
            if (maxOpen < 0)
                return false;

            // minOpen can't go below 0, as we can't have negative unmatched '('
            if (minOpen < 0)
                minOpen = 0;
        }

        // If minOpen is 0 at the end, it's a valid configuration
        return minOpen == 0;
    }
}

// Main class with driver code
class Main {
    public static void main(String[] args) throws java.io.IOException {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = sc.nextLine();

        O4_Valid_Parathesis_checker sol = new O4_Valid_Parathesis_checker();
        if (sol.checkValidString(input)) {
            System.out.println("Valid parenthesis string");
        } else {
            System.out.println("Invalid parenthesis string");
        }
    }
}
