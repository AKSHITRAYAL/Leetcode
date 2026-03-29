class Solution {
    public boolean canBeEqual(String s1, String s2) {
        return sameMultiset(s1.charAt(0), s1.charAt(2), s2.charAt(0), s2.charAt(2))
            && sameMultiset(s1.charAt(1), s1.charAt(3), s2.charAt(1), s2.charAt(3));
    }

    private boolean sameMultiset(char a, char b, char c, char d) {
        return (a == c && b == d) || (a == d && b == c);
    }
}