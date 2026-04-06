import java.util.*;

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        Set<Long> obstacleSet = new HashSet<>();

        // Encode (x, y) into a single long
        for (int[] o : obstacles) {
            long key = (((long)o[0]) << 32) | (o[1] & 0xffffffffL);
            obstacleSet.add(key);
        }

        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int dirIdx = 0;

        int x = 0, y = 0;
        int maxDistSqr = 0;

        for (int command : commands) {

            if (command == -1) {
                dirIdx = (dirIdx + 1) % 4;
            } else if (command == -2) {
                dirIdx = (dirIdx + 3) % 4;
            } else {

                int dx = directions[dirIdx][0];
                int dy = directions[dirIdx][1];

                for (int step = 0; step < command; step++) {

                    int nextX = x + dx;
                    int nextY = y + dy;

                    long key = (((long)nextX) << 32) | (nextY & 0xffffffffL);

                    if (obstacleSet.contains(key)) {
                        break;
                    }

                    x = nextX;
                    y = nextY;

                    maxDistSqr = Math.max(maxDistSqr, x*x + y*y);
                }
            }
        }

        return maxDistSqr;
    }
}