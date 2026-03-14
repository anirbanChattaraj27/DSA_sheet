import java.util.*;
public class AsciiVal{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // Read the characters from the sc object.
        String s = "abcxy";

        // Print the ASCII values of the characters.
        for (int i = 0; i < s.length(); i++) {
            System.out.println((int) s.charAt(i));
        }

        /* ⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐ */
        // to get integers number to ASCCI value
        int num = 65;
        System.out.println((char) num); // prints A

    }
}
// how to orint last element from arraylist?