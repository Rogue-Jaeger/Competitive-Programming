# Binary Indexed Tree (Fenwick Tree)

A Binary Indexed Tree is quite different from a Segment Tree in how it stores data.

Suppose you have an array with `n` values. In a Segment Tree, the root node contains the result for all `n` values, and it has two child nodes that each store partial results for the left and right parts of the array, respectively.

However, in a Binary Indexed Tree, although the root node contains information about the entire array, it does not store separate information for the left and right subtrees. This structural difference can present challenges for certain problems, such as [Fruits Into Baskets III](https://leetcode.com/problems/fruits-into-baskets-iii/description/).
