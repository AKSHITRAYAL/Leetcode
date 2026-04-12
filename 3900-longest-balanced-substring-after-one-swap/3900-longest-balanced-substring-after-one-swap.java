import java.util.ArrayList;
import java.util.List;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') { 
                count1++;
            }
        }
        int count0 = n - count1;
        int maxL = 2 * Math.min(count0, count1);
        if (maxL == 0) return 0;

        List<Integer>[] pos = new ArrayList[2 * n + 1];
        int currentP = 0;
        
        for (int i = 0; i <= n; i++) {
            if (i > 0 && s.charAt(i - 1) == '1') {
                currentP++;
            }
            int v = 2 * currentP - i;
            int idx = v + n;
            if (pos[idx] == null) {
                pos[idx] = new ArrayList<>();
            }
            pos[idx].add(i);
        }

        int ans = 0;
        for (int v = -n; v <= n; v++) {
            int idxA = v + n;
            if (pos[idxA] == null) continue;
            List<Integer> A = pos[idxA];

            int[] targets = {v - 2, v, v + 2};
            for (int t : targets) {
                if (t < -n || t > n) continue;
                int idxB = t + n;
                if (pos[idxB] == null) continue;
                List<Integer> B = pos[idxB];
                ans = Math.max(ans, maxDist(A, B, maxL));
            }
        }
        return ans;
    }

    private int maxDist(List<Integer> A, List<Integer> B, int maxL) {
        int max_d = 0;
        int ptrB = 0;
        for (int j : A) {
            while (ptrB < B.size() && B.get(ptrB) < j - maxL) {
                ptrB++;
            }
            if (ptrB < B.size() && B.get(ptrB) <= j) {
                max_d = Math.max(max_d, j - B.get(ptrB));
            }
        }
        return max_d;
    }
}