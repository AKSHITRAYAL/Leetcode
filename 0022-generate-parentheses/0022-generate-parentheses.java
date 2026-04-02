import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] curr = new char[2 * n]; // avoid StringBuilder overhead
        backtrack(res, curr, 0, 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, char[] curr, int pos, int open, int close, int n) {
        if (pos == curr.length) {
            res.add(new String(curr));
            return;
        }

        if (open < n) {
            curr[pos] = '(';
            backtrack(res, curr, pos + 1, open + 1, close, n);
        }

        if (close < open) {
            curr[pos] = ')';
            backtrack(res, curr, pos + 1, open, close + 1, n);
        }
    }
}