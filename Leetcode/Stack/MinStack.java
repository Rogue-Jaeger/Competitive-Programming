//https://leetcode.com/problems/min-stack

//First approach: Didn't think we needed to implement stack with stack

class MinStack {

    TreeMap<Integer, Integer> tm;
    LinkedList<Integer> ll;

    public MinStack() {
        tm = new TreeMap();
        ll = new LinkedList();
    }

    public void push(int val) {
        ll.addFirst(val);
        tm.put(val, tm.containsKey(val) ? tm.get(val) + 1 : 1);
    }

    public void pop() {
        Integer poppedVal = ll.poll();
        if (tm.get(poppedVal) > 1) tm.put(poppedVal, tm.get(poppedVal) - 1);
        else tm.remove(poppedVal);
    }

    public int top() {
        return ll.peek();
    }

    public int getMin() {
        return tm.firstEntry().getKey();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

//Optimal approach didn't figure out:

class MinStack {
    public void push(int x) {
        if (stack.isEmpty())
            stack.push(new int[] {x, x});
        else
            stack.push(new int[] {x, Math.min(x, stack.peek()[1])});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    private Stack<int[]> stack = new Stack<>();
}
