# Why Does `boolean[]` in Java Use 1 Byte per Element, Not 1 Bit?

## The Short Answer

Because of memory alignment, simplicity, and performance. Java's memory model stores each `boolean` as a byte (8 bits) — even though it only needs 1 bit.

---

### Deeper Explanation

#### 1. Java Prioritizes Platform Independence & Simplicity

* Java was designed to be portable and fast across many platforms
* Managing bit-level memory inside arrays is more complex and error-prone
* So for `boolean[]`, Java just stores each `boolean` as a full byte, for simplicity

#### 2. Accessing Individual Bits is Slower Than Accessing Bytes

* Accessing a single bit would require:
  * Computing the byte offset
  * Applying a bitmask
  * Doing bitwise operations
* That's slower than just reading a byte directly from memory

#### 3. Memory Alignment and Word Boundaries

* Modern CPUs read memory in chunks (words, typically 4 or 8 bytes)
* If booleans were packed into bits, it would complicate alignment
* Using 1 byte per `boolean` allows faster access at the hardware level

#### 4. Object Header and Array Overhead Stay the Same

* Even if Java stored bits compactly, the array would still carry its object overhead (around 12–24 bytes), which dilutes memory savings unless the array is huge

---

### Comparison

| Storage Type | Bits per boolean | Actual Java Storage |
| ------------ | ---------------- | ------------------- |
| `boolean`    | 1               | 1 byte (8 bits)     |
| `boolean[]`  | 1               | 1 byte per element  |
| `BitSet`     | 1               | 1 bit per element   |

---

## Proof in Code

```java
boolean[] arr = new boolean[1000];
System.out.println(arr.length);  // 1000 booleans

// Memory usage is roughly 1000 bytes + overhead
```

Compare to:

```java
BitSet bs = new BitSet(1000);
// BitSet uses ~125 bytes + overhead (1000 bits ≈ 125 bytes)
```

---

## What If You Want Bit-Level Efficiency?

Use:

* `BitSet` (built-in Java class for bit storage)
* `byte[]` with bitmasking (manual, more complex)
* External libraries like `RoaringBitmap` (for large sparse bitsets)

---

## TL;DR

* Java's `boolean[]` uses 1 byte per element for simplicity and speed
* It's not space-optimal — it trades space for access speed
* If you want memory-efficient storage of flags → use `BitSet`
