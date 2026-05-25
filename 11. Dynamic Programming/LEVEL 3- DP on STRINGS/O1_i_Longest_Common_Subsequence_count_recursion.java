public class O1_i_Longest_Common_Subsequence_count_recursion {

    static int f(int i, int j, String s, String t) {
        if (i < 0 || j < 0) return 0;

        if (s.charAt(i) == t.charAt(j))
            return 1 + f(i - 1, j - 1, s, t);

        return Math.max(
                f(i - 1, j, s, t),
                f(i, j - 1, s, t)
        );
    }

    static int lcs(String s, String t) {
        return f(s.length() - 1, t.length() - 1, s, t);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String t = "bdgek";

        System.out.println(lcs(s, t));
    }
}