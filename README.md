1. Declaring variables outside main function saved 15ms of runtime on Codeforces.
2. Its 1e9+7 not 10e9+7, As e means "Times 10 to the" here its donating (1*10)^9 + 7.
3. ll or LL makes an integer literal of type long long which can be used inside large (integer, integer) multiplications where there are chances of overflow. There won't be any need for this if we multiply long long with integer as the result will be casted to long long automatically. Commit hash - 0279c47be37eee931616ed49385af8e409c03dd1
4. Run multiple lines after for loop not having opening brackets using commas. Commit hash - 33e1b276239a517887978e354fe223a1615cbec8
5. Calculate steps in binary search to find a failure case for (l==r). Find 25 in --> 21 22 23 23 24 24 26 27 29 30 31
6. Binary search will always yeild in the closest values(present in closest index (if l > r then l and r are the closest indices)) to what you want to search may it be a lower value than what you wanted to search or bigger. Find 55 in 52 52 57 58 59.
7. How to do binary search to find closest neighbours - Commit hash - 3231091f6b3e9d0446a036acbc7cfa7bc6210fe2
8. In binary search the values of l and r can go beyond the bounds and can have values [0, n].
9. In binary search the final index points to the number just greater or smaller than the searched for number.
10. Through scanf you cannot input string type you have to declare a character array to do so and the input method is scanf("%s", n), notice there is no & before n. To get size of string in c strlen().
11. Cannot compare long long and int type in min or max function.
12. Doing (+ 1) operation is any easy way to perform ceil functionality in integer division where you'll have to divide by 2; -- See same commit to find code where used.
13. Binary search: // Don't do mid+1 or mid-1 while updating start and end values if you never want start == end. -- See same commit to find code.
14. Swapping values in an array will always maintain the count of individual values which will save extra lines of code to be written just to maintain count. See: [Sort Colors](https://leetcode.com/problems/sort-colors/)
15. In competitions no leading 0 means 0 should not be in front of any digit [0, 9] but it can be present singly i.e. 0 is a valid output.
16. Try using your existing partial computed solution may it be in the form of array or variable instead of creating further variables to derive further solutions. See code for MergeIntervals.java
