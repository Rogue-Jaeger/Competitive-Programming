// https://leetcode.com/problems/number-of-provinces

// Learned how to calculate number of disconnected components.

class Solution {

    private int getParentNode(int[] parent, int childNode) {
        int parentNode = parent[childNode];
        int startingNode = childNode;
        while (childNode != parentNode) {
            childNode = parentNode;
            parentNode = parent[childNode];
        }

        int tempNode;
        while (startingNode != parentNode) {
            tempNode = parent[startingNode];
            parent[startingNode] = parentNode;
            startingNode = tempNode;
        }

        return parentNode;
    }

    public int findCircleNum(int[][] isConnected) {
        int[] parent = new int[isConnected.length];

        for (int node = 0; node < isConnected.length; node++) {
            parent[node] = node;
        }

        int parentNodeOfFirst = 0, parentNodeOfSecond = 0;
        for (int firstNodeIndex = 0; firstNodeIndex < isConnected[0].length; firstNodeIndex++) {
            for (int secondNodeIndex = firstNodeIndex + 1; secondNodeIndex < isConnected[0].length; secondNodeIndex++) {
                if (isConnected[firstNodeIndex][secondNodeIndex] == 1) {
                    parentNodeOfFirst = getParentNode(parent, firstNodeIndex);
                    parentNodeOfSecond = getParentNode(parent, secondNodeIndex);

                    parent[parentNodeOfFirst] = parentNodeOfSecond;
                }
            }            
        }

        boolean[] isVisited = new boolean[isConnected.length];
        int result = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (isVisited[i]) continue;
            int startingNode = i, parentNode = parent[startingNode];
            while (startingNode != parentNode) {
                startingNode = parentNode;
                parentNode = parent[startingNode];
            }
            if (!isVisited[parentNode]) {
                isVisited[parentNode] = true;
                result++;
            }
        }
        return result;
    }
}
