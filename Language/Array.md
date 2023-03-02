Declare and initialize:
================================================

Java:
------------------------------------------------

**IMP: Dont access the arraylist same as ```[]``` use ```get()``` method.** <br>
**IMP: Set value in an array at some index: (_Index is the first argument_) ```list.set(2, "Violet");```** <br>
**IMP: Add value in an array at some index: (_Index is the first argument_) ```list.add(2, "Violet");```** <br>
**IMP: ```List.add()``` returns a boolean value. So don't do ```list1.add(list2.add(val));```** <br>
**IMP: For ```int[] nums``` ```Arrays.asList(nums)``` will not work as nums is ```int[]``` not ```Integer[]```. Sol: ```Arrays.stream(nums).boxed().collect(Collectors.toList()```**

You can either use array declaration or array literal (but only when you declare and affect the variable right away, array literals cannot be used for re-assigning an array).

For primitive types:
```
int[] myIntArray = new int[3]; // each element of the array is initialised to 0
int[] myIntArray = {1, 2, 3};
int[] myIntArray = new int[]{1, 2, 3};
boolean[][] visited = new boolean[board.length][board[0].length]; // Create space dynamically

// Since Java 8. Doc of IntStream: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html

int [] myIntArray = IntStream.range(0, 100).toArray(); // From 0 to 99
int [] myIntArray = IntStream.rangeClosed(0, 100).toArray(); // From 0 to 100
int [] myIntArray = IntStream.of(12,25,36,85,28,96,47).toArray(); // The order is preserved.
int [] myIntArray = IntStream.of(12,25,36,85,28,96,47).sorted().toArray(); // Sort 
```

For classes, for example ```String```, it's the same:

```
String[] myStringArray = new String[3]; // each element is initialised to null
String[] myStringArray = {"a", "b", "c"};
String[] myStringArray = new String[]{"a", "b", "c"};
String[] array = new String[] {"a", "b"};
```

The third way of initializing is useful when you declare an array first and then initialize it, pass an array as a function argument, or return an array. The explicit type is required.

#### String[] myStringArray;
```
myStringArray = new String[]{"a", "b", "c"};
```

#### Multidimensional Arrays:
```
int[] num[] = new int[5][2];
OR
int[][] num={ {1,2}, {1,2}, {1,2}, {1,2}, {1,2} };
```
```
RAGGED ARRAY:
int[][] num = new int[5][];
num[0] = new int[1];
num[1] = new int[5];
num[2] = new int[2];
num[3] = new int[3];
OR
int[][] num={ {1}, {1,2}, {1,2,3,4,5}, {1,2}, {1,2,3} };
```

#### Initialization values:

A newly created array 1D or 2D in java will initialize by default by the value 0 for byte, short, char, and int type, <br>
0.0 for floating-point arrays like float and double, false for boolean arrays, and null for an array of reference type like String array elements.

Read more here: [Arrays](https://www.java67.com/2014/10/how-to-create-and-initialize-two-dimensional-array-java-example.html#ixzz7tyOZQ8FD)

C++
------------------------------------------------

One Dimenstional Arrays:

```
int arr[] = { 10, 20, 30, 40}
arr[3 / 2] // this is same as arr[1] = 2
char str[] = "abc";
char* str = "abc";
char str[3] = "abc"; // str has type char[3] and holds 'a', 'b', 'c'
int y[5] = {1,2,3}; // y has type int[5] and holds 1,2,3,0,0 <- IMPP
int n[5] = {[4]=5,[0]=1,2,3,4}; // holds 1,2,3,4,5
```

Multidimensional arrays:
```
int y[4][3] = { // array of 4 arrays of 3 ints each (4x3 matrix)
    { 1 },      // row 0 initialized to {1, 0, 0}
    { 0, 1 },   // row 1 initialized to {0, 1, 0}
    { [2]=1 },  // row 2 initialized to {0, 0, 1}
};              // row 3 initialized ********to {0, 0, 0}
```

Length:
================================================

Java:
------------------------------------------------

```
int[] array = new int[4];
array.length // field
```

Same for non-primitive types:
```
String[] str = { "GEEKS", "FOR", "GEEKS" };
str.length // field
```

For wrapper classes for arrays like: ArrayList:
```
ArrayList<String> arr = new ArrayList<>();
arr.size() // method call and not a field
```

C++:
------------------------------------------------

```
int myNumbers[5] = {10, 20, 30, 40, 50};
sizeof(myNumbers) / sizeof(int);
```

For non-primitive types:
```
vector<int> g1;
g1.size()
```

Cloning:
================================================

Java:
------------------------------------------------

#### Primitive types:
```
int[] numbers = new int[nums.length];
numbers = nums.clone();
```
