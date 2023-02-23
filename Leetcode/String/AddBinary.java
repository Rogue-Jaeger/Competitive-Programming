// https://leetcode.com/problems/add-binary

class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length() - 1, lenB = b.length() - 1, c, d, carry = 0;

        String s = "";

        while (lenA > -1 || lenB > -1) {
            c = lenA > -1 && a.charAt(lenA) == '1' ? 1 : 0;
            d = lenB > -1 && b.charAt(lenB) == '1' ? 1 : 0;

            s = ((c + d + carry) % 2 == 0 ? "0" : "1") + s;
            carry = (c + d + carry) > 1 ? 1 : 0;

            lenA--; lenB--;
        }

        return carry == 1 ? "1" + s : s;

    }
}
