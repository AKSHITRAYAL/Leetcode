class Solution {
    public double[] internalAngles(int[] sides) {
        Arrays.sort(sides);
        
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];

        if(a+b <= c || b+c <= a || c+b <= a) {
            return new double[0];
        }

        double[] ans = new double[3];

        ans[0] = Math.toDegrees(Math.acos((b * b + c * c - a * a) / (2.0 * b * c)));
        ans[1] = Math.toDegrees(Math.acos((a * a + c * c - b * b) / (2.0 * a * c)));
        ans[2] = Math.toDegrees(Math.acos((a * a + b * b - c * c) / (2.0 * a * b)));

        
        return ans;
    }
}