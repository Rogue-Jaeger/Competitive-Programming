Length
====================================================
1. Java: <br>
   a. In ```String``` class: ```str.length()``` **IMP: Its not ```size()```**
2. C++: <br>
   a. In ```string``` class both ```str.length()``` and ```str.size()``` can be used. <br>
   b. <b> Notice the s is small in the string class in C++. </b> <br>

Get char at position
====================================================
1. Java: <br>
   a. In ```String``` class: ```str.charAt()```
2. C++: <br>
   a. In ```string``` class: ```str.at()``` <br>
   b. ```str[0]```

Substring
====================================================
1. Java: <br>
```
substring(startIndex - included in res, endIndex - excluded);
String s1="javatpoint";  
s1.substring(2,4) //returns va  
s1.substring(2) //returns vatpoint  
```
2. C++: <br>
```
substr(startIndex - included, numberOfElements);
string s1 = "Geeks";
string r = s1.substr(3, 2); // returns ks
```

Prefix Matching
====================================================
1. Java: <br>

**```indexOf()``` will return first index of occurrence of the word (_is case-sensitive_):** 
```
String myStr = "Hello planet earth, you are a great planet.";
System.out.println(myStr.indexOf("Hello")); // Will print 0
System.out.println(myStr.indexOf("hello")); // Will print -1
```

Join list of strings
====================================================
1. Java: <br>

```String str = String.join("", list);```

Clear string
====================================================
1. Java: <br>

String Builder:
```
StringBuilder sb = new StringBuilder();
sb = ""; // Will give an error saying String cannot be converted to String Builder.
```
So to clear a String Builder object just do:
```sb.setLength(0);```
This will clear all the contents inside of the string.

String Builder
====================================================
Pretty much do everything using .toString() function as string builder doesn't support normal string functions. e.g.

1. To convert to char array for shorthand for loop traversal in java:
```
sb.toString().toCharArray()
```
2. To convert string builder object to string:
```
Integer.parseInt(sb.toString());
```
toCharArray for getting chars from for loop from string 

https://stackoverflow.com/questions/22439177/why-is-stringbuilder-much-faster-than-string
