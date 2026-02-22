Java:
====================================================

Sorting:
----------------------------------------------------

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

Insertion order:
----------------------------------------------------

Use LinkedHashSet which by default maintains insertion order (No need to do anything.):

```
Set<String> names = new LinkedHashSet<>();
names.add("Alice");
names.add("Bob");
names.add("Charlie");

for (String name : names) {
    System.out.println(name);  // Output: Alice, Bob, Charlie
}
```
