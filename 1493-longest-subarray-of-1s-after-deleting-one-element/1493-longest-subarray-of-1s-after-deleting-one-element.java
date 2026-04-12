class Solution {
    public int longestSubarray(int[] nums) {
        int curr = 0;
        int prev = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                curr++;
            } else {
                ans = Math.max(ans,prev+curr);
                prev = curr;
                curr = 0;
            }
        }
        ans = Math.max(ans,prev+curr);
        return ans == nums.length ? ans - 1 : ans;
    }
}