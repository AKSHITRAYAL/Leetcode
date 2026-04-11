class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        
        // Arrays to store the last two seen indices for each number.
        // The constraints state that 1 <= nums[i] <= n, so size n + 1 is safe.
        int[] pos1 = new int[n + 1]; // Second to last seen index
        int[] pos2 = new int[n + 1]; // Last seen index
        
        // Initialize arrays with -1 (meaning not seen yet)
        for (int i = 0; i <= n; i++) {
            pos1[i] = -1;
            pos2[i] = -1;
        }
        
        int minDistance = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            
            // If we have already seen this number at least twice before, 
            // pos1[val] will be the index of the 1st of the 3 occurrences.
            if (pos1[val] != -1) {
                int currentDistance = 2 * (i - pos1[val]);
                if (currentDistance < minDistance) {
                    minDistance = currentDistance;
                }
            }
            
            // Shift the recent indices: the old "last seen" becomes the "second to last seen"
            pos1[val] = pos2[val];
            // The current index becomes the new "last seen"
            pos2[val] = i;
        }
        
        // If minDistance was never updated, no good tuples exist
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}