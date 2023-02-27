// https://leetcode.com/problems/group-anagrams
// Good solution for the problem have to write modulo to handle overflow -> https://leetcode.com/problems/group-anagrams/solutions/19233/o-m-n-algorithm-using-hash-without-sort/?orderBy=most_votes
// Use delimiter if using the count array method:
// See editorial here: https://leetcode.com/problems/group-anagrams/editorial

class Solution {
    private String sortString(String str) {
        // return new String(Arrays.sort((char[]) str.toCharArray())); // issue here as arrays.sort doesn't return array;
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap();

        for(String str: strs) {
            String sortedString = sortString(str);
            if (hm.containsKey(sortedString)) {
                hm.get(sortedString).add(str);
            } else {
                hm.put(sortedString, new ArrayList() {{ add(str); }});
            }
        }

        return new ArrayList(hm.values()); // This is imp.
    }
}
