class Solution {
    public int minimumDistance(int[] nums) {
        int i = 0;
        int j = 0;
        int k = 0;
        int abs = -1;
        int min = Integer.MAX_VALUE;
        for(i=0; i<nums.length; i++){
            for(j=i+1; j<nums.length; j++){
                for(k=j+1;k<nums.length;k++){
                    if(nums[j]==nums[i]){
                        if(nums[k]==nums[j]){
                            abs = 2*(k-i);
                            min = Math.min(min,abs);
                        }
                    }
                
                }
                
            }
            
        }
        if(abs != -1){
            return min;
        }
        return -1;
    }
}