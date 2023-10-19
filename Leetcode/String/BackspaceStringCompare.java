// https://leetcode.com/problems/backspace-string-compare

// O(1) space complexity in string means that you don't use String.substring() function.
// Major breakthrough came when it dawned on me to traverse through the back of the string.

class Solution {
    public boolean backspaceCompare(String s, String t) {
        int currIndexInS = s.length() - 1, currIndexInT = t.length() - 1;
        int hashCountInS = 0, hashCountInT = 0;

        while (currIndexInS > -1 || currIndexInT > -1) { // (currIndexInS > -1 && currIndexInT > -1) failed the case for "nzp#o#g", "b#nzp#o#g" as b# cancels out so we need to see it through the end.
            while (currIndexInS > -1) {
                if (s.charAt(currIndexInS) == '#') {hashCountInS++; currIndexInS--;}
                else if (hashCountInS > 0) {hashCountInS--; currIndexInS--;}
                else break;
            }

            while (currIndexInT > -1) {
                if (t.charAt(currIndexInT) == '#') {hashCountInT++; currIndexInT--;}
                else if (hashCountInT > 0) {hashCountInT--; currIndexInT--;}
                else break;
            }

            if (
                    currIndexInS > -1 && currIndexInT > -1
                            && s.charAt(currIndexInS) != t.charAt(currIndexInT)
            ) return false;

            currIndexInS--;currIndexInT--;
        }

//        System.out.println(currIndexInS + " " + currIndexInT);
//        Above will print -2 -2 for the case "nzp#o#g", "b#nzp#o#g"

        return currIndexInS == currIndexInT;
    }
}
