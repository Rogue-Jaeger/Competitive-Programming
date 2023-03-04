// https://leetcode.com/problems/longest-common-prefix

// Ran 1ms slower
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];

        for (int i = 1; i < strs.length; i++) {
            res = res.length() > strs[i].length() ? res.substring(0, strs[i].length()) : res; // Main thing
            for (int j = 0; j < res.length(); j++) {
                if (res.charAt(j) != strs[i].charAt(j)) {
                    res = res.substring(0, j);
                    break;
                }
            }
            if (res.length() == 0) break;
        }


        return res;
    }
}

// Solution ran the fastest using indexOf()
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
            }

        }
        return prefix;
    }
}
