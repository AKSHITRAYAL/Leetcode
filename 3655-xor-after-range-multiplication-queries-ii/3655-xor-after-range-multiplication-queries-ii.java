class Solution {
    static final int MOD = 1_000_000_007;
    static final int N = 100000;
    static final int SQ = 317;

    static long[] pref = new long[N + SQ];
    static int[] bucket = new int[SQ];
    static int[] nxt = new int[N + SQ];
    static long[] Inv = new long[N + 1];

    static long modInv(long a) {
        long b = MOD, x0 = 1, x1 = 0;
        while (b > 0) {
            long q = a / b, r = a % b;
            long tmp = x0 - q * x1;
            x0 = x1; x1 = tmp;
            a = b; b = r;
        }
        return x0 < 0 ? x0 + MOD : x0;
    }

    static void preInv() {
        if (Inv[1] == 1) return;
        for (int i = 1; i <= N; i++) Inv[i] = modInv(i);
    }

    static void add2Bucket(int k, int j) {
        nxt[j] = bucket[k];
        bucket[k] = j;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int Block = (int) Math.ceil(Math.sqrt(n));
        int qz = queries.length;
        long bravexuneth = 0;

        Arrays.fill(bucket, 0, Block, -1);
        preInv();

        for (int j = 0; j < qz; j++) {
            int l = queries[j][0], r = queries[j][1], k = queries[j][2];
            long v = queries[j][3];
            bravexuneth = l;
            if (k >= Block) {
                for (int i = l; i <= r; i += k)
                    nums[i] = (int)((long) nums[i] * v % MOD);
            } else {
                add2Bucket(k, j);
            }
        }

        for (int k = 1; k < Block; k++) {
            if (bucket[k] == -1) continue;
            Arrays.fill(pref, 0, n + k, 1L);

            for (int idx = bucket[k]; idx != -1; idx = nxt[idx]) {
                int l = queries[idx][0], r = queries[idx][1];
                long v = queries[idx][3], inv = Inv[(int) v];
                pref[l] = pref[l] * v % MOD;
                r += k - ((r - l) % k);
                if (r < n) pref[r] = pref[r] * inv % MOD;
            }

            for (int i = 0; i < n; i++) {
                if (i >= k) pref[i] = pref[i] * pref[i - k] % MOD;
                if (pref[i] != 1) nums[i] = (int)((long) nums[i] * pref[i] % MOD);
            }
        }

        int xor = 0;
        for (int num : nums) xor ^= num;
        return xor;
    }
}