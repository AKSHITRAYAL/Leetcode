class Solution {
    public int maxDistance(int[] colors) {
        int max = Integer.MIN_VALUE;
        int n = colors.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int dist = 0;
                if(colors[i]!=colors[j]){
                    dist = j-i;
                }
                max = Math.max(max,dist);
            } 
        }
        return max;
    }
}