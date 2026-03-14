// Java program to count number of times we
// need to add digits to get a single digit.

public class O14_until_number_becomes_1 {
    
    static int NumberofTimes(String str) { 
        // Here the count variable store how many times we do sum of digits and temporary_sum always store the temporary sum we get at each iteration .
        int temporary_sum = 0, count = 0;

        // In this loop we always compute the sum of digits in temporary_ sum variable and convert it into string str till its length become 1 and increase the count in each iteration.
        while (str.length() > 1) {
            temporary_sum = 0;

            // computing sum of its digits
            for (int i = 0; i < str.length(); i++)
                temporary_sum += (str.charAt(i) - '0');

            str = temporary_sum + "";

            count++;
        }

        return count;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        String s = "9917";
        System.out.println(NumberofTimes(s));
    }

}
