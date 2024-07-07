// https://leetcode.com/problems/pass-the-pillow

class Solution {
    public int passThePillow(int n, int time) { // Tricky question, Begs to try it once on paper before submitting.
        int numberOfHops = n - 1;
        return ((time / numberOfHops) & 1) == 1 ? n - (time % numberOfHops) : (time % numberOfHops) + 1; // Someplace its used as n - 1 and someplace its n.
    }
}
