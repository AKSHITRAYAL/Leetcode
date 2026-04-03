class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        // Initialize for patterns like a*, a*b*, etc.
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            boolean prev = dp[0];
            dp[0] = false;

            for (int j = 1; j <= n; j++) {
                boolean temp = dp[j];

                char pc = p.charAt(j - 1);

                if (pc == '*') {
                    dp[j] = dp[j - 2];

                    char prevChar = p.charAt(j - 2);
                    if (prevChar == '.' || prevChar == s.charAt(i - 1)) {
                        dp[j] |= temp;
                    }

                } else {
                    dp[j] = prev && (pc == '.' || pc == s.charAt(i - 1));
                }

                prev = temp;
            }
        }

        return dp[n];
    }
}