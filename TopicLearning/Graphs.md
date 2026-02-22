1. Nodes in a binary tree if all nodes are filled till a certain level = (2^h - 1) (<- remember the -1 its for the root level) or 2^0 + 2^1 + 2^2... 
2. IMPPPP - Above line meaning the number of nodes in the last line = sum of all the nodes above it + 1. -- rule used in same commit...<br>
  a. Meaning ```2^x = 2^(x-1) ... 2^0 + 1``` <br>
  b. Will not happen with any other number: <br>
      &nbsp;&nbsp;&nbsp;&nbsp;e.g. ```3^3 = 27 & 3^2 + 3^1 + 3^0 = 13```
3. Number of elements at every row is 2 * h. Where height starts from 0 or if it starts from 1 then height - 1.
4. It's best to keep root's height as 0 easier while finding height of a tree as you won't have to end up with (node is null) condition in the loop.
5. IMP::: for level 4 (actually 5) there will be 16 values in the row and the total node count till the last node will be 31.
6. How to get nodes containing cycle (Got issue here thought depth first search will work but because of adjacency matrix way it can happen that the edge can be `1->2`, `2->3`, `1->4` then `1->3`).