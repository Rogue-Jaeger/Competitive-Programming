// https://leetcode.com/problems/triangle

// Top-Down approach
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 1; j < i; j++) {
                triangle.get(i).set(
                        j,
                        Math.min(
                                triangle.get(i - 1).get(j - 1),
                                triangle.get(i - 1).get(j)
                        ) + triangle.get(i).get(j)
                );
            }
            triangle.get(i).set(
                    0,
                    triangle.get(i - 1).get(0) + triangle.get(i).get(0)
            );
            triangle.get(i).set(
                    i,
                    triangle.get(i - 1).get(i - 1) + triangle.get(i).get(i)
            );
        }

        // If we do a bottom up approach the result will be at triangle[0][0]
        // And this loop will be omitted
        for (int num : triangle.get(triangle.size() - 1)) {
            min = Math.min(min, num);
        }

        return min;
    }
}

// Bottom-Up approach
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(
                        j,
                        Math.min(
                                triangle.get(i + 1).get(j),
                                triangle.get(i + 1).get(j + 1)
                        ) + triangle.get(i).get(j)
                );
            }
        }

        return triangle.get(0).get(0);
    }
}
