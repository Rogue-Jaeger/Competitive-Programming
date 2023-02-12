Java:
====================================================

Below one will not work for primitive types like ```int[]```
```
Collections.sort(intervalList, new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
        return a.start = b.start;
    }
});
```

Below one will work for primitive types like ```int[][]```<br/>
_see MergeIntervals.java for usage._
```
Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
```


