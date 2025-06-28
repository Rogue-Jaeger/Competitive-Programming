# Java Map Usage

## Important Notes

* `Collectors.toMap()` won't even entertain null 'values' let alone keys as it does `Map.merge()`

* Get all values in a Map:

```java
Map<String, List<String>> hm = new HashMap();
hm.values(); // Will give Collection<List<String>>
// If wanted to return List<List<String>> will have to typecast like so:
// new ArrayList(hm.values());
// Otherwise will get error: incompatible types: Collection<List<String>> cannot be converted to List<List<String>>
```

## Common Operations

### Iterating Over Map

Shorthand for `for` loop in Java. Key functions are: `Map.Entry<>`, `entrySet()`, `getKey()`, `getValue()`:

```java
Map<String, String> map = ...
for (Map.Entry<String, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + "/" + entry.getValue());
}
```

### Basic Operations

* Create/Update value in a map: `map.put(key, 1)`
* Clear all elements: `clear()`
* Check if certain key is present in map: `m.containsKey(val)`

**Note:** It's `containsKey()` not just `contains()`

### Advanced Usage

#### Map Creation with Lambdas

```java
List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
Map<String, Integer> map = intList.stream().collect(toMap(i -> String.valueOf(i % 3), i -> i));
```

#### Best Practices

Instead of:

```java
map.put(fruits[i], map.containsKey(fruits[i]) ? map.get(fruits[i]) + 1 : 1);
```

Prefer:

```java
map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
```

### Using Collections as Map Keys

When using collections like Set as a key in Map, the map will use the `hashCode()` of the Set. The Set calculates its `hashCode()` by summing up the `hashCode()` of its individual elements.

For integers, the `hashCode()` value is the integer value itself. For example:

```java
Set<Integer> set = new HashSet();
set.add(1);
set.add(11);
System.out.println(set.hashCode()); // Will output 12
```

This property makes sets effective as keys in maps, especially when checking elements that have been traversed without considering their order, like in `beautifulPermutation.java`.

### Floor/Ceil Functions in TreeMap

```java
ceilingKey(K key);    // Smallest key ≥ given key
floorKey(K key);      // Largest key ≤ given key
higherKey(K key);     // Strictly greater key
lowerKey(K key);      // Strictly smaller key

ceilingEntry(K key);  // Entry version of ceilingKey
floorEntry(K key);    // Entry version of floorKey
higherEntry(K key);   // Entry version of higherKey
lowerEntry(K key);    // Entry version of lowerKey
```
