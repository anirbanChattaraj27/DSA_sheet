/* NOTE: */
// how to print ascii and use arraylist to print 2nd last element using collection.sort and reverseOrder

import java.util.ArrayList;
import java.util.*;

public class print_2nd_highest_char {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        // Read the characters from the sc object.
        String s = sc.nextLine();

        // Add the characters to the list.
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        // Sort the list in descending order.
        Collections.sort(list, Collections.reverseOrder());

        // Print the second highest character.
        System.out.println(list.get(1));
        System.out.println(list.get(1));
    }
}


// i/p-> abcxyzwsdf
// o/p-> y 2nd highest character bcz z is highest and a is lowest

// i/p-> abc
// o/p-> b // here c is lowest so b is 2nd highest

// i/p-> xyz
// o/p-> y




