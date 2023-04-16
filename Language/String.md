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
