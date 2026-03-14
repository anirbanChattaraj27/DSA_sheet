// https://leetcode.com/problems/reverse-words-in-a-string/

// Input: s = "the sky is blue"
// Output: "blue is sky the"

// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing spaces

// Input: s = "a good   example"
// Output: "example good a"

class O16_reverse_words_in_String {

    public static String reverseWords(String st) {

        String str[] = st.split(" ");
        String ans = "";

        for (int i = str.length - 1; i >= 0; i--) {
            
            // if (str[i] != " ") {
                
                ans += str[i] + " ";
            // }
        }

        ans = ans.trim();
        return ans;
    }

    public static void main(String[] args) {
        String str = "* hgh nn /";
        System.out.println(reverseWords(str));
    }
}