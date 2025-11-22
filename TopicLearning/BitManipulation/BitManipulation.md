# Bit Manipulation in Java

---

## Bit Shifting Behavior

In Java, you can perform infinite right shift (`>>`) or left shift (`<<`) operations as the result is always converted back to a 32-bit integer.

The sign bit behaves specially during shifts. Here's an example:

```java
public void rangeBitwiseAnd(int left, int right) {
    int j = -1;

    for (int i = 0; i < 33; i++) {
        System.out.println(j);
        j = j<<1;
    }
}
```

Above code yields in:

```text
-1
-2
-4
-8
-16
-32
-64
-128
-256
-512
-1024
-2048
-4096
-8192
-16384
-32768
-65536
-131072
-262144
-524288
-1048576
-2097152
-4194304
-8388608
-16777216
-33554432
-67108864
-134217728
-268435456
-536870912
-1073741824
-2147483648
0
```

## Bit Operations

---

### Shift Operations

Java performs a modulus operation before doing bitwise shift operations:

* `1 << 31` results in `-2147483648`
* If you then do `1 << 1` or `1 << 2`, it yields 0 (set bit overflows int size)
* With `1 << 32` or `1 << 33`, you get `1` and `2` respectively due to modulus
* Example: `1 << 32 == 1 << (32 % 32) == 1 << 0 == 1`
* Note that `(1 << 31) + (1 << 1) != (1 << 32)`

Java has two types of bit shifts:

1. Signed Shift (`>>`, `<<`): Preserves the sign of the original number
2. Unsigned Shift (`>>>`, `<<<`): Does not preserve the sign

### XOR Operations

XOR (exclusive OR) takes the output of OR operation but excludes when both inputs are 1:

```text
0 | 0 = 0
0 | 1 = 1
1 | 0 = 1
1 | 1 = 1 // This gets excluded for Exclusive OR.
```

### XOR Properties

XOR behaves similar to addition and subtraction:

```text
3 ^ 7 = 4
4 ^ 3 = 7  // Original number 7 recovered
4 ^ 7 = 3  // Original number 3 recovered
```

This property is useful in:

* Range queries on substrings with bitwise XOR (see `XorQueriesOfASubarray.java // The solution is just like implementing prefix sums.`)
* Setting/unsetting bits at specific indices if we know the bits are going to be different instead of performing operations like addition and subtraction. (see `MinimizeXOR.java`)

### AND Operations

The AND operation (`&`) between two positive integers never results in a number greater than either original integer. Note: Behavior may differ for negative integers.

## Bit Tricks

---

### Checking if an integer is a power of 2

Now as subtracting one from a number removes its least significant set bit and replaces all the zeros to the right side of it to ones like so:

```text
00101000 -> (00101000 - 1) -> 00100111
```

Now we know that powers of 2 only have one set bit so we subtract one from it and do and and operation to check if the value is 0 like so:

```text
n & (n − 1) == 0
```

**NOTE: This trick doesn't work on negetive numbers like so:**

```text
e.g.
n = INT_MIN
n & (n−1) = 0   ← true!
```

### Getting least significant bit

**Extract LSB using `n & -n`**

This isolates the **lowest set bit** of `n`.

**Why it works:**

* `-n` is called two’s complement: invert all bits of `n` and add 1.
* This isolates the lowest 1-bit: bits above cancel out, bits below become 0.
* ANDing `n & -n` keeps only the lowest set bit.

**Examples:**

```text
n = 12 (1100)
-n = -12 (0100) // -n is called 2's complement, Sign bit also gets inverted
n & -n = 0100 → 4
```

```text
n = 10 (..001010)
-n = -10 (..110110)
n & -n = ..000010 → 2
```

### Bit Counting

Java provides a built-in function to count bits in an integer:

```java
Integer.bitCount(x)
```

### Checking Set Bits

When checking if a bit is set:

* Avoid using `(x & 1) > 0` - This fails with `Integer.MIN_VALUE` (`10000000000000000000000000000000`). (see `SingleNumber3.java`)
* Use `(x & 1) == 0` instead - Works correctly for both positive and negative numbers
* `(i & mask) > 0` is **wrong** because the result of `(i & mask)` can be **negative** when the mask hits the **sign bit** (`10000000000000000000000000000000`). So even if the bit *is set*, the value is negative → `> 0` becomes **false**.
* `(i & mask) == 0` (or `!= 0`) is **always correct**, because it only checks whether the result is **zero or non-zero**, not whether it’s positive.

```text
When the mask points to the **leftmost bit** (the sign bit):

mask = 10000000000000000000000000000000

Then checking a number like `-1`:

-1 in binary = 11111111111111111111111111111111

Do AND:

-1 & mask =
11111111111111111111111111111111
&10000000000000000000000000000000
---------------------------------
 10000000000000000000000000000000

This result is **negative** in signed 32-bit integers.

So:

(i & mask) > 0   → FALSE (because the result is negative)

Even though the bit is clearly 1.

Why `(i & mask) == 0` works

Because the result can only be:

0                   → bit is 0
10000000000000000000000000000000 → bit is 1

Checking:

== 0   → correct
!= 0   → correct

No sign confusion.
```
