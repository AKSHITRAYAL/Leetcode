class Solution {
    int[] tree;
    int[] count;

    public int countGoodSubseq(int[] nums, int p, int[][] queries) {
        int n = nums.length;
        tree = new int[4 * 50005];
        count = new int[50005];
        
        int mult_p_count = 0;
        for (int num : nums) {
            if (num % p == 0) {
                if (count[num] == 0) {
                    update(1, 0, 50000, num, num);
                }
                count[num]++;
                mult_p_count++;
            }
        }
        
        int ans = 0;
        for (int[] q : queries) {
            int idx = q[0];
            int val = q[1];
            
            int oldVal = nums[idx];
            if (oldVal % p == 0) {
                count[oldVal]--;
                mult_p_count--;
                if (count[oldVal] == 0) {
                    update(1, 0, 50000, oldVal, 0);
                }
            }
            
            nums[idx] = val;
            if (val % p == 0) {
                if (count[val] == 0) {
                    update(1, 0, 50000, val, val);
                }
                count[val]++;
                mult_p_count++;
            }
            
            int totalGcd = tree[1];
            if (totalGcd == p) {
                if (mult_p_count < n) {
                    ans++;
                } else {
                    boolean possible = false;
                    for (int i = 0; i < Math.min(n, 30); i++) {
                        int v = nums[i];
                        if (count[v] > 1) {
                            possible = true;
                            break;
                        } else {
                            int gLeft = query(1, 0, 50000, 0, v - 1);
                            int gRight = query(1, 0, 50000, v + 1, 50000);
                            if (gcd(gLeft, gRight) == p) {
                                possible = true;
                                break;
                            }
                        }
                    }
                    if (possible) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    
    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = gcd(tree[2 * node], tree[2 * node + 1]);
    }
    
    private int query(int node, int start, int end, int l, int r) {
        if (l > end || r < start) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        int p1 = query(2 * node, start, mid, l, r);
        int p2 = query(2 * node + 1, mid + 1, end, l, r);
        return gcd(p1, p2);
    }
    
    private int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}