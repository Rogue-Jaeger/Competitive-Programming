// There's a non recursive way to solve the problem as well look at the sols on website..

class Solution {

    public int calcMax(int[] piles, int index, boolean alicePlaying, int M, int X, int[][][] dp) {
        if (index >= piles.length) return 0;

        // IMP NOTE: The other person cannot just pick twice the previous person assuming which was my mistake.
        // In actuality if uptil a point in the branch anybody has choosen X more than one than in that case
        // M below in the branch will never be one as M = MAX(M, X)
        // e.g. A chooses X = 2
        // Then in the next step B chooses X = 1
        // Now in the next turn what would be the max X that A can choose again..
        // Its 4 and not 2 cause:
        // A chooses X = 2, M = 1
        // B chooses X = 1, M = (1, 2) = 2
        // A can choose M * 2 = 4. 
        M = Math.max(M, X); 
        int canPick = M * 2;
        if (dp[alicePlaying ? 0 : 1][index][canPick] != -1) {
            return dp[alicePlaying ? 0 : 1][index][canPick];
        }

        int sum = 0, val = 0, score = alicePlaying ? Integer.MIN_VALUE : Integer.MAX_VALUE, picked = 1;
        for (int i = index; i < piles.length && i < (index + canPick); i++) {
            val = calcMax(piles, i + 1, !alicePlaying, M, picked, dp);
            if (alicePlaying) {
                sum += piles[i];
                score = Math.max(sum + val, score);
            } else {
                score = Math.min(val, score);
            }
            picked++;
        }

        dp[alicePlaying ? 0 : 1][index][canPick] = score;
        return score;
    }

    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[2][piles.length][100];
        for (int[][] i : dp) for (int[] j : i) Arrays.fill(j, -1);
        return calcMax(piles, 0, true, 1, 0, dp);
    }
}
