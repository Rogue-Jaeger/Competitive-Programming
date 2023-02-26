//https://leetcode.com/problems/lru-cache

// Used inbuilt removeEldestEntry function but was not optimal as 2 operations were getting performed everytime.
class LRUCache {
    LinkedHashMap<Integer, Integer> lhm;

    public LRUCache(int capacity) {
        lhm = new LinkedHashMap<> () {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldestEntry) {
                return size() > capacity;
            }
        }
    }

    public int get(int key) {
        int val = lhm.get(key);
        if (val == null) {
            return -1;
        }

        lhm.remove(key);
        lhm.put(key, value);
        return val;
    }

    public void put(int key, int value) {
        lhm.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

// Optimised the approach by using array as map and doubly linked list for storing order
// Learned to create 2 dummy nodes in doubly linked list for ease of code.
// Learned 10_000

class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node[] arr = new Node[10_000 + 1]; // Learned this...
    // Below 2 nodes will never be filled with real data just help us in writing much less if conditions.
    Node first = new Node(-1, -1);
    Node last = new Node(-1, -1);
    int currSize = 0;
    int maxSize = 0;

    // Others sols were deleting as well but no point of doing so
    // private void deleteNode(Node node) {
    //     node.prev.next = node.next;
    //     node.next.prev = node.prev;
    //     arr[node.key] = null; // Key in node is required only for this.
    // }

    private void pushNodeToFront(Node node, int key, int val) {
        // Break ties at the back
        node.next.prev = node.prev;
        node.prev.next = node.next;

        // Add ties at front
        first.next.prev = node;
        node.next = first.next;
        node.prev = first;
        first.next = node;

        node.key = key;
        node.val = val;
    }

    private void addNodeToFront(int key, int val) {
        Node node = new Node(key, val);

        first.next.prev = node;
        node.next = first.next;
        node.prev = first;
        first.next = node;

        arr[key] = node;
    }

    public LRUCache(int capacity) {
        maxSize = capacity;
        first.next = last;
        // first.prev = null; // It will get initialized with null so removing this.

        last.prev = first;
        // last.next = null;
    }

    public int get(int key) {
        if(arr[key] == null) return -1;

        pushNodeToFront(arr[key], key, arr[key].val);

        return arr[key].val;
    }

    public void put(int key, int value) {
        if(arr[key] == null) {
            if(currSize == maxSize) {
                arr[last.prev.key] = null;
                pushNodeToFront(last.prev, key, value);
                arr[key] = first.next;
                return;
            }

            addNodeToFront(key, value);
            arr[key] = first.next;
            currSize++;
            return;
        }

        pushNodeToFront(arr[key], key, value);
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
