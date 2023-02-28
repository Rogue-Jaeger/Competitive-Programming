Boolean:
====================================================
### Java: ```false```


Primitive types:
====================================================
### Java:
```
byte, short, int, long -> 0
float, double -> 0.0
```

Char:
====================================================
### Java:

The default value of a char attribute is indeed ```\u0000``` (the null character) as stated in the Java Language Specification,
section [§4.12.5 Initial Values of Variables](http://docs.oracle.com/javase/specs/jls/se7/html/jls-4.html#jls-4.12.5).

In my system, the line ```System.out.println('\u0000');``` prints a little square, meaning that it's not a printable character - as expected.

It's important to note that ```\u0000``` is not the same value as ```null```, But it is same as ```\0```

My note is just that 'null character' is a character. It is not null in java terms i.e. ```\u0000 == null``` would return ```false```

The default value of a char data type is ```\u0000``` (or 0) and a maximum value of ```\uffff``` (or 65,535 inclusive).

Default value of Character is ```Character.MIN_VALUE``` which internally represented as ```MIN_VALUE = '\u0000'```. Printing ```MIN_VALUE``` gives no output.

To check: ```DEFAULT_CHAR.compareTo((Character) value) == 0```

Way to print default value of ```char``` otherwise it'll give ```might not have been declared``` issue.
```
public class Main
{
    static char a;
	public static void main(String[] args) {
		System.out.println(a);
	}
}
```
