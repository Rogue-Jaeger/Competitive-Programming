# Power of 3 (No Loops)

Solution with no loops (works for all prime numbers; 3 is prime here):

```java
// Returns true if n is a power of 3
boolean isPowerOf3(int n) {
    return n > 0 && 1162261467 % n == 0; // 1162261467 == 3^19. Here, 3^19 is the maximum value before integer overflow for int type.
}
```
