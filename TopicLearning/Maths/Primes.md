Sieve of Eratosthenes:
------------------------------------------------

1. It is used to calculate number of primes within a given range.
2. Idea is to just populate the whole numbers in the range and the left numbers will be primes.
3. So the complexity is somewhere less than n, Online it shows O(n*log(log(n))).
4. We will be maintaining an array of boolean indicating if the value at index is a whole number or not.
5. The first loop will start from 2 and go to the square root of the last number in the range. Suppose the range is till 100 so square root of 100 is ±10.
After 10*10 if we go ahead to 11, We won't be able to multiply 11 with value greater than 10 i.e. 11*9. And 9 would already have been considered
before we reached 10*10, So it would be a repetition. It's basically because of the associative property.
6. The second loop will start from 2 as well as if we start from 1 and in the array if we do 5*1 it will consider it as a whole number.
7. If we go through the way where we calculate for every number in the range if it's divisible by prime numbers less than it as every number 
is at last a combination of prime factorization, Then its complexity will be O(n * sqrt(n)) which is not ideal.
8. Counting the primes by just checking % for every prime number less than current number (consider primes till square root of current number) will also yield in the complexity of O(n * sqrt(n)).
9. Just go to ```CountPrimes.java``` for detailed explanation.

Sqrt of N:
------------------------------------------------

1. It's better to just figure out if a single number is a prime number or not. Not to count primes till the current number.
