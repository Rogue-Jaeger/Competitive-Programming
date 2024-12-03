// https://leetcode.com/problems/adding-spaces-to-a-string

// The below solution uses "new StringBuilder(s)" + "sb.insert()" which is not efficient as the runtime of the solution is 2250ms.
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int offset = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (offset < spaces.length && i == spaces[offset] + offset) {
                sb.insert(i, " ");
                offset++;
            }
        }
        return sb.toString();
    }
}

// This is a faster approach with uses "sb.ensuresCapacity()" + "sb.append()" which runs in 24ms.
class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        sb.ensureCapacity(s.length() + spaces.length);
        int offset = 0;
        for (int i = 0; i < s.length(); i++) {
            if (offset < spaces.length && i == spaces[offset]) {
                sb.append(" ");
                offset++;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

// A much faster approach will be to just use char[] for the same, The solution runs in around 13ms.
class Solution {
    public String addSpaces(String s, int[] spaces) {
        char[] sb = new char[s.length() + spaces.length]; // sb implementation has been replaced from StringBuilder to char[].
        int offset = 0, sbIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (offset < spaces.length && i == spaces[offset]) {
                sb[sbIndex++] = ' ';
                offset++;
            }
            sb[sbIndex++] = s.charAt(i);
        }
        return new String(sb);
    }
}

// If we replace "s.charAt(index)" with "s[index]" the runtime slightly faster as the solution runs in 11ms.
class Solution {
    public String addSpaces(String s, int[] spaces) {
        char[] sChar = s.toCharArray(); // Even after doing this unnecessary step its faster than doing "s.charAt()".
        char[] sb = new char[s.length() + spaces.length];
        int offset = 0, sbIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (offset < spaces.length && i == spaces[offset]) {
                sb[sbIndex++] = ' ';
                offset++;
            }
            sb[sbIndex++] = sChar[i];
        }
        return new String(sb);
    }
}
