// https://leetcode.com/problems/rotate-string/solution/

class Solution {
    public boolean rotateString(String s, String goal) {
        int sStart = 0, goalStart = 0, matched = 0;
        
        if(s.length() != goal.length()) return false;
        
        for (; sStart < s.length(); sStart++) {
            if(goal.charAt(goalStart) == s.charAt(sStart)) {
                matched++;
                goalStart++;
            }
        }
        
        for (int i = 0; i < s.length() - matched; i++) {
            if(goal.charAt(goalStart) != s.charAt(i)) return false;
            goalStart++;
        }
        
        return true;
    }
}
