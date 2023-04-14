// https://leetcode.com/problems/gray-code

// Firstly I was thinking in terms of decimal numbers and mapping them to binary which included
// 2D array first row containing index numbers second one including their 1's but count
// then sorting by below row and then fitting/arranging them on final array but there is no easy way to arrange as
// in 2^16, 8 bit numbers come 12k times and 9 bit numbers come 11k times...

// Final approach think in binary format only

// 0
// 1

// now for 2^2
// reverse the above order and add one in front
// 11
// 10

// for 2^3
// reverse all and add one in front
// 101 // as only one bit is changing here so it will map correctly with the previous one
// 111
// 110
// 100 // as this maps with the first one so that condition is also fulfilled

// Its also kind of DP

class Solution { // Solution too slow...

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList();
        int size, j, i;
        result.add(0);

        for (i = 0; i < n; i++) {
            size = result.size();
            for (j = size - 1; j >= 0; j--) {
                result.add(result.get(j) + (int) Math.pow(2, i));
            }
        }

        return result;
    }

}

// Using bit manipulation
class Solution {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList();
        int size, j, i;
        result.add(0);

        for (i = 0; i < n; i++) {
            size = result.size();
            for (j = size - 1; j >= 0; j--) {
                result.add(result.get(j) | (1 << i));
            }
        }

        return result;
    }

}

// More optimized approach is (don't know how this works for now...):
i ^ (i >> 1)
   
<img width="970" alt="image" src="https://user-images.githubusercontent.com/34827180/232134148-cef9d1c1-4342-4904-a703-f90cb449150d.png">    
