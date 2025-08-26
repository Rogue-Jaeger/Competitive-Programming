# Bit Manipulation in Java

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

## Understanding Bit Operations

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

## XOR Operations

XOR (exclusive OR) takes the output of OR operation but excludes when both inputs are 1:

```text
0 | 0 = 0
0 | 1 = 1
1 | 0 = 1
1 | 1 = 1
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

## AND Operations

The AND operation (`&`) between two positive integers never results in a number greater than either original integer. Note: Behavior may differ for negative integers.

## Bit Counting

Java provides a built-in function to count bits in an integer:

```java
Integer.bitCount(x)
```

## Checking Set Bits

When checking if a bit is set:

* Avoid using `(x & 1) > 0` - This fails with `Integer.MIN_VALUE` (`10000000000000000000000000000000`). (see `SingleNumber3.java`)
* Use `(x & 1) == 0` instead - Works correctly for both positive and negative numbers
