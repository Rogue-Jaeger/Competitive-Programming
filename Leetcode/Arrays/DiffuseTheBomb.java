// https://leetcode.com/problems/defuse-the-bomb/

class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] result = new int[code.length];

        if (k == 0) return result;

        int direction = k > 0 ? -1 : 1;
        int sum = 0;

        for (int i = 0; i < code.length; i++) {
            sum = 0;
            for (int j = k; j != 0; j += direction) {
                if (k > 0) {
                    sum += code[(i + j) % code.length];
                } else {
                    // This is how you can wrap around backwards just do (+ code.length) additionally.
                    sum += code[(i + j + code.length) % code.length];
                }
            }
            result[i] = sum;
        } 

        return result;
    }
}
