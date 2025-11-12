# Euclidean GCD

## Why Euclidean GCD Works

Suppose we have 2 numbers where `a > b`. Then `a` can be written as:

```text
a = b * q + r
```

We can rearrange this equation as:

```text
r = a - b * q  ... (equation 1)
```

Now suppose there is a number `x` which divides both `a` and `b`, and that number is the greatest common divisor. We can write:

```text
a = x * m
b = x * n
```

Replacing `a` and `b` in equation 1:

```text
r = x * m - x * n * q
```

We can factor out `x`:

```text
r = x * (m - n * q)
```

This shows that `r` is also divisible by `x` (the GCD). Therefore, the GCD of `a` and `b` is the same as the GCD of `b` and `r`, which is the basis of the Euclidean algorithm.

## Time Complexity

The time complexity of this solution is **O(log(min(a, b)))**.
