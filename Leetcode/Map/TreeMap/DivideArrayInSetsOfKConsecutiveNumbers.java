// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

// Solved the similar question number 846: hand-of-straights with this code and it uses hashmap instead of treemap and yields much better run time even though there is a separate sort added (I think it is because of the rebalancing happening in TreeMap after every key removal).

// class Solution {
//     public boolean isNStraightHand(int[] hand, int groupSize) {
//         if (hand.length % groupSize != 0) return false;
//         Arrays.sort(hand);
//         Map<Integer, Integer> mp = new HashMap();
//         for (int i : hand) {
//             mp.put(i, mp.getOrDefault(i, 0) + 1);
//         }

//         for (int i : hand) {
//             if (mp.containsKey(i)) {
//                 for (int j = i; j < (i + groupSize); j++) {
//                     if (!mp.containsKey(j)) return false;
//                     if (mp.get(j) == 1) mp.remove(j);
//                     else mp.put(j, mp.get(j) - 1);
//                 }
//             }
//         }

//         return true;
//     }
// }

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> numCount = new TreeMap();
        for (int i : nums) {
            numCount.put(i, numCount.getOrDefault(i, 0) + 1);
        }

        int minVal;
        while (!numCount.isEmpty()) {
            minVal = numCount.firstKey();
            for (int i = minVal; i < minVal + k; i++) {
                if (numCount.containsKey(i)) {
                    if (numCount.get(i) == 1) numCount.remove(i);
                    else numCount.put(i, numCount.get(i) - 1);
                } else return false;
            }
        }
        return true;
    }
}
