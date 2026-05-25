// Time Complexity: O(n) Auxiliary Space: O(n) for stack

import java.util.*;

class O4_balanced_paranthesis {

    public static boolean isValid(String s) {

        Stack<Character> st = new Stack();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }

            else {
                if (st.isEmpty())
                    return false;

                char top = st.pop();

                if ((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{'))
                    continue;

                else
                    return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
