Java:
------------------------------------------------

Shorthand for ```for``` loop in java: Key functions are: ```Map.Entry<>```, ```entrySet()```, ```getKey()```, ```getValue()```

```
Map<String, String> map = ...
for (Map.Entry<String, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + "/" + entry.getValue());
}
```

Create/Update value in a map:```map.put(key, 1);```

Clear all elements: ```clear()```
