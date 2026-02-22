// https://leetcode.com/problems/k-closest-points-to-origin

// If I didn't use `<>` operator with `new PriorityQueue<>` then it'll give issue with the compilation which is listed below.
// error: array required, but Object found
//   (a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
//              ^

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) pq.remove();
        }

        return pq.toArray(new int[k][2]);
    }
}
