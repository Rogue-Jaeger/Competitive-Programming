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
