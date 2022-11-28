// https://leetcode.com/problems/validate-binary-tree-nodes/
// Below case failed my earliest logic.
// 4
// [1,0,3,-1]
// [-1,-1,-1,-1]
// In case to find if an array constitutes to be binary tree most prob. we'll
// have to traverse the tree.

class Solution {
    // Earlier wrong solution.
    // public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    //     Set<Integer> vals = new HashSet();

    //     // Rapirations for above failed case.
    //     Set<Integer> hasOutNodes = new HashSet();
        
    //     int size = n;
        
    //     while(--size >= 0) {
    //         if(leftChild[size] != -1) {
    //             hasOutNodes.add(size);
    //             if(!vals.add(leftChild[size])) {
    //                 return false;
    //             }
    //             if(hasOutNodes.contains(leftChild[size])) {
    //                 return false;
    //             }
    //         }
    //         if(rightChild[size] != -1) {
    //             hasOutNodes.add(size);
    //             if(!vals.add(rightChild[size])) {
    //                 return false;
    //             }
    //             if(hasOutNodes.contains(rightChild[size])) {
    //                 return false;
    //             }
    //         }
    //     }
        
    //     if(n - vals.size() != 1) {
    //         return false;
    //     }
        
    //     return true;
    // }

    Set<Integer> visitedNodes = new HashSet();
    boolean isValidTree = true; 

    private void traverseTree(int[] leftChild, int[] rightChild, int index) {
        if(!isValidTree) return;
        

        if(leftChild[index] != -1) {
            if(!visitedNodes.add(leftChild[index])) {
                isValidTree = false;
                return;
            }
            traverseTree(leftChild, rightChild, leftChild[index]);
        }

        if(rightChild[index] != -1) {
            if(!visitedNodes.add(rightChild[index])) {
                isValidTree = false;
                return;
            }
            traverseTree(leftChild, rightChild, rightChild[index]);
        }

        return;
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> nodes = new HashSet();
        
        for(int i = 0; i < n; i++) {
            if(leftChild[i] != -1) {
                if(!nodes.add(leftChild[i])) return false;
            }
            if(rightChild[i] != -1) {
                if(!nodes.add(rightChild[i])) return false;
            }
        }

        if(n - nodes.size() != 1) return false;

        int rootIndex = -1;
        for(int i = 0; i < n; i++) {
            if(!nodes.contains(i)) rootIndex = i;
        }

        traverseTree(leftChild, rightChild, rootIndex);
        
        if(n - visitedNodes.size() != 1) return false;
        
        return isValidTree;
    }
}
