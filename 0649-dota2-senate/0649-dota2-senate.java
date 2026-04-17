class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        
        int n = senate.length();
        
        // Store indices of each party's senators
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.add(i);
            } else {
                dire.add(i);
            }
        }
        
        // Simulate the voting process
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();
            
            // The senator with lower index acts first and bans the other
            if (r < d) {
                // Radiant senator bans Dire, Radiant goes to next round
                radiant.add(r + n);
            } else {
                // Dire senator bans Radiant, Dire goes to next round
                dire.add(d + n);
            }
        }
        
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}