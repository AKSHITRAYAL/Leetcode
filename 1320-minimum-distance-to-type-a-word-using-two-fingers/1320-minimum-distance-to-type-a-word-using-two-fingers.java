class Solution {
    private static int dist(int a, int b) {
        if (a == 26 || b == 26) return 0;
        int ax = a / 6, ay = a % 6;
        int bx = b / 6, by = b % 6;
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }

    public int minimumDistance(String word) {
        int n = word.length();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) w[i] = word.charAt(i) - 'A';

        final int INF = 1_000_000_000;
        int[][] dp = new int[27][27];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[26][26] = 0;

        for (int i = 0; i < n; i++) {
            int c = w[i];
            int[][] ndp = new int[27][27];
            for (int[] row : ndp) Arrays.fill(row, INF);

            for (int f1 = 0; f1 <= 26; f1++) {
                for (int f2 = 0; f2 <= 26; f2++) {
                    int cur = dp[f1][f2];
                    if (cur == INF) continue;

                    int cost1 = cur + dist(f1, c);
                    if (cost1 < ndp[c][f2]) ndp[c][f2] = cost1;

                    int cost2 = cur + dist(f2, c);
                    if (cost2 < ndp[f1][c]) ndp[f1][c] = cost2;
                }
            }
            dp = ndp;
        }

        int ans = INF;
        for (int f1 = 0; f1 <= 26; f1++) {
            for (int f2 = 0; f2 <= 26; f2++) {
                ans = Math.min(ans, dp[f1][f2]);
            }
        }
        return ans;
    }
}