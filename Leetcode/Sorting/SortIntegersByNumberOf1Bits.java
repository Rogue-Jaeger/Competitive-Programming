// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits

class Solution {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).
                boxed().
                sorted((first, second) -> {
                    Integer onesInA = 0, onesInB = 0, a = first, b = second;
                    while (a > 0 || b > 0) {
                        onesInA += (a & 1) == 1 ? 1 : 0;
                        a >>>= 1;
                        onesInB += (b & 1) == 1 ? 1 : 0;
                        b >>>= 1;
                    }
                    if (onesInA == onesInB) return first.compareTo(second);
                    return onesInA.compareTo(onesInB);
                }).
                mapToInt(i -> i).
                toArray();
    }
}
