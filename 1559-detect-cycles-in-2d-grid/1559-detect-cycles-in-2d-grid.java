class Solution {
    int[] parent, rank;

    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m * n; i++) parent[i] = i;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (i + 1 < m && grid[i+1][j] == grid[i][j])
                    if (!union(i*n+j, (i+1)*n+j)) return true;
                if (j + 1 < n && grid[i][j+1] == grid[i][j])
                    if (!union(i*n+j, i*n+j+1)) return true;
            }
        return false;
    }

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false;
        if (rank[ra] < rank[rb]) { int t = ra; ra = rb; rb = t; }
        parent[rb] = ra;
        if (rank[ra] == rank[rb]) rank[ra]++;
        return true;
    }
}