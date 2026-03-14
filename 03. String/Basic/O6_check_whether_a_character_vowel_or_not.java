// NOTE: lowerCase to upperCase
// char: c = Character.toUpperCase(c); // function is -> static void (char c)
// string: str = str.toUppercase


import java.util.Scanner;

public class O6_check_whether_a_character_vowel_or_not {

        // single function for both uppercase and lowercase
        static boolean isVowel(char c) {
            // converts to uppercase if it wasn't already
            c = Character.toUpperCase(c);
        
            // returns true if char matches any of below
            return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
        }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char c = 'k';

        // show error message if c is not an alphabet
        // if (!isalpha (c))
        //     System.out.println  ("Non alphabet");

        if (isVowel(c))
            System.out.println (c + " is a vowel ");

        else
            System.out.println (c + " is a consonant ");
    }
}
