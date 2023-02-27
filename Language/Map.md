Java:
------------------------------------------------

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
