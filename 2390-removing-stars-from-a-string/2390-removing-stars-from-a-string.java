class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '*') {
                // Remove the closest non-star character to the left
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Add non-star character to stack
                stack.push(c);
            }
        }
        
        // Build result string from stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}