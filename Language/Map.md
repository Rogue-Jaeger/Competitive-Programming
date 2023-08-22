Java:
------------------------------------------------

**IMP: Collectors.toMap() won't even entertain null 'values' let alone keys as it does Map.merge()** <br>
**IMP: Get all values in a Map:**
```
Map<String, List<String>> hm = new HashMap();
hm.values(); // Will give Collection<List<String>>
// If wanted to return List<List<String>> will have to typecast like so:
// new ArrayList(hm.values());
// Otherwise will get error: incompatible types: Collection<List<String>> cannot be converted to List<List<String>>
```

Shorthand for ```for``` loop in java: Key functions are: ```Map.Entry<>```, ```entrySet()```, ```getKey()```, ```getValue()```

```
Map<String, String> map = ...
for (Map.Entry<String, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + "/" + entry.getValue());
}
```

Create/Update value in a map:```map.put(key, 1);```

Clear all elements: ```clear()```

To check if certain key is present in map: ```m.containsKey(val)``` <br>
**IMP: Its ```containsKey()``` not just ```contains()```**

**A shorthand for map creation through lambdas:**
```
List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
Map<String, Integer> map = intList.stream().collect(toMap(i -> String.valueOf(i % 3), i -> i));
```

**Good Practice:**
```
map.put(fruits[i], map.containsKey(fruits[i]) ? map.get(fruits[i]) + 1 : 1);
map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1); // Prefer this instead of above one...
```
