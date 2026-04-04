class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Check pattern validity
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        // Compute GCD of lengths
        int len = gcd(str1.length(), str2.length());

        return str1.substring(0, len);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}