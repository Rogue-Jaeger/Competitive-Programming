# Idea:

The basic idea is to preprocess the string that needs to be searched (TBS) to obtain the runtime complexity of O(n).

# Intuition:

What we want is to store information that we will gather while traversing the TBS string to be used to optimize the algo while we are searching TBS string in suppose a paragraph.

In general brute force algorithm what we do is first match the first character in the TBS string in the paragraph and if it matches then start matching the consecutive characters and if an mismatch is found then we do the whole process all over again by shifting the TBS by one index to the right and match from the very first character again. 

But instead of starting the whole process by matching the first character of TBS string with the character (now at (index + 1)) of the paragraph, what if we optimized it and shifted the string by either the whole length (the length if any that has been matched till now) or by an arbitrary amount (1 <= amount <= (length if that has been matched till now)). 

This amount of shifting that we'll have to do will based on insights that we gathered while we were preprocessing the TBS string.

# Design:

Now the algorithm can be broken down into 2 phases:

1. Preprocess the TBS string.
2. Search the TBS string in the paragraph.

Lets get into preprocessing the TBS string first:

What we need to do here is while traversing the TBS keep an eye out for substrings (no matter the length) that match the substring of the same length if taken from the beginning of the string.

i.e If we have a TBS like this: (. denotes some random characters in between)

```
abcd.......abcd.......
```

then we need to capture that the substring occuring later is matching the pattern if taken from the start of the string. 

Why do we do this? To intelligently place the TBS string for the next match if in case a mismatch occurs. 

i.e If the paragraph is something like this:

```
...........abcd........abcdf..........  <- Paragraph   
           abcd........abcde....        <- TBS string  
```

Now we know that the paragraph and the TBS string mismatches at the characters f and e. Now as a mismatch has ocurred so like a brute force approach we will not shift the TBS string by one index and match the character b in paragraph to the first character a in the TBS string. 

We will already know that before the mismatched character e we had already matched the substring abcd (with the paragraph) which is also a substring that occurs in TBS from the beginning so we shift it intelligently this way:

```
Brute force:
...........abcd........abcdf..........  <- Paragraph   
            abcd........abcd....        <- TBS string  
```
```
KMP:
...........abcd........abcdf....................        <- Paragraph   
                       abcd........abcd....             <- TBS string
```

We shifted the string by a significant amount and will now check the f in the paragraph with the next character present in the TBS string. 

This precomputation saved us lots of unnecesary comparisons.

Edge case here is what if the mismatch occurs at some place that has no commanality from the start of the string. i.e. Here uksd doesn't match with the any substring starting from the beginning of TBS string.

```
...........abcd........uskdf..........  <- Paragraph   
           abcd........uskd....         <- TBS str
```

In this case we know that we've already matched 

```
abcd........uskd
```

and this string is not having any commanality between itself (this is the information that we gathered earlier while processing the TBS earlier).

So we will shift the entire string forward like so:
```
...........abcd........uskdf.........................    <- Paragraph   
                            abcd........uskd....         <- TBS str
```
This again saves us a lot of computations.

# Implementation:

Now how do we preprocess the TBS string, We do it by generating an array as we process the TBS array that will contain the length of substring that matches till that character if the substring starts from the beginning of the TBS string.

**Process of generating the Array:**

 ![Preprocessing](/Assets/Images/KMP_Algo_Preprocessing.jpg)

**Code for generating the required Array:**

```
String tbs = "tbsString";
int lengthMatchingTillNow = 0;
int index = 1; // The first character isn't coming before anywhere in the string.
int[] lengthArr = new int[tbs.length()]; // This is the array that we need to generate.

while (index != tbs.length()) {
    if (tbs.charAt(index) == tbs.charAt(lengthMatchingTillNow)) {
        lengthMatchingTillNow++;
        lengthArr[index] = lengthMatchingTillNow;
        index++;
    } else {
        if (lengthMatchedTillNow != 0) {
            lengthMatchedTillNow = lengthArr[lengthMatchedTillNow - 1];
        } else {
            lengthArr[index] = 0; // here lengthMatchingTillNow == 0
            index++;
        }
    }
}
```
