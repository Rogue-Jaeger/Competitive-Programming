// https://leetcode.com/problems/min-cost-to-connect-all-points/

/**
 * Some graph problems like this take n^2 complexity so don't think too hard on that.
 * 
 * This is more of an heap question as well so can be included in the heap section as well.
 * The algorithm implemented by using heaps is prims.
 * The major problem I got while writing the code for heap is for calculating size.
 * 
 * I'm taking too much memory for this check if that can be reduced.
 */

class Solution {
    int[][] minHeap = null;
    int size = 0;

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return (parentIndex << 1) + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return (parentIndex << 1) + 2;
    }

    private void insert(int[] val) {
        minHeap[size] = val;
        int currentIndex = size;
        size++;
        while (currentIndex != getParentIndex(currentIndex)) {
            if (minHeap[currentIndex][0] < minHeap[getParentIndex(currentIndex)][0]) {
                int[] temp = minHeap[currentIndex];
                minHeap[currentIndex] = minHeap[getParentIndex(currentIndex)];
                minHeap[getParentIndex(currentIndex)] = temp;
                currentIndex = getParentIndex(currentIndex);
            } else break;
        }
    }

    private int[] pop() {
        int[] temp = minHeap[size - 1];
        minHeap[size - 1] = minHeap[0];
        minHeap[0] = temp;

        int minValChildIndex;
        int currentIndex = 0;
        --size;

        while (currentIndex <= getParentIndex(size)) { // This condition has been improved as compared to the initial approcach done for KthLargestElementInStream.
            int leftChildIndex = getLeftChildIndex(currentIndex), rightChildIndex = getRightChildIndex(currentIndex);
            minValChildIndex = currentIndex;
            if (leftChildIndex < size && minHeap[leftChildIndex][0] < minHeap[minValChildIndex][0]) {
                minValChildIndex = leftChildIndex;
            }
            if (rightChildIndex < size && minHeap[rightChildIndex][0] < minHeap[minValChildIndex][0]) {
                minValChildIndex = rightChildIndex;
            }
            if (minValChildIndex != currentIndex) {
                temp = minHeap[currentIndex];
                minHeap[currentIndex] = minHeap[minValChildIndex];
                minHeap[minValChildIndex] = temp;
                currentIndex = minValChildIndex;
            } else break;
        }

        return minHeap[size];
    }

    private int calcCost(int[][] distances) {
        final Set<Integer> visited = new HashSet();
        minHeap = new int[distances.length * distances.length][2];

        int result = 0;
        int[] nextNode = new int[2];
        while (visited.size() != distances.length) {
            while (visited.contains(nextNode[1])) {
                nextNode = pop();
            }

            visited.add(nextNode[1]);
            result += nextNode[0];

            for (int i = 0; i < distances.length; i++) {
                if (nextNode[1] != i) {
                    int[] node = new int[2];
                    node[0] = distances[nextNode[1]][i];
                    node[1] = i;
                    insert(node);
                }
            }

        }

        return result;
    }

    public int minCostConnectPoints(int[][] points) {
        int[][] distances = new int[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                distances[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        return calcCost(distances);
    }
}
