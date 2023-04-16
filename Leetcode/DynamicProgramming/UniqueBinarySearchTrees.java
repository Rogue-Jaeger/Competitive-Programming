// https://leetcode.com/problems/unique-binary-search-trees

// Got really frustrated on how to do this had to look up that this is a DP problem.
// Catch here is the values are unique across BST so if suppose a node has 3 children those three children will
// always have a middle a smallest and largest integer meaning the values are irrelevant and they
// will form same amount of patters as only n = 3 would do.
// rest was to introduce 4th element and slide it through the array and capture the left and right element count and calculate the ways as so:
// 0 3
// 1 2
// 2 1
// 3 0
// Add all that up you get your result...

class Solution {
    public int numTrees(int n) {
        int[] result = new int[20];
        result[0] = 1; result[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                result[i] += result[i - j - 1] * result[j];
            }
        }

        return result[n];
    }
}

// With imp optimizations

class Solution {
    public int numTrees(int n) {
        // int[] result = new int[20];
        int[] result = new int[n + 1];
        // result[0] = 1; result[1] = 1;
        result[0] = result[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                result[i] += result[i - j - 1] * result[j];
            }
        }

        return result[n];
    }
}
