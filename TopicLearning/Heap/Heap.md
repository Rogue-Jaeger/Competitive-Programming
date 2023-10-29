1. Heapify functions have O(n) complexity if we go till last node's parent while traversing ```(size - 1) / 2```.
2. Heap data structure only works on **complete** binary tree, We have to maintain this property on every operation.
3. Similar to binary tree the parent node is at ```(i - 1) / 2``` for 0-Indexed array.
4. Reason for the ```- 1``` above is because for 1-Indexed array the parent is at ```i / 2``` but as adding 0 in 0-Indexed array 
shifts the indexes one value towards the right, So we have to do a ```- 1``` to get the parent in that case.
5. Similar to binary tree the child nodes are at: _For 0-Indexed array_
```
left child node: (2 * i) + 1
right child node: (2 * i) + 2 // (left child node + 1)
```
