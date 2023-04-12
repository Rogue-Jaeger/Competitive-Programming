1. Start and end will both come from mid in most of the cases so apply conditions there so you can assume it ran on start and end as well.
2. 2 base cases will be there in the very end:
    a. start val end
    b. start val val end
3. IMMMMMMMMMMMMMMMMP: Very good tree traversal in the current commit.
4. Check this once: mid + 1 or mid - 1 is beneficial if there are duplicates in the array otherwise below approach is fine.
4. in case of lowest value not available in the array with non-duplicate values the final indexes will be: ```left = 0``` and ```right = -1```
5. in case of highest value not available in the array with non-duplicate values the final indexes will be: ```left = length``` and ```right = length - 1``` - See implementation in SearchInsertPosition.java
