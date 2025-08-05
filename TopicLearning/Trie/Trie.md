# Trie Data Structure Implementation Notes

## Space Complexity for Word Endings

In a trie data structure, it takes O(1) space to add if the word ended at a particular location, not O(N).

### Implementation Comparison

Inefficient implementation:

```java
class Trie {
    char[] childNodes;
    boolean[] isWordEndingHere;
}
```

Efficient implementation:

```java
class Trie {
    char[] childNodes;
    boolean isWordEndingHere;
}
```

### Example

For a word "x", we don't store the word ending flag at the same Trie node. Instead, we store it at the next node like so:

`"x"(TrieNode) -> NextTrieNode` (with empty childNodes[] array but isWordEndingHere as true)
