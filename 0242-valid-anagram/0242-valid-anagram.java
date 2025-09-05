class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        // Convert to char arrays and sort
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        java.util.Arrays.sort(sChars);
        java.util.Arrays.sort(tChars);
        
        // Compare sorted arrays
        return java.util.Arrays.equals(sChars, tChars);
    }
}