// https://leetcode.com/problems/count-primes

// My first approach:
// Calculate for every number in the range if it's divisible by prime numbers less than it as every number
// is at last a combination of prime factorization, Then its complexity will be O(n * sqrt(n)) which is not ideal.
// Read the primes.md for detailed explanation.
class Solution {
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList();
        boolean isDivisible;

        for (int i = 2; i < n; i++) {
            isDivisible = false;
            for (int j = 0; j < primes.size() && Math.sqrt(i) >= primes.get(j); j++) {
                if (i % primes.get(j) == 0) {
                    isDivisible = true;
                    break;
                }
            }
            if (!isDivisible) primes.add(i);
        }

        return primes.size();
    }
}

// The better solution where the complexity is less than n.
// Approach is called Sieve of Eratosthenes, Read the primes.md for detailed explanation.
class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] wholeNums = new boolean[n + 1];
        int totalPrimes = n - 1;

        for (int i = 2; i*i <= n; i++) {
            if (wholeNums[i] == false) { // This was the optimization I missed. Reduced runtime from 225ms to 90ms.
                for (int j = 2; j*i <= n; j++) {
                    if (wholeNums[i*j] == false) {
                        totalPrimes--;
                        wholeNums[i*j] = true;
                    }
                }
            }
        }

        return wholeNums[n] ? totalPrimes : totalPrimes - 1;
    }
}
