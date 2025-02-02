// https://leetcode.com/problems/find-if-path-exists-in-graph/

// Imp: Even after doing path compression while running find() function (in order to bring the amortised time complexity to O(n))
//      it doesn't guarantee that even at the very end while calculating result if source and destination are in the same component
//      will be having the values of root nodes directly that's why we perform find operation in the validPath() function again.
// Below implementation doesn't include code for calculating the size of a component (Used in efficiently assigning root in path compression)
//      and the code to check the count of total distinct components at the very end.

// Code thought of and written by me:
class Solution {
    private boolean find(int[] parentNodes, int firstNode, int secondNode) {
        int firstRoot = firstNode, secondRoot = secondNode;
        while (parentNodes[firstRoot] != firstRoot || parentNodes[secondRoot] != secondRoot) { // This 2 root approach can be further reduced in code size to call find() twice for each root (needs to be done later).
            firstRoot = parentNodes[firstRoot];
            secondRoot = parentNodes[secondRoot];
        }

        int temp1 = 0, temp2 = 0, temp3 = firstNode, temp4 = secondNode;
        while (parentNodes[firstNode] != firstNode || parentNodes[secondNode] != secondNode) { // Doing this step for path compression alone.
            temp1 = parentNodes[firstNode];
            temp2 = parentNodes[secondNode];
            parentNodes[firstNode] = firstRoot;
            parentNodes[secondNode] = secondRoot;
            firstNode = temp1;
            secondNode = temp2;
        }

        return parentNodes[temp3] == parentNodes[temp4];
    }

    private int[] union(int[][] edges, int n) {
        int[] parentNodes = new int[n];
        for (int i = 0; i < n; i++) {
            parentNodes[i] = i;
        }

        for(int i = 0; i < edges.length; i++) {
            if (!find(parentNodes, edges[i][0], edges[i][1])) {
                parentNodes[parentNodes[edges[i][0]]] = parentNodes[edges[i][1]]; // Insert in one's parent the parent of another not in the child the other's parent.
            }
        }

        return parentNodes;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parentNodes = union(edges, n);
        return find(parentNodes, source, destination);
    }
}
