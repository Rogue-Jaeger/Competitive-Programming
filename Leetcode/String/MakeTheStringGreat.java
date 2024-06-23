// https://leetcode.com/problems/make-the-string-great

// Earlier approach where I used stack.
class Solution {
    public String makeGood(String s) {
        LinkedList<Character> stack = new LinkedList();
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (stack.peek() != null && (stack.peek() == c - 32 || stack.peek() == c + 32)) stack.poll();
            else stack.push(c);
        }
        for (char c : stack) {
            result.insert(0, c);
        }
        return result.toString();
    }
}

// Later approach where I used StringBuilder itself as a stack.
class Solution {
    public String makeGood(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (result.length() > 0 && (result.charAt(result.length() - 1) == c + 32 || result.charAt(result.length() - 1) == c - 32)) {
                result.deleteCharAt(result.length() - 1);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
