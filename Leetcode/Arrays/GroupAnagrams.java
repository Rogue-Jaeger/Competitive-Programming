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

// Solution using ASICS:
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            //char type 0~127 is enough for constraint 0 <= strs[i].length <= 100
            //char array to String is really fast, thanks @legendaryengineer
            //You should use other data type when length of string is longer.
            //E.g. Use byte (-128 to 127), short (-32,768 to 32,767),
            //int. -2,147,483,648 to 2,147,483,647
            char[] frequencyArr = new char[26];
            for (int i = 0; i < s.length(); i++) {
                frequencyArr[s.charAt(i) - 'a']++;
            }
            //6 ms use char(0~127) array and new String(frequencyArr) method.
            //17ms when use byte (-128 to 127) array and Arrays.toString(frequencyArr) method
            //29ms when use int(-2,147,483,648 to 2,147,483,647) and Arrays.toString(frequencyArr) method
            String key = new String(frequencyArr);
            List<String> tempList = map.getOrDefault(key, new LinkedList<String>());
            tempList.add(s);
            map.put(key, tempList);
        }
        return new LinkedList<>(map.values());
    }
}
