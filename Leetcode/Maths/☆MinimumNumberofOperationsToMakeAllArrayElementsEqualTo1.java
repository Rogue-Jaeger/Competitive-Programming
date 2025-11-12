// https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1

// Based on the constraints thought of this solution first which is recursive
class Solution {
    public int minOps = Integer.MAX_VALUE;

    int getGcd(int a, int b) {
        int temp = a;
        a = Math.max(a, b); // this is not required see other solution below.
        b = Math.min(b, temp);
        while (b != 0) {
            temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    boolean isEven(int a) {
        return (a & 1) == 0;
    }

    void solve(int[] nums, int ops) {
        int gcd, preVal;
        for (int i : nums) System.out.print(i + " ");
        System.out.println();
        for (int i = 1; i < nums.length; i++) {
            if (!(isEven(nums[i]) && isEven(nums[i - 1]))) {
                gcd = getGcd(nums[i], nums[i - 1]);
                if (gcd == 1) {
                    System.out.println("FOUNDDDDDD " + ops);
                    minOps = Math.min(minOps, ops + nums.length);
                } else {
                    System.out.println("---" + nums[i - 1] + " " + nums[i] + "---");
                    if (gcd != nums[i]) {
                        preVal = nums[i];
                        nums[i] = gcd;
                        solve(nums, ops + 1);
                        nums[i] = preVal;
                    }

                    if (gcd != nums[i - 1]) {
                        preVal = nums[i - 1];
                        nums[i - 1] = gcd;
                        solve(nums, ops + 1);
                        nums[i - 1] = preVal;
                    }
                }
            }
        }
    }


    public int minOperations(int[] nums) {
        int oneCount = 0;
        boolean hasOds = false;
        for (int i : nums) {
            if ((i & 1) == 1) hasOds = true;
            if (i == 1) oneCount++;
        }

        if (oneCount > 0) return nums.length - oneCount;
        if (!hasOds) return -1;

        solve(nums, 0);
        return minOps;
    }
}

// Optimized solution which runs in n ^ 2.
class Solution {
    int getGcd(int a, int b) {
        // int temp = a;
        // a = Math.max(a, b);
        // b = Math.min(b, temp);
        // We actually dont need to check the order for the first time cause 
        // GCD algo will aready do that for us as in case of 
        // values are like b > a then in the first iteration of the while loop
        // the values will get swapped automatically as:
        // a % b = a if b > a
        int temp;
        while (b != 0) {
            temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public int minOperations(int[] nums) {
        int oneCount = 0;
        int gcd = 0;
        for (int i : nums) {
            if (i == 1) oneCount++;
            // We're working on the fact that in the range of numbers if the GCD is not 1 then 
            // that range of numbers will never become ones..
            gcd = getGcd(gcd, i);
        }
        if (oneCount > 0) return nums.length - oneCount;
        if (gcd > 1) return -1;

        int cumulativeGcd, result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            cumulativeGcd = 0;
            for (int j = i; j < nums.length; j++) {
                cumulativeGcd = getGcd(cumulativeGcd, nums[j]);
                if (cumulativeGcd == 1) {
                    // Meaning when we took all elements together we got 1.
                    // Num of ops done to get that one is 1 less than the number of numbers considered.
                    result = Math.min(result, j - i + nums.length - 1);
                    break;
                }
            }
        }
        return result;
    }
}
