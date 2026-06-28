/*
https://takeuforward.org/data-structure/generate-parenthesis
LC: 22-> https://takeuforward.org/data-structure/generate-parenthesis
*/
import java.util.*;

class OptimalSolution {
    public void backtrack(String curr, int open, int close, int n, List<String> res) {
        if (curr.length() == 2 * n) {
            res.add(curr);
            return;
        }
        if (open < n) backtrack(curr + "(", open + 1, close, n, res);
        if (close < open) backtrack(curr + ")", open, close + 1, n, res);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack("", 0, 0, n, res);
        return res;
    }
}

public class O0_generate_paranthesis {
    public static void main(String[] args) {
        OptimalSolution sol = new OptimalSolution();
        List<String> result = sol.generateParenthesis(3);
        for (String s : result) {
            System.out.println(s);
        }
    }
}