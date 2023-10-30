Sorting:
================================================

Java:
------------------------------------------------

Sorting an array of primitive type:
```
int[] arr = { 5, -2, 23, 7, 87, -42, 509 };
Arrays.sort(arr); // Notice its arrays not array.
```

Sorting an ArrayList:
```
List<Integer> a = new ArrayList<>();
// Just give null for a comparator and It'll sort in a default manner.
// Came to know about this from Collections.sort() function.
a.sort(null);
```

It's not possible to sort ```int[]``` combined with comparator. We need to convert the array to ```Integer[]``` to do so:
_(Comparators can be used only with objects.)_
```
Arrays.stream(arr).
    boxed().
    sorted((a, b) -> b.compareTo(a)). // sort descending // Its sorted and not sort()
    mapToInt(i -> i). // This is also imp...
    toArray();
```
