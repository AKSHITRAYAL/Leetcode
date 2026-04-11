class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        
        // Slide the window to the right
        while (right < nums.length) {
            // If we encounter a 0, we consume one of our allowed flips (k)
            if (nums[right] == 0) {
                k--;
            }
            
            // If k becomes negative, our window has too many 0s.
            // We must slide the left side of the window forward to maintain the max size.
            if (k < 0) {
                // If the element leaving the window is a 0, we get our flip back
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
            
            right++;
        }
        
        // The size of the maximum window found is right - left
        // Note: right is incremented one past the array bounds at the end of the loop
        return right - left;
    }
}