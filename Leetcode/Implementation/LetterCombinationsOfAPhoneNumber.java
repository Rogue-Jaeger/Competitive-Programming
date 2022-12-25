//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.List;
import java.util.ArrayList;

class Solution {
    char[][] numPad = {
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    List<String> sol = new ArrayList();

    // Same thing can be done by 2 for loops as for single i it runs for full j.
    private void letterCombinations(String digits, int index, String formedString) {
        int num = Character.getNumericValue(digits.charAt(index));

        for (int i = 0; i < numPad[num].length; i++) {
            if (index == digits.length() - 1) {
                sol.add(formedString + numPad[num][i]);
            } else {
                letterCombinations(digits, index + 1, formedString + numPad[num][i]);
            }
        }

    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList();
        letterCombinations(digits, 0, "");
        return sol;
    }
}
