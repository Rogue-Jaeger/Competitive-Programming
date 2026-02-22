Java:
------------------------------------------------

### Power 
```Math.pow(a, b)``` means ```a^b```

### Ceil
```Math.ceil(double x)``` function takes values of data type double which means that in cases of doing integer divisions in java, i.e.

```Math.ceil(3 / 2)``` It'll give ```1``` instead of ```2``` which is the desired output.

In order to resolve this we have to do type casting just after doing the integer division so that the ```Math.ceil()``` function may get the desired input. i.e.

```Math.ceil((double) 3 / 2)``` will result in the desired output which is ```2```.

```Math.pow(a, b)``` means ```a^b``` << This is a XOR operation

int result = (int) 2e9; means 2 * 10^9 --- works in java
