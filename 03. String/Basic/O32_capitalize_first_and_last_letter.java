public class O32_capitalize_first_and_last_letter{

    public static String capitalizeFirstAndLast(String str) {
        // Check if the string is empty or has only one character
        if (str == null || str.length() < 2) {
            return str;
        }

        // Capitalize the first and last characters of the string
        String first = str.substring(0, 1).toUpperCase();
        String last = str.substring(str.length() - 1).toUpperCase();

        // Return the modified string
        return first + str.substring(1, str.length() - 1) + last;
    }

    // Test the function
    public static void main(String[] args) {
        System.out.println(capitalizeFirstAndLast("hello"));  // prints "HellO"
        System.out.println(capitalizeFirstAndLast("h"));  // prints "H"
        System.out.println(capitalizeFirstAndLast(""));  // prints ""
        System.out.println(capitalizeFirstAndLast("hello hi tata"));  // prints "Hello hI"
    }
}

