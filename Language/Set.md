Java:
====================================================

```TreeSet``` in java sorts by default in ascending order for strings and integers. i.e.<br>
```
TreeSet<Integer> num = new TreeSet<>();
num.add(6);
num.add(-4);
num.add(610);
System.out.println("TreeSet: " + num);

result: TreeSet: [-4, 6, 610]
```

To remove all elements from the TreeSet use ```clear()``` function.
