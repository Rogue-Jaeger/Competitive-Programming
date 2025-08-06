# Square Root Decomposition

Square Root Decomposition is a technique used to answer range queries and perform updates efficiently on arrays. The main idea is to divide the array into blocks of approximately equal size (usually the square root of the array's length). Each block stores precomputed information (like sum, min, max, etc.) for its range. This allows queries and updates to be performed faster than naive approaches, often reducing time complexity from O(n) to O(√n) per operation.

**Key Points:**

- Divide the array into √n blocks.
- Precompute and store information for each block.
- For queries, combine results from full blocks and process partial blocks directly.
- Useful for problems where both queries and updates are required, but not as fast as segment trees for all operations.

---

## Solution

```java
// https://leetcode.com/problems/fruits-into-baskets-iii

// Square root decomposition solution.
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        // Here sq will be stripped of its decimal values if existing..
        int sq = (int) Math.sqrt(fruits.length);

        // To know the size of the values we'll just do this maths.
        // Here we're going to use the formula (n + m - 1) / m
        // Which is equivalent to using Math.ceil(n / m)
        // You just need to add the value you're dividing by and substract 1
        int bucketCount = (baskets.length + sq - 1) / sq;
        int[] buckets = new int[bucketCount];
        
        // Preprocessing..
        for (int i = 0; i < baskets.length; i++) {
            buckets[i / sq] = Math.max(buckets[i / sq], baskets[i]);
        }

        int j, result = 0, nextMax;
        boolean found;
        for (int i = 0; i < fruits.length; i++) {
            for (j = 0; j < bucketCount; j++) {
                if (buckets[j] >= fruits[i]) break;
            }
            if (j != bucketCount) {
                nextMax = Integer.MIN_VALUE; found = false;
                for (int k = j * sq; k < ((j + 1) * sq) && k < baskets.length; k++) {
                    if (!found && baskets[k] >= fruits[i]) {
                        baskets[k] = 0;
                        found = true;
                    } else nextMax = Math.max(nextMax, baskets[k]);
                }
                buckets[j] = nextMax;
            } else result++;
        }
        return result;
    }
}
```
