1
====================================================
// https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level

Rearrange/structure data first in such a way to accommodate below:
1. We sort it first and to find the minimum no of swaps we try to avoid dirty swaps in which no integer gets to its right place. <br>
2. We traverse the array and try to put the right integer at the index we're currently at.
