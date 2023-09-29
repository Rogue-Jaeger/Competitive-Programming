Declare and initialize:
================================================

Java:
------------------------------------------------

LinkedList implements both the List and Deque interface which means it can work as both.
```Queue<Integer> queue = new LinkedList();```

**Linked List API's:**
```
getFirst(); // Just returns the first element in Queue and will not update it.
push(); // This adds value to the front of the list not back. More relevant in case of stack.
addFirst(); // This has the exact functionality of push(). More relevant in case of queue.
pop(); // Removes the first element and returns it. More relevant in case of stack.
removeFirst(); // This has the exact functionality of pop(). More relevant in case of queue.
```
