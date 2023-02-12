//https://leetcode.com/problems/merge-intervals/
// Learning: ArrayList<ArrayList<Integer>> cannot be converted to List<List<Integer>>


class Solution {
    public int[][] merge(int[][] intervals) {
//        List<List<Integer>> result = new Arraylist<ArrayList<>>(); // see error on the top.
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0], end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (end >= intervals[i][0]) {
                end = end < intervals[i][1] ? intervals[i][1] : end;

                if (i + 1 == intervals.length) {
                    result.add(new ArrayList<Integer>(Arrays.asList(start, end)));
                }
            } else {
                result.add(new ArrayList<Integer>(Arrays.asList(start, end)));

                if (i + 1 == intervals.length) {
                    result.add(new ArrayList<Integer>(Arrays.asList(intervals[i][0], intervals[i][1])));
                } else {
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
        }

        if (intervals.length == 1) {
            result.add(new ArrayList<Integer>(Arrays.asList(intervals[0][0], intervals[0][1])));
        }

        return result.stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
    }
}

// Optimising the above solution
//1. Using ArrayList<int[]>
//2. Resusing the array created instead of creating separate start and end variables.

class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<int[]>(); // doesn't let you declare int[2] here error is shown below...

//        Line 4: error: ']' expected
//        ArrayList<int[2]> result = new ArrayList<int[2]>();
//                      ^
//        Line 4: error: not a statement
//        ArrayList<int[2]> result = new ArrayList<int[2]>();
//                 ^
//        Line 4: error: ']' expected
//        ArrayList<int[2]> result = new ArrayList<int[2]>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        result.add(intervals[0]); // Added the first one immediately.

        for (int[] interval : intervals) {

            if (result.get(result.size() - 1)[1] >= interval[0]) {
                result.get(result.size() - 1)[1] = Math.max(interval[1], result.get(result.size() - 1)[1]);
            } else {
                result.add(interval);
            }

        }

        return result.toArray(new int[result.size][2]);
    }
}
