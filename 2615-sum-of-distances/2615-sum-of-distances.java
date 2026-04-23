class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];

        Map<Integer, Long> count = new HashMap<>();
        Map<Integer, Long> sum = new HashMap<>();

        for (int i = 0; i < n; i++) {
            long c = count.getOrDefault(nums[i], 0L);
            long s = sum.getOrDefault(nums[i], 0L);

            res[i] = c * i - s;

            count.put(nums[i], c + 1);
            sum.put(nums[i], s + i);
        }

        count.clear();
        sum.clear();

        for (int i = n - 1; i >= 0; i--) {
            long c = count.getOrDefault(nums[i], 0L);
            long s = sum.getOrDefault(nums[i], 0L);

            res[i] += s - c * i;

            count.put(nums[i], c + 1);
            sum.put(nums[i], s + i);
        }

        return res;
    }
}