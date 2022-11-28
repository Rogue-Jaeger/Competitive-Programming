// https://leetcode.com/problems/generate-parentheses/

class Solution {
    int parenLen = 0;
    List<String> validParenthesis = new ArrayList();

    private void generateParens(int leftBraceketCount, int rightBracketCount, String str) {
        if(str.length() == parenLen * 2) {
            validParenthesis.add(str);
        }

        if(leftBraceketCount < parenLen) {
            generateParens(leftBraceketCount + 1, rightBracketCount, str + "(");
        }

        if(rightBracketCount < leftBraceketCount) {
            generateParens(leftBraceketCount, rightBracketCount + 1, str + ")");
        }
    } 


    public List<String> generateParenthesis(int n) {
        parenLen = n;

        generateParens(0, 0, "");

        return validParenthesis;
    }
}
