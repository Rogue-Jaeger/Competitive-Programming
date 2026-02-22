Java:
================================================

Semaphores: 
------------------------------------------------
Basically restricts the running of threads through `acquire(_number of slots_)` function, Which will wait until the required number of slots are available. 
Which will be made available through `release(_number of slots_)`.</br>
**NOTE:** `Semaphore sm = new Semaphore(_initial slots_)` : Here initial slots can be **0** and still if `sm.release(2)` is called on the semaphore it'll again give out **2** slots. 
e.g. [Leetcode Solution](https://leetcode.com/problems/building-h2o/solutions/3087135/java-simple-solution-approach-1-using-object-lock/)

return type of acquire is void not true or false indicating something
