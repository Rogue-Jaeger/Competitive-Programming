Length
====================================================
1. Java: <br>
   a. In ```String``` class: ```str.length()```
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
