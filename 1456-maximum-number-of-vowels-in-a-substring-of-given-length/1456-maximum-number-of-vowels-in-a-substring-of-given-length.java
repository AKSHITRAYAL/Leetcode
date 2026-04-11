class Solution {
    public int maxVowels(String s, int k) {
        // Fast O(1) lookup table for vowels using ASCII values
        boolean[] isVowel = new boolean[128];
        isVowel['a'] = true;
        isVowel['e'] = true;
        isVowel['i'] = true;
        isVowel['o'] = true;
        isVowel['u'] = true;

        int maxVowels = 0;
        int currentVowels = 0;
        
        // Convert string to char array to avoid repeated .charAt() overhead in the loop
        char[] chars = s.toCharArray();

        // 1. Count vowels in the first window of size k
        for (int i = 0; i < k; i++) {
            if (isVowel[chars[i]]) {
                currentVowels++;
            }
        }
        
        maxVowels = currentVowels;
        
        // Early exit optimization: if we already hit the maximum possible vowels
        if (maxVowels == k) {
            return k;
        }

        // 2. Slide the window across the rest of the string
        for (int i = k; i < chars.length; i++) {
            // Add the new character entering the window
            if (isVowel[chars[i]]) {
                currentVowels++;
            }
            // Remove the character that just fell out of the window
            if (isVowel[chars[i - k]]) {
                currentVowels--;
            }
            
            // Update the max
            if (currentVowels > maxVowels) {
                maxVowels = currentVowels;
                
                // Early exit: impossible to find a better answer than 'k'
                if (maxVowels == k) {
                    return k;
                }
            }
        }

        return maxVowels;
    }
}