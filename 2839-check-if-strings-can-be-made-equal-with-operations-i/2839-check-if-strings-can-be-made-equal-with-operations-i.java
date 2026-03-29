class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // Even positions {0,2} and odd positions {1,3} are independent groups.
        // Within each group we can freely swap the two elements any number of times,
        // so we only need the multisets to match — not the order.
        return sameMultiset(s1.charAt(0), s1.charAt(2), s2.charAt(0), s2.charAt(2))
            && sameMultiset(s1.charAt(1), s1.charAt(3), s2.charAt(1), s2.charAt(3));
    }

    // Check if {a,b} == {c,d} as multisets — O(1), no allocations
    private boolean sameMultiset(char a, char b, char c, char d) {
        // Two 2-element multisets are equal iff either order matches
        return (a == c && b == d) || (a == d && b == c);
    }
}