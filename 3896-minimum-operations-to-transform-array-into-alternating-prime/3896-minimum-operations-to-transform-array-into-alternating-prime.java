import java.util.Arrays;

class Solution {
    public int minOperations(int[] nums) {
        // The maximum value in nums is 10^5. We need primes slightly larger than 10^5.
        // The first prime after 100,000 is 100,003. So 100,050 is safe.
        int LIMIT = 100050; 
        
        // 1. Sieve of Eratosthenes to find primes
        boolean[] isPrime = new boolean[LIMIT];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false; // 0 and 1 are non-prime
        
        for (int i = 2; i * i < LIMIT; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < LIMIT; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // 2. Precompute the next prime and next non-prime for every number
        int[] nextPrime = new int[LIMIT];
        int[] nextNonPrime = new int[LIMIT];
        
        int p = -1, np = -1;
        for (int i = LIMIT - 1; i >= 1; i--) {
            if (isPrime[i]) {
                p = i;
            }
            if (!isPrime[i]) {
                np = i;
            }
            nextPrime[i] = p;
            nextNonPrime[i] = np;
        }
        
        // 3. Calculate exact operations required
        int ops = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                // Even indices must be prime
                ops += nextPrime[nums[i]] - nums[i];
            } else {
                // Odd indices must be non-prime
                ops += nextNonPrime[nums[i]] - nums[i];
            }
        }
        
        return ops;
    }
}