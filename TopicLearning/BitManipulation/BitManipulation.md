In java at least you can infinitely do >> or << operations as the new value will again
be a 32 bit integer.

Somehow the sign bit doesn't shift right or left. e.g:

```
public void rangeBitwiseAnd(int left, int right) {
    int j = -1;

    for (int i = 0; i < 33; i++) {
        System.out.println(j);
        j = j<<1;
    }
}
```

Above code yields in:

```
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

Follow up question: How to determine if a bit is set or not at a particular position.

Java does a modulus operation before doing bitwise shift operation. i.e.

```1 << 31``` will result in ```-2147483648```
and then on the same number if you do ```1 << 1``` or ```1 << 2```
then it will yeild 0 because the only set bit is now overflown the size of int 
but if you do ```1 << 32``` or ```1 << 33``` it will yield in ```1``` and ```2``` respectivelly because the java does a modulus operation of the number of times the bit has to be shifted i.e.
```1 << 32 == 1 << (32 % 32) == 1 << 0 == 1```
so ```(1 << 31) + (1 << 1) != (1 << 32)```

In java there are 2 types of bit operations:

1. Signed Shift: Denoted by ```>>``` or ```<<```. This will preserve the sign of the original number.
2. Ungisned Shift: Denoted by ```>>>``` or ```<<<```. This won't preserve the sign of the original number.

XOR:
================================================

```XOR``` means exclusive ```OR``` which implicitly means that we take the output of ```OR``` operation which is:

```
0 | 0 = 0
0 | 1 = 1
1 | 0 = 1
1 | 1 = 1
```

and exclude something from it (the operation ```1 | 1 = 1```) or see it as its exclusive meaning only when there is a ```1``` and ```0``` they have something exclusive, but having ```1``` and ```1``` is not exclusive.

#### Properties:

Markdown works just like ```addition``` and ```subtraction``` and addition operation. i.e.

```
3 + 7 = 10
10 - 3 = 7 // We get our original number 7 back.
10 - 7 = 3 // We get our original number 3 back.
```

Similarly:

```
3 ^ 7 = 4
4 ^ 3 = 7 // We get our original number 7 back.
4 ^ 7 = 3 // We get our original number 3 back.
// NOTE: We're using same XOR operation 
// to get the original numbers back
// not like addition and subtraction
// where we had to use 2 ops for the same. 
```

This property is really helpful in range queries on substrings where we do ```bitwise XOR``` on every number in those ranges. i.e. ```XorQueriesOfASubarray.java // The solution is just like implementing prefix sums.```

XOR can easily be used to ```set``` or ```unset``` bits at a particular index if we know the bits are going to be different instead of performing operations like addition and subtraction. i.e. ```MinimizeXOR.java```

AND:
================================================

The ```AND``` operation ```1 & 3 = 1``` between 2 **positive** (*Will have to check for negetive integers.*) integers will never result in a number greater than the original 2 integers. 

BitCount:
================================================

Java has an inbuilt function to count the bits in an integer which is:
```Integer.bitCount(x)```
