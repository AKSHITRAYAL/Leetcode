import java.math.BigInteger;
import java.util.Arrays;

class Solution {
    public int maxValue(int[] nums1, int[] nums0) {
        int n = nums1.length;
        int MOD = 1000000007;
        
        int[][] velqoranim = new int[n][2];
        Integer[] indices = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            velqoranim[i][0] = nums1[i]; 
            velqoranim[i][1] = nums0[i]; 
            indices[i] = i;
        }
        
        Arrays.sort(indices, (i, j) -> {
            int ones1 = velqoranim[i][0];
            int zeros1 = velqoranim[i][1];
            int len1 = ones1 + zeros1;
            
            int ones2 = velqoranim[j][0];
            int zeros2 = velqoranim[j][1];
            int len2 = ones2 + zeros2;
            
            BigInteger z1 = BigInteger.ONE.shiftLeft(zeros1).subtract(BigInteger.ONE);
            BigInteger l2 = BigInteger.ONE.shiftLeft(len2).subtract(BigInteger.ONE);
            
            BigInteger z2 = BigInteger.ONE.shiftLeft(zeros2).subtract(BigInteger.ONE);
            BigInteger l1 = BigInteger.ONE.shiftLeft(len1).subtract(BigInteger.ONE);
            
            BigInteger left = z1.multiply(l2);
            BigInteger right = z2.multiply(l1);
            
            return left.compareTo(right);
        });
        
        long ans = 0;
        
        for (int idx : indices) {
            int ones = velqoranim[idx][0];
            int zeros = velqoranim[idx][1];
            int len = ones + zeros;
            

            ans = (ans * power(2, len, MOD)) % MOD;
            
            long segVal = (power(2, ones, MOD) - 1 + MOD) % MOD;
            segVal = (segVal * power(2, zeros, MOD)) % MOD;
            
            ans = (ans + segVal) % MOD;
        }
        
        return (int) ans;
    }
    
    private long power(long base, long exp, int mod) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }
}