class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();
        int count = 0;
        
        // Store all rows as strings in HashMap with their frequency
        for (int[] row : grid) {
            String rowKey = Arrays.toString(row);
            rowMap.put(rowKey, rowMap.getOrDefault(rowKey, 0) + 1);
        }
        
        // For each column, check if it exists in HashMap
        for (int col = 0; col < n; col++) {
            int[] column = new int[n];
            for (int row = 0; row < n; row++) {
                column[row] = grid[row][col];
            }
            String colKey = Arrays.toString(column);
            count += rowMap.getOrDefault(colKey, 0);
        }
        
        return count;
    }
}