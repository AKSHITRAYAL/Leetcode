class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] ans = new int[n];
        
        // Iterate through each vertex (each row in the matrix)
        for (int i = 0; i < n; i++) {
            int degree = 0;
            // Count the number of edges connected to vertex i
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    degree++;
                }
            }
            // Store the degree in the result array
            ans[i] = degree;
        }
        
        return ans;
    }
}