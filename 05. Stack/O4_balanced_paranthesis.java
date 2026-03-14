// Time Complexity: O(n) Auxiliary Space: O(n) for stack

import java.util.*;

class O4_balanced_paranthesis {

    public static boolean checkBalanced(String str) {

        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            else {
                if (stack.isEmpty()) {
                    return false;
                }

                else {
                    char top = stack.peek();

                    if ((c == ')' && top == '(') || (c == '}' && top == '{') || (c == ']' && top == '[')) {
                        stack.pop();
                    }

                    else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(checkBalanced(s));
    }
}
