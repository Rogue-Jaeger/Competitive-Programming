// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> fruitsFreq = new HashMap();
        int end = 0;

        for (int i = 0; i < fruits.length; i++) {
            // fruitsFreq.put(fruits[i], fruitsFreq.containsKey(fruits[i]) ? fruitsFreq.get(fruits[i]) + 1 : 1);
            // Prefer this instead of above one...
            fruitsFreq.put(fruits[i], fruitsFreq.getOrDefault(fruits[i], 0) + 1);
            if (fruitsFreq.size() > 2) {
                if (fruitsFreq.get(fruits[end]) == 1) fruitsFreq.remove(fruits[end]);
                else fruitsFreq.put(fruits[end], fruitsFreq.get(fruits[end]) - 1);
                end++;
            }
        }

        System.gc();
        return fruits.length - end;
    }
}
