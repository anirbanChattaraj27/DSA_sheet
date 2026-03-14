// i/p -> HiHoWAreYouHiHi , Hi
// o/p -> 3

public class O11_count_common_substring {
    /* Checks if a string is empty ("") or null. */
    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    /* Counts how many times the substring appears in the larger string. */
    public static int countMatches(String text, String str) {
        if (isEmpty(text) || isEmpty(str)) {
            return 0;
        }

        return text.split(str, -1).length - 1;
    }

    public static void main(String[] args)
    {
        String text = "HiHoWAreYouHiHi";
        String str = "Hi";
 
        int count = countMatches(text, str);
        System.out.println(count);
    }
}
