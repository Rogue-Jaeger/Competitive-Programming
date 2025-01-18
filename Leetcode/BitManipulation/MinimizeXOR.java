// https://leetcode.com/problems/minimize-xor

class Solution {
    public int minimizeXor(int num1, int num2) {
        int setBitsIn1 = 0, setBitsIn2 = 0;
        for (int i = 0; i < 31; i++) { // Counting bits here but can be perfomed by java function Integer.bitCount(x);
            if ((num1 & (1 << i)) > 0) setBitsIn1++;
            if ((num2 & (1 << i)) > 0) setBitsIn2++;
        }

        if (setBitsIn1 > setBitsIn2) {
            int diff = setBitsIn1 - setBitsIn2;
            for (int i = 0; i < 31 && diff > 0; i++) {
                if ((num1 & (1 << i)) > 0) {
                    diff--;
                    num1 ^= (1 << i); // Here XOR can be performed for the same result and it'll reduce memory too.
                }
            }
            return num1;
        } else if (setBitsIn1 < setBitsIn2) {
            int diff = setBitsIn2 - setBitsIn1;
            for (int i = 0; i < 31 && diff > 0; i++) {
                if ((num1 & (1 << i)) == 0) {
                    diff--;
                    num1 ^= (1 << i); // Here XOR can be performed for the same result and it'll reduce memory too.
                }
            }
        }

        return num1;
    }
}
