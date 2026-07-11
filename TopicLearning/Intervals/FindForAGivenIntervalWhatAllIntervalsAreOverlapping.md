# Maximum Team Size with Overlapping Intervals

## Core Observation

The base idea to remember is:

For an interval **[a, b]**, we need to find how many intervals satisfy:

- **end >= a**
- **start <= b**

These are exactly the intervals that overlap with **[a, b]**.

A useful way to compute this is:

```
Overlapping Intervals =
(# intervals with start <= b)
-
(# intervals with end < a)
```

This observation is the foundation for solving the following problem.

---

## Problem

**LeetCode 3893 - Maximum Team Size with Overlapping Intervals**

https://leetcode.com/problems/maximum-team-size-with-overlapping-intervals/?envType=problem-list-v2&envId=dnzk14bs

You are given two integer arrays `startTime` and `endTime` of length `n`.

- `startTime[i]` represents the start time of the `i`th employee.
- `endTime[i]` represents the end time of the `i`th employee.

Two employees `i` and `j` can interact if their time intervals overlap.

Two intervals are considered overlapping if they share **at least one common time point**.

A team is **valid** if there exists **at least one employee** in the team who can interact with **every other member** of the team.

Return the **maximum possible size** of such a team.

---

## Approach

For every employee's interval `[startTime[i], endTime[i]]`:

- Count how many intervals have:
  - `start <= endTime[i]`
- Count how many intervals have:
  - `end < startTime[i]`

Then,

```text
Overlapping Intervals =
(start <= end)
-
(end < start)
```

Take the maximum over all employees.

Time Complexity: **O(n log n)**

---

## Solution

```java
class Solution {

    public int getEventsStartingBefore(int[] arr, int find) {
        int left = 0, right = arr.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] <= find) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left] > find ? left - 1 : left;
    }

    public int getEventsEndingBefore(int[] arr, int find) {
        int left = 0, right = arr.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (arr[mid] < find) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left] >= find ? left - 1 : left;
    }

    public int maximumTeamSize(int[] startTime, int[] endTime) {
        int len = startTime.length;

        int[] sortedStartTime = startTime.clone();
        int[] sortedEndTime = endTime.clone();

        Arrays.sort(sortedStartTime);
        Arrays.sort(sortedEndTime);

        int result = 0;

        for (int i = 0; i < len; i++) {

            int eventsStartingBefore =
                    getEventsStartingBefore(sortedStartTime, endTime[i]);

            int eventsEndingBefore =
                    getEventsEndingBefore(sortedEndTime, startTime[i]);

            result = Math.max(
                    result,
                    Math.abs(eventsStartingBefore - eventsEndingBefore)
            );
        }

        return result;
    }
}
```