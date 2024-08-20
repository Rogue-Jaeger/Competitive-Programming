// https://leetcode.com/problems/kth-largest-element-in-a-stream

/**
 * While inserting the value the element is placed at the bottom and propogated upwards
 * while in the case of delete the last element is placed at the top and then propogated
 * downwards. 
 * So in a nutshell the flow is: insert -> bottom to top, delete -> top to bottom
 * 
 * Delete functionality is bigger than insert
 * 
 * There is a heapify function as well (not implemented here) which works on an already present
 * array and creates a heap out of it its amortized complexity is O(n), Whereas if you
 * generate heap on every input one by one the complexity is:
 * for loop for every element -> O(n)
 * insert the element into heap -> O(log(n))
 * total complexity: O(nlog(n))
 * 
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

class KthLargest {
    private int k, size = 0;
    private int[] minHeap;

    // In a 0-Indexed array.
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    // In a 0-Indexed array.
    private int getLeftChildIndex(int parentIndex) {
        return (2 * parentIndex) + 1;
    }

    // In a 0-Indexed array.
    private int getRightChildIndex(int parentIndex) {
        return (2 * parentIndex) + 2;
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = minHeap[firstIndex];
        minHeap[firstIndex] = minHeap[secondIndex];
        minHeap[secondIndex] = temp;
    }

    // Core function of min heap which deletes the value from root which is minHeap[0].
    private void delete() {
        swap(0, size - 1); // Main logic remove the value from the top and put it at the end.
        --size; // Won't consider the element removed from the top which now exists at the index size - 1.
        int currentIndex = 0, minValChildIndex = 0;
        while (currentIndex <= getParentIndex(size)) { // Go till the parent of the last child for optimization...
            int leftChildIndex = getLeftChildIndex(currentIndex), rightChildIndex = getRightChildIndex(currentIndex);
            if (leftChildIndex < size && minHeap[currentIndex] > minHeap[leftChildIndex]) { // missed the first & condition...
                minValChildIndex = getLeftChildIndex(currentIndex);
            }
            if (rightChildIndex < size && minHeap[minValChildIndex] > minHeap[rightChildIndex]) { // missed the first & condition...
                minValChildIndex = getRightChildIndex(currentIndex);
            }
            if (minValChildIndex != currentIndex) {
                swap(minValChildIndex, currentIndex);
                currentIndex = minValChildIndex;
            } else break;
        }
    }

    // Core function of min heap which inserts a value in it.
    private void insert(int val) {
        int currentIndex = size, parentIndex = getParentIndex(size); // Here (size) will come as (size - 1) will contain genuine val.
        minHeap[currentIndex] = val; // Here inserting the value at the end takes care of the heap being a complete binary tree condition.
        while (currentIndex != parentIndex) { // Here can't do currentIndex >= 0 as (0 - 1) / 2 = 0
            if (minHeap[currentIndex] < minHeap[parentIndex]) {
                swap(currentIndex, parentIndex);
            }
            currentIndex = parentIndex;
            parentIndex = getParentIndex(parentIndex);
        }
        size++;
    }

    // Non generic function which decides if we need to insert or not in the heap.
    private void insertInMinHeap(int val) {
        if (size < k) {
            insert(val);
        } else if (val > minHeap[0]) {
            delete();
            insert(val);
        }
    }

    // Initializing function...
    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new int[k];

        for (int i = 0; i < nums.length; i++) {
            insertInMinHeap(nums[i]);
        }
    }

    public int add(int val) {
        insertInMinHeap(val);
        return minHeap[0];
    }
}
