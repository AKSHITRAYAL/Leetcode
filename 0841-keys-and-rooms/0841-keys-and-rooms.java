import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        visited[0] = true;
        int count = 1;
        while (!stack.isEmpty()) {
            for (int key : rooms.get(stack.pop())) {
                if (!visited[key]) {
                    visited[key] = true;
                    stack.push(key);
                    count++;
                }
            }
        }
        return count == n;
    }
}