// https://leetcode.com/problems/find-the-pivot-integer/

// My solution...
class Solution {
    public int pivotInteger(int n) {
        for (int i = 1; i <= n; i++) {
            if (i*(i+1) == (n-i+1)*(2*i+(n-i))) return i;
        }
        return -1;
    }
}

// Better solution (Not by me)...
// Depicts that the square root of sum of all natural numbers if once multiplied again yields the same number will be the solution.
// e.g. 1 + 2... + 8 -> 36 // sqrt is 6 and 6*6 is 36.
class Solution {
    public int pivotInteger(int n) {
        int y = n*(n+1)/2;
        int x = (int)Math.sqrt(y);
        if(x*x==y) return x;
        else return -1;
    }
}
