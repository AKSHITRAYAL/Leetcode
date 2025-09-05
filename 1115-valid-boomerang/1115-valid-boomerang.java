class Solution {
    public boolean isBoomerang(int[][] points) {
        int x0 = points[0][0], y0 = points[0][1];
        int x1 = points[1][0], y1 = points[1][1];
        int x2 = points[2][0], y2 = points[2][1];

        // Cross product of vectors (p0->p1) and (p0->p2).
        // Non-zero means not collinear => valid boomerang.
        long cross = (long)(x1 - x0) * (y2 - y0) - (long)(y1 - y0) * (x2 - x0);
        return cross != 0;
    }
}