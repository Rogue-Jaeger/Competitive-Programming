// https://leetcode.com/problems/maximum-odd-binary-number
// Got to know that StringBuilder is significantly faster and memory efficient in append type of operations.

// First approach took runtime of 4ms and memory of 44mb
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int onesCount = 0;
        String result = "";
        for (char c : s.toCharArray()) {
            if (c == '1') onesCount++;
        }
        for (int i = 0; i < onesCount - 1; i++) {
            result += '1';
        }
        for (int i = 0; i < s.length() - onesCount; i++) {
            result += '0';
        }
        return result + '1';
    }
}

// Second approach took runtime of 2ms and memory of 43mb
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int onesCount = 0;
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '1') onesCount++;
        }
        for (int i = 0; i < onesCount - 1; i++) {
            result.append('1');
        }
        for (int i = 0; i < s.length() - onesCount; i++) {
            result.append('0');
        }
        return result.append('1').toString();
    }
}
