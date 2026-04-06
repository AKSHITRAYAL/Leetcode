class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle: obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        
        // North - 0, East - 1, South - 2, West - 3
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int dirIdx = 0;
        int x = 0, y = 0;
        int maxDistSqr = 0;

        for (int command: commands) {

            if (command == -1) {
                dirIdx = (dirIdx + 1) % 4;
            } else if (command == -2) {
                dirIdx = (dirIdx + 3) % 4;
            } else {
                int dx = directions[dirIdx][0];
                int dy = directions[dirIdx][1];

                int step = 0;
                while (step < command) {
                    int nextX = x + dx;
                    int nextY = y + dy;

                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break;
                    }
                    x = nextX;
                    y = nextY;

                    maxDistSqr = Math.max(maxDistSqr, x*x + y*y);
                    step++;
                }
            }
        }
        return maxDistSqr;
    }
}