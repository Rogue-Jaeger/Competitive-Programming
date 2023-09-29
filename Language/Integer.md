Java:
====================================================

The integer can also be initialized as ```int val = 10_000_000;```

By default, the int data type is a 32-bit signed two's complement integer, which has a minimum value of ```-2^31``` and a maximum value of ```2^31-1```. <br>
In Java SE 8 and later, you can use the int data type to represent an unsigned 32-bit integer, which has a minimum value of 0 and a maximum value of ```2^32-1```. <br>
Use the Integer class to use int data type as an unsigned integer. <br>
Static methods like ```compareUnsigned```, ```divideUnsigned``` etc have been added to the Integer class to support the arithmetic operations for unsigned integers.

C++:
====================================================

A maximum integer value that can be stored in an unsigned int data type is typically 4, 294, 967, 295, around 232 – 1(**but is compiler dependent**). <br>
The maximum value that can be stored in **unsigned int** is stored as a constant in the ```<climits>``` header file whose value can be used as ```UINT_MAX```. <br>
Declared as: ```unsigned int valueFromLimits = UINT_MAX;```

Javascript:
====================================================

How to check if value is a number:
1. typeof ```val === 'number'``` // Caveat is NaN is also considered a number.
2. ```Number.isInteger()``` // Caveat is it is limited to integer range so ```312331231e123123123``` will give false.
3. The solution for a value not being a number is:
```
typeof value !== 'number' || Number.isNaN(value)
```
