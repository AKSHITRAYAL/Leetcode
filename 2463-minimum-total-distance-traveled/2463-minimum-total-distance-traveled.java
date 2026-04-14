import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int m = robot.size(), n = factory.length;
        long INF = (long) 1e18;

        long[][] dp = new long[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[n][m] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int pos = factory[i][0];
            int limit = factory[i][1];

            for (int j = 0; j <= m; j++) {
                // skip this factory
                dp[i][j] = dp[i + 1][j];

                long cost = 0;
                for (int k = 1; k <= limit && j + k <= m; k++) {
                    cost += Math.abs(robot.get(j + k - 1) - pos);
                    dp[i][j] = Math.min(dp[i][j], cost + dp[i + 1][j + k]);
                }
            }
        }

        return dp[0][0];
    }
}